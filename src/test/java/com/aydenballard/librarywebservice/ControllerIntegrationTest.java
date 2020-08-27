package com.aydenballard.librarywebservice;

import com.aydenballard.librarywebservice.controller.BookNotFoundAdvice;
import com.aydenballard.librarywebservice.controller.BookNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ControllerIntegrationTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository mockRepository;

    @Before
    public void init(){
        Book book = new Book(new Long(1), "Moller","Modelling Computing Systems",
                "NONFICTION", false);
        when(mockRepository.findById(new Long(1))).thenReturn(Optional.of(book));
    }

    @Test
    public void findBookById() throws Exception{
        mockMvc.perform(get("/book/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.author", is("Moller")))
                .andExpect(jsonPath("$.title", is("Modelling Computing Systems")))
                .andExpect(jsonPath("$.genre", is("nonfiction")))
                .andExpect(jsonPath("$.rented", is(false)));
    }

    @Test
    public void findBookNotFound() throws Exception{
        mockMvc.perform(get("/books/10")).andExpect(status().isNotFound());
    }

    @Test
    public void saveBookOk() throws Exception{
        Book book = new Book (new Long(2), "Rowling", "Harry Potter and the goblet of fire",
                "FANTASY", false);
        when(mockRepository.save(any(Book.class))).thenReturn(book);

        mockMvc.perform(post("/allbooks")
                .content(om.writeValueAsString(book))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.author", is("Rowling")))
                .andExpect(jsonPath("$.title", is("Harry Potter and the goblet of fire")))
                .andExpect(jsonPath("$.genre", is("fantasy")))
                .andExpect(jsonPath("$.rented", is(false)));
    }

    @Test
    public void updateBookOk() throws Exception{
        Book updateBook = new Book(new Long(1), "Tolkien", "The Hobbit",
                "FANTASY", true);
        when(mockRepository.save(any(Book.class))).thenReturn(updateBook);
        mockMvc.perform(put("/book/1")
                .content(om.writeValueAsString(updateBook))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.author", is("Tolkien")))
                .andExpect(jsonPath("$.title", is("The Hobbit")))
                .andExpect(jsonPath("$.genre", is("fantasy")))
                .andExpect(jsonPath("$.rented", is(true)));
    }

    @Test
    public void deleteBookOk() throws Exception{
        doNothing().when(mockRepository).deleteById(new Long(1));
        mockMvc.perform(delete("/book/1"))
                .andExpect(status().isOk());
    }

}

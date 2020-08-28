package com.aydenballard.librarywebservice.controller;

import com.aydenballard.librarywebservice.Book;
import com.aydenballard.librarywebservice.BookListFilter;
import com.aydenballard.librarywebservice.BookNotFoundException;
import com.aydenballard.librarywebservice.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    private final BookRepository repository; //repository for books

    /**
     * Constructor for BookController
     * @param repository - repository that stores books
     */
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // Aggregate Root

    /**
     * Base URL to return simple "Hello world" message
     * @return
     */
    @RequestMapping("/")
    public String defaultGreeting(){
        return "Hello world";
    }

    /**
     * "/allbooks" URL to return all books in the system as a JSON Array
     * @return JSON Array of all books in system
     */
    @GetMapping("/allbooks")
    public List<Book> allBooks(){
        return repository.findAll();
    }

    /**
     * Method to create a new book into the system
     * @param newBook - new book to be added to repository
     * @return Book - new book
     */
    @PostMapping("/allbooks")
    @ResponseStatus(HttpStatus.CREATED)
    public Book newBook(@RequestBody Book newBook){
        return repository.save(newBook);
    }

    // Single Item

    /**
     * Get method to get a book specified by ID from the repository
     * @param id - ID of book to be collected
     * @return Book - book matching ID
     */
    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable Long id) throws BookNotFoundException {
        return repository.findById(id).orElseThrow( () -> new BookNotFoundException(id));
    }

    /**
     * Put method to replace/update a book currently in the repository
     * @param newBook - book to replace previous book
     * @param id - id of book to be replaced
     * @return Book - newly updated book
     */
    @PutMapping("/book/{id}")
    public Book replaceBook(@RequestBody Book newBook, @PathVariable Long id){
        return repository.findById(id).map(book -> {
            book.setAuthor(newBook.getAuthor());
            book.setTitle(newBook.getTitle());
            book.setGenre(newBook.getGenre());
            book.setRented(newBook.getRented());
            return repository.save(book);
        }).orElseGet(() -> {
           newBook.setId(id);
           return repository.save(newBook);
        });
    }

    /**
     * Delete method to delete a book specified by ID from the repository
     * @param id - id of book to be deleted
     */
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id){
        repository.deleteById(id);
    }

    /**
     * "/books" to return books matching the properties entered in the query
     * parameters
     * @param customQuery - query parameters of author, title, genre and rented
     * @return JSON Array of books in system matching query parameters
     */
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getBooks(@RequestParam Map<String,String> customQuery){
        List books = repository.findAll();
        if(customQuery.containsKey("genre")){
            books = BookListFilter.filterGenre(books, customQuery.get("genre")); //filter genre
        }
        if(customQuery.containsKey("title")){
            books = BookListFilter.filterTitle(books, customQuery.get("title")); //filter title
        }
        if(customQuery.containsKey("author")){
            books = BookListFilter.filterAuthor(books, customQuery.get("author")); //filter author
        }
        if(customQuery.containsKey("rented")){
            if(customQuery.get("rented").equalsIgnoreCase("true")){ //filter rented
                books = BookListFilter.filterRented(books, true);
            } else {
                books = BookListFilter.filterRented(books, false);
            }
        }
        return books;
    }



}

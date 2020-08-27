package com.aydenballard.librarywebservice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookListFilterTest {

    /**
     * Method to initialise a List of Book objects with test data
     * @return List - List of book objects
     */
    private List<Book> initialiseBookList(){
        List<Book> bookList = new ArrayList<>();
        //filling book list with test data
        bookList.add(new Book("Moller","Modelling Computing Systems",
                "NONFICTION", false));
        bookList.add(new Book ("Rowling", "Harry Potter and the goblet of fire",
                "FANTASY", false));
        bookList.add(new Book ( "Austen", "Pride and Prejudice",
                "FICTION", false));
        bookList.add(new Book ("Rowling", "Harry Potter and the chamber of secrets",
                "FANTASY", true));
        bookList.add(new Book ("Adams", "Pandora's Box",
                "NONFICTION", true));
        bookList.add(new Book ("Tolkien", "The Hobbit",
                "FANTASY", true));
        return bookList;
    }

    /**
     * Method to test the filtering of genre on a List of books
     */
    @Test
    void filterGenre() {
        //given
        List<Book> bookList = initialiseBookList();
        //when
        bookList = BookListFilter.filterGenre(bookList,"fantasy");
        //then
        assertEquals(bookList.size(), 3);
    }

    /**
     * Method to test the filtering of author on a List of books
     */
    @Test
    void filterAuthor() {
        //given
        List<Book> bookList = initialiseBookList();
        //when
        bookList = BookListFilter.filterAuthor(bookList,"Rowling");
        //then
        assertEquals(bookList.size(), 2);
    }

    /**
     * Method to test the filtering of title on a List of books
     */
    @Test
    void filterTitle() {
        //given
        List<Book> bookList = initialiseBookList();
        //when
        bookList = BookListFilter.filterTitle(bookList,"Modelling Computing Systems");
        //then
        assertEquals(bookList.get(0).getTitle(),"Modelling Computing Systems");
    }

    /**
     * Method to test the filtering of rented on a List of books
     */
    @Test
    void filterRented() {
        //given
        List<Book> bookList = initialiseBookList();
        //when
        bookList = BookListFilter.filterRented(bookList,true);
        //then
        assertEquals(bookList.size(),3);
    }
}
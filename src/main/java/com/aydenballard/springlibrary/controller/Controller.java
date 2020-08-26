package com.aydenballard.springlibrary.controller;

import com.aydenballard.springlibrary.Book;
import com.aydenballard.springlibrary.BookListFilter;
import com.aydenballard.springlibrary.SpringlibraryApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @RequestMapping("/")
    public String defaultGreeting(){
        return "Hello world";
    }

    @RequestMapping("/allbooks")
    public List<Book> allBooks(){
        List<Book> books = SpringlibraryApplication.bookHashMapToList();
        return books;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getBooks(@RequestParam Map<String,String> customQuery){
        List books = SpringlibraryApplication.bookHashMapToList();

        if(customQuery.containsKey("genre")){
            books = BookListFilter.filterGenre(books, customQuery.get("genre"));
        }
        if(customQuery.containsKey("title")){
            books = BookListFilter.filterTitle(books, customQuery.get("title"));
        }
        if(customQuery.containsKey("author")){
            books = BookListFilter.filterAuthor(books, customQuery.get("author"));
        }
        if(customQuery.containsKey("rented")){
            if(customQuery.get("rented").equalsIgnoreCase("true")){
                books = BookListFilter.filterRented(books, true);
            } else {
                books = BookListFilter.filterRented(books, false);
            }
        }

        return books;
    }



}

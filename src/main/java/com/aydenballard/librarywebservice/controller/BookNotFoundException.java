package com.aydenballard.librarywebservice.controller;

public class BookNotFoundException extends RuntimeException {

    /**
     * Constructor for BookNotFoundException
     * @param id - id of book which is not found
     */
    public BookNotFoundException(Long id){
        super("Could not find book with id: " + id);
    }
}

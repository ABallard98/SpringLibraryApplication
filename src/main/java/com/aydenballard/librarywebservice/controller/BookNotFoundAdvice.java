package com.aydenballard.librarywebservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookNotFoundAdvice {

    /**
     * Method to show exception error in the body of the webpage
     * @param exception - exception to be displayed
     * @return String - string containing error message
     */
    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String bookNotFoundHandler(BookNotFoundException exception){
        return exception.getMessage();
    }

}

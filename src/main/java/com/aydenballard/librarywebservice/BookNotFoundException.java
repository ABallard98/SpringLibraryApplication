/**
 * Exception class for when a book is not found in the repository,
 * extends from RunTimeException
 * @Author Ayden Ballard
 */

package com.aydenballard.librarywebservice;

public class BookNotFoundException extends RuntimeException {

    /**
     * Constructor for BookNotFoundException
     * @param id - id of book which is not found
     */
    public BookNotFoundException(Long id){
        super("Could not find book with id: " + id);
    }
}

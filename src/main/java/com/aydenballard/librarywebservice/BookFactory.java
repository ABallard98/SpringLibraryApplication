package com.aydenballard.librarywebservice;

public class BookFactory {

    /**
     * Method to construct and return a new Book object
     * @param author - author of book
     * @param title - title of book
     * @param genre - genre of book
     * @param rented - rented out or not
     * @return Book - new Book Object
     */
    public static Book makeBook(String author, String title, String genre, boolean rented){
        return new Book(author, title, genre, rented);
    }

    /**
     * Method to construct and return a new Book object
     * @param author - author of book
     * @param title - title of book
     * @param genre - genre of book
     * @return Book - new Book Object
     */
    public static Book makeBook(String author, String title, String genre){
        return new Book(author, title, genre);
    }

}

package com.aydenballard.springlibrary;

public class BookFactory {

    public static Book makeBook(String author, String title, String genre, boolean rented){
        return new Book(author, title, genre, rented);
    }

    public static Book makeBook(String author, String title, String genre){
        return new Book(author, title, genre);
    }

}

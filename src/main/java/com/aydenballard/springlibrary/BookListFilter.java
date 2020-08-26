package com.aydenballard.springlibrary;

import java.util.ArrayList;
import java.util.List;

public class BookListFilter {

    public synchronized static List<Book> filterGenre(List<Book> books, String genre){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getGenre().equalsIgnoreCase(genre)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    public synchronized static List<Book> filterAuthor(List<Book> books, String author){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    public synchronized static List<Book> filterTitle(List<Book> books, String title){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    public synchronized static List<Book> filterRented(List<Book> books, boolean rented){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getRented() == rented){
                toReturn.add(book);
            }
        }
        return toReturn;
    }



}

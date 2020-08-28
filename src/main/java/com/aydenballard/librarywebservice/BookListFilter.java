/**
 * Class containing static methods to perform filtering operations on
 * a list of book objects
 * @Author Ayden Ballard
 */

package com.aydenballard.librarywebservice;

import java.util.ArrayList;
import java.util.List;

public class BookListFilter {

    //todo test these methods

    /**
     * Method to remove books from list that do not match the genre
     * @param books - list of books to filter
     * @param genre - genre
     * @return List
     */
    public synchronized static List<Book> filterGenre(List<Book> books, String genre){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getGenre().equalsIgnoreCase(genre)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    /**
     * Method to remove books from list that do not match the author
     * @param books - list of books to filter
     * @param author - surname of author
     * @return List
     */
    public synchronized static List<Book> filterAuthor(List<Book> books, String author){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    /**
     * Method to remove books from list that do not match the title
     * @param books - list of books to filter
     * @param title - title of book
     * @return List
     */
    public synchronized static List<Book> filterTitle(List<Book> books, String title){
        List<Book> toReturn = new ArrayList<>();
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    /**
     * Method to remove books from list that are/are not rented out
     * @param books - list of books to filter
     * @param rented - boolean rented
     * @return List
     */
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

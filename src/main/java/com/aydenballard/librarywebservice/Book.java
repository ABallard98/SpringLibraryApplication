/**
 * Class to represent a book object.
 * Contains the author, title, genre of the book and a boolean 'rented' for if the
 * book is currently checked out or not.
 * @Author Ayden Ballard
 */

package com.aydenballard.librarywebservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {

    private @Id @GeneratedValue Long id;
    private String author; //author of book
    private String title; //title of book
    private String genre; //genre of book
    private boolean rented; //true if currently checked out

    /**
     * Empty constructor for book object
     */
    public Book() {

    }

    /**
     * Constructor for book object
     * @param author - author of book
     * @param title - title of book
     * @param genre - genre of book
     * @param rented - rented out or not
     */
    public Book(String author, String title, String genre, boolean rented){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.rented = rented;
    }

    public Book(Long id, String author, String title, String genre, boolean rented){
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.rented = rented;
    }

    /**
     * Constructor for book object, default rented to false
     * @param author - author of book
     * @param title - title of book
     * @param genre - genre of book
     */
    public Book(String author, String title, String genre){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.rented = false;
    }

    /**
     * Method to get the id of the book
     * @return Long - Id
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Method to set the id of a book
     * @param id - id to be set
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Method to return author of book
     * @return String - author
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * Method to return title of book
     * @return String - title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Method to return true if book is checked out
     * @return boolean - rented
     */
    public boolean getRented(){
        return this.rented;
    }

    /**
     * Method to return genre of book
     * @return String - genre
     */
    public String getGenre(){
        return this.genre.toString().toLowerCase();
    }

    /**
     * Method to set the author of book
     * @param author - author of book
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * Method to set the title of book
     * @param title - title of book
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Method to set the genre of book
     * @param genre - genre of book
     */
    public void setGenre(String genre){
        this.genre = genre;
    }

    /**
     * Method to set the rented boolean of book
     * @param rented - true if rented else false
     */
    public void setRented(boolean rented){
        this.rented = rented;
    }

    /**
     * Method to compare this object with another to see if equal or not
     * @param o - object to be compared with
     * @return boolean - true if equal else false
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title) &&
                Objects.equals(this.author, book.author);
    }

    /**
     * Method to return details of book in String form
     * @return String - details of book
     */
    @Override
    public String toString(){
        return "Author: " + this.author + "\nTitle:" + this.title +
                "\nGenre:" + this.getGenre() + "\nChecked out: " + this.rented;
    }
}

package com.aydenballard.springlibrary;

public class Book {

    private String author;
    private String title;
    private String genre;
    private boolean rented;

    public Book(String author, String title, String genre, boolean rented){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.rented = rented;
    }

    public Book(String author, String title, String genre){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.rented = false;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean getRented(){
        return this.rented;
    }

    public String getGenre(){
        return this.genre.toString().toLowerCase();
    }

    public String toString(){
        return "Author: " + this.author + "\nTitle:" + this.title +
                "\nGenre:" + this.getGenre() + "\nChecked out: " + this.rented;
    }
}

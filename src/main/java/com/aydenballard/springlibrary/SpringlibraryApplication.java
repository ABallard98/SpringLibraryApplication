package com.aydenballard.springlibrary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class SpringlibraryApplication {

    public static HashMap<Integer, Book> bookHashMap;

    public static void main(String[] args) {
        SpringApplication.run(SpringlibraryApplication.class, args);
        bookHashMap = new HashMap<>();
        generateTestBooks();
    }

    private static void generateTestBooks(){
        Book b1 = BookFactory.makeBook("Moller","Modelling Computing Systems",
                "NONFICTION", false);
        bookHashMap.put(b1.hashCode(), b1);

        Book b2 = BookFactory.makeBook("Rowling", "Harry Potter and the goblet of fire",
                "FANTASY", false);
        bookHashMap.put(b2.hashCode(), b2);

        Book b3 = BookFactory.makeBook("Austen", "Pride and Prejudice",
                "FICTION", false);
        bookHashMap.put(b3.hashCode(), b3);

        Book b4 = BookFactory.makeBook("Rowling", "Harry Potter and the chamber of secrets",
                "FANTASY", true);
        bookHashMap.put(b4.hashCode(), b4);

        Book b5 = BookFactory.makeBook("Adams", "Pandora's Box",
                "NONFICTION", false);
        bookHashMap.put(b5.hashCode(), b5);

        Book b6 = BookFactory.makeBook("Tolkien", "The Hobbit",
                "FANTASY", true);
        bookHashMap.put(b6.hashCode(), b6);
    }

    public static List<Book> bookHashMapToList(){
        List toReturn = new ArrayList<>();
        for(int key : bookHashMap.keySet()){
            toReturn.add(bookHashMap.get(key));
        }
        return  toReturn;
    }

}

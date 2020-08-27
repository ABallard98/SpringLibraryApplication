package com.aydenballard.librarywebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    //Logger of database
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    /**
     * Method to load books in to database on boot up
     * @param repository - repository to store books
     * @return initDatabase - database containing books
     */
    @Bean
    CommandLineRunner initDatabase(BookRepository repository){
        return args -> {
            LOGGER.info("Preloading " + repository.save(new Book("Moller","Modelling Computing Systems",
                    "NONFICTION", false)));
            LOGGER.info("Preloading " + repository.save(new Book ("Rowling", "Harry Potter and the goblet of fire",
                    "FANTASY", false)));

            LOGGER.info("Preloading " + repository.save(new Book ( "Austen", "Pride and Prejudice",
                    "FICTION", false)));

            LOGGER.info("Preloading " + repository.save(new Book ("Rowling", "Harry Potter and the chamber of secrets",
                            "FANTASY", true)));

            LOGGER.info("Preloading " + repository.save(new Book ("Adams", "Pandora's Box",
                    "NONFICTION", false)));

            LOGGER.info("Preloading " + repository.save(new Book ("Tolkien", "The Hobbit",
                    "FANTASY", true)));
        };
    }

}

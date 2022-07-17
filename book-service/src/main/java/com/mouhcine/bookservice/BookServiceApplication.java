package com.mouhcine.bookservice;

import com.mouhcine.bookservice.domain.BookEntity;
import com.mouhcine.bookservice.domain.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(BookRepository bookRepository){
        return args -> {
            bookRepository.save(new BookEntity(1L, "Book1", 10));
            bookRepository.save(new BookEntity(2L, "Book2", 20));
            bookRepository.save(new BookEntity(3L, "Book3", 30));
        };
    }

}

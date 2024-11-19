package com.mehmedmaljoki.webtestswithselenide;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @GetMapping
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1L, "40", "Effective Java"),
                new Book(2L, "42", "Head First Principles"),
                new Book(3L, "7", "C Programming Language")
        );
    }
}

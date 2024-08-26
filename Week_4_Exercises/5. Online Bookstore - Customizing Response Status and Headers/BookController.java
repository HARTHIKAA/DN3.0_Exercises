package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // POST: Create a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Set HTTP status to 201 Created
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Other methods...
}

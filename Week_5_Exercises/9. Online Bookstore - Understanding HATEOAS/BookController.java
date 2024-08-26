package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    @PostMapping
    public ResponseEntity<EntityModel<Book>> createBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        Book savedBook = bookRepository.save(book);

        EntityModel<Book> resource = EntityModel.of(savedBook);
        resource.add(linkTo(methodOn(BookController.class).getBookById(savedBook.getId())).withSelfRel());
        resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));

        return ResponseEntity.ok(resource);
    }

    // Read all books
    @GetMapping
    public List<EntityModel<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> EntityModel.of(book)
                        .add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel())
                        .add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books")))
                .collect(Collectors.toList());
    }

    // Read a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Book book = bookOptional.get();
        EntityModel<Book> resource = EntityModel.of(book);
        resource.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
        resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));

        return ResponseEntity.ok(resource);
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Book book = bookOptional.get();
        book.updateFromDTO(bookDTO);
        Book updatedBook = bookRepository.save(book);

        EntityModel<Book> resource = EntityModel.of(updatedBook);
        resource.add(linkTo(methodOn(BookController.class).getBookById(updatedBook.getId())).withSelfRel());
        resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));

        return ResponseEntity.ok(resource);
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

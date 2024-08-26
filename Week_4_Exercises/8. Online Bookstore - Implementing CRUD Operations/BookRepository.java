package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

package com.example.bookstoreapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private double price;
    private String isbn;

    @Version
    private Integer version;

    // Constructor, getters, setters, and methods like updateFromDTO
}

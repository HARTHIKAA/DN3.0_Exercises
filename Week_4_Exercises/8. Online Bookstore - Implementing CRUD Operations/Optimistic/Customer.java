package com.example.bookstoreapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;

    @Version
    private Integer version;

    // Constructor, getters, setters, and methods like updateFromDTO
}

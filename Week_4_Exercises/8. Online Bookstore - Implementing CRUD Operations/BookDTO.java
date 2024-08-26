package com.example.bookstoreapi.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    private Long id;

    @NotNull(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotNull(message = "Author is required")
    private String author;

    @Min(value = 0, message = "Price must be a positive number")
    private double price;

    @NotNull(message = "ISBN is required")
    private String isbn;
}

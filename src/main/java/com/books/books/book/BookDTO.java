package com.books.books.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Long id;

    @NotBlank(message = "Pole 'isbn' nie może być puste.")
    private String isbn;

    @NotBlank(message = "Pole 'title' nie może być puste.")
    private String title;

    @NotBlank(message = "Pole 'author' nie może być puste.")
    private String author;

    @NotBlank(message = "Pole 'puyblisher' nie może być puste.")
    private String publisher;

    @NotBlank(message = "Pole 'type' nie może być puste.")
    private String type;

    private String image;


}

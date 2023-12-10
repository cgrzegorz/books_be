package com.books.books.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/books")
    List<BookDTO> getBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        BookDTO createBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);
    }
}

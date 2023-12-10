package com.books.books.book;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(book -> {
            BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
            if (book.getImage() != null) {
                String imageBase64 = Base64.getEncoder().encodeToString(book.getImage());
                bookDTO.setImage(imageBase64);
            }
            return bookDTO;
        }).collect(Collectors.toList());
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        if (bookDTO.getImage() != null && !bookDTO.getImage().isEmpty()) {
            book.setImage(Base64.getDecoder().decode(bookDTO.getImage()));
        }
        Book savedBook = bookRepository.save(book);
        bookDTO = modelMapper.map(savedBook, BookDTO.class);
        if (savedBook.getImage() != null) {
            String imageBase64 = Base64.getEncoder().encodeToString(savedBook.getImage());
            bookDTO.setImage(imageBase64);
        }
        return bookDTO;
    }
}

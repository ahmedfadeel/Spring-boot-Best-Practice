package com.example.swagger.controller;

import com.example.swagger.dto.BookResponseDto;
import com.example.swagger.model.Book;
import com.example.swagger.service.AuthorService;
import com.example.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

   private final BookService bookService;


    public BookController ( BookService bookService ) {
        this.bookService=bookService;
    }

    @PostMapping
    public void addBook(  ) {
        bookService.save ();
    }

    @PutMapping
    public void updateBook(  ) {
        bookService.updateBook ();
    }
    @GetMapping("{bookName}")
    public List <BookResponseDto> getBooks (  ) {
       return bookService.getBooks (  );

    }


}

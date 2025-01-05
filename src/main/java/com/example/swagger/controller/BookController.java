package com.example.swagger.controller;

import com.example.swagger.service.AuthorService;
import com.example.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

   @Autowired
   private BookService bookService;

    @Autowired
    private AuthorService authorService;








}

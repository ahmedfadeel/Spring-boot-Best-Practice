package com.example.swagger.service;

import com.example.swagger.model.Author;
import com.example.swagger.model.Book;
import com.example.swagger.repository.AuthorRepository;
import com.example.swagger.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;



    public void save() {
      Author author = new Author();
      author.setName("John Doe");
      Book book = new Book();
      book.setName("Java");
      book.setAuthor(author);
      bookRepository.save(book);

    }

}

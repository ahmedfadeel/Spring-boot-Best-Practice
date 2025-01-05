package com.example.swagger.service;

import com.example.swagger.dto.StudentDto;
import com.example.swagger.model.Author;
import com.example.swagger.model.Book;
import com.example.swagger.repository.AuthorRepository;
import com.example.swagger.repository.StudentRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public void save() {
    Author author = new Author();
    author.setName("Ahmed");

    Book book1 = new Book();
    book1.setAuthor(author);
    book1.setName("Book1");

    Book book2 = new Book();
    book2.setAuthor(author);
    book2.setName("Book1");

    author.getBooks().add(book1);
    author.getBooks().add(book2);

    authorRepository.save(author);

    }
    public void remove() {

        authorRepository.deleteById(6);
    }

}

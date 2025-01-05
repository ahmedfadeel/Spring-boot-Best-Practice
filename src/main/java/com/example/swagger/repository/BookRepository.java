package com.example.swagger.repository;

import com.example.swagger.model.Author;
import com.example.swagger.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

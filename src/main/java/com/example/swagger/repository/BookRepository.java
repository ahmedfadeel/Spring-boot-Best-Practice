package com.example.swagger.repository;

import com.example.swagger.model.Author;
import com.example.swagger.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional <Book> findByName ( String  name );
    @Query("select  b from Book b  left join fetch  b.author left join fetch b.bookChilds ")
    List <Book> findBooksWithJoins (  );
}

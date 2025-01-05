package com.example.swagger.repository;

import com.example.swagger.model.Author;
import com.example.swagger.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}

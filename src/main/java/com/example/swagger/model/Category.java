package com.example.swagger.model;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private Set <Book> books;

    public Integer getId ( ) {
        return id;
    }

    public Set < Book > getBooks ( ) {
        return books;
    }

    public void setBooks ( Set < Book > books ) {
        this.books = books;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
}

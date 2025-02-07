package com.example.swagger.model;

import jakarta.persistence.*;

@Table(name="book_childs")
@Entity
public class BookChilds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;

    public Book getBook ( ) {
        return book;
    }

    public void setBook ( Book book ) {
        this.book = book;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }
}

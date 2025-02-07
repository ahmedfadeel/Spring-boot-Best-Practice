package com.example.swagger.model;

import graphql.com.google.common.base.Optional;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="book_category",
            joinColumns ={ @JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    @BatchSize(size = 10)
    private Set <Category> categories;

    @OneToMany(mappedBy =  "book", fetch = FetchType.LAZY
            ,   cascade = CascadeType.ALL)
    @BatchSize(size = 10)
    private  Set<BookChilds> bookChilds;


    public Set < Category > getCategories ( ) {
        return categories;
    }

    public void setCategories ( Set < Category > categories ) {
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set < BookChilds > getBookChilds ( ) {
        return bookChilds;
    }

    public void setBookChilds ( Set < BookChilds > bookChilds ) {
        this.bookChilds = bookChilds;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())  return false;
        Book book = (Book) obj;
        return  book.getName().equals(this.name);
    }
    @Override
    public int hashCode() {
        return this.id.hashCode ( );
    }
}

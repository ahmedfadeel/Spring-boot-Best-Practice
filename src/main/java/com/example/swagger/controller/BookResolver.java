package com.example.swagger.controller;

import com.example.swagger.model.Book;
import com.example.swagger.repository.BookRepository;
import com.example.swagger.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {

    private final BookService bookService;

    public BookResolver ( BookService bookService ) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List < Book > allBooks() {
        return bookService.findAll ();
    }
      /*
    * @MutationMapping
   public void createPost(@Argument String name ) {


    Post post = new Post();
    post.setId(UUID.randomUUID().toString());
    post.setTitle(title);
    post.setText(text);
    post.setCategory(category);
    post.setAuthorId(authorId);

    postDao.savePost(post);

    return post;
}
    *
    *
    *
    *
    *
    *
    *
    *
    *
    * */
}

package com.example.swagger.service;

import com.example.swagger.dto.AuthorDetailsDto;
import com.example.swagger.dto.BookChildDetailsDto;
import com.example.swagger.dto.BookResponseDto;
import com.example.swagger.dto.CategoryDetailsDto;
import com.example.swagger.model.Author;
import com.example.swagger.model.Book;
import com.example.swagger.repository.BookRepository;
import com.example.swagger.repository.CourseRepository;
import io.lettuce.core.resource.DefaultClientResources;
import org.springframework.transaction.annotation.Transactional;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final DefaultClientResources defaultClientResources;


    public BookService ( BookRepository bookRepository , CourseRepository courseRepository , ReturnTypeParser returnTypeParser , DefaultClientResources defaultClientResources ) {
        this.bookRepository = bookRepository;
        this.defaultClientResources = defaultClientResources;
    }

    @Transactional
    public void save ( ) {

        Book book3 = new Book ( );
        book3.setName ( "Java" );
        bookRepository.save ( book3 );
        book3.setName ( "Spring MVC" );

    }
    @Transactional
    public void updateBook (  ) {
        Optional < Book > bookOptional = bookRepository.findById ( 1 );
        bookOptional.ifPresentOrElse (
                ( book ) -> {
                    book.setName ( "name updaaatd " );
                    Optional.ofNullable ( book.getAuthor ( ) )
                            .ifPresent ( author -> System.out.println ( author.getName ( ) ) );
                }
                , ( ) -> {
                    throw new NoSuchElementException ( "fgfgh" );
                }
                                     );
    }

    public List <Book> findAll() {
      return   bookRepository.findAll ();
    }

    public List<BookResponseDto> getBooks(  ) {
        List < Book > books = bookRepository.findAll ( );
        return books.stream ( ).map ( book -> new BookResponseDto (
                book.getName ( ) ,
                new AuthorDetailsDto ( Optional.ofNullable ( book.getAuthor ( ) )
                        .map ( Author :: getName ).orElse ( null ) ) ,
                book.getCategories ( )
                        .stream ( )
                        .map ( category -> new CategoryDetailsDto ( category.getName ( ) ) )
                        .collect ( Collectors.toList ( ) ) ,
                book.getBookChilds ( )
                        .stream ( )
                        .map ( child -> new BookChildDetailsDto ( child.getName ( ) ) )
                        .collect ( Collectors.toList ( ) )
        ) ).collect ( Collectors.toList ( ) );
    }

}

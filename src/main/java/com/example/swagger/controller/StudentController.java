package com.example.swagger.controller;

import com.example.swagger.dto.StudentDto;
import com.example.swagger.service.AuthorService;
import com.example.swagger.service.BookService;
import com.example.swagger.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {


    private final  StudentService studentService;
    private final BookService bookService;
    private final AuthorService authorService;

    public StudentController ( StudentService studentService, BookService bookService, AuthorService authorService ) {
        this.studentService=studentService;
        this.bookService=bookService;
        this.authorService=authorService;
    }


    @Value("${topic}")
    private String topic;


    @GetMapping
    @Operation(summary = "Find all Students",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StudentDto.class))),
                    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content, headers = {
                            @Header(name = "Constants.ERROR_CODE_ANNOUNCEMENT_DUPLICATED", description = "ERROR_CODE_ANNOUNCEMENT_DUPLICATED"),
                    })
            }
    )
    public List<StudentDto> findAllStudents(){
        return studentService.getAllStudents();
    }



    @PostMapping
    @Operation(summary = "add Student",
            responses = {
                    @ApiResponse(responseCode = "201",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StudentDto.class))),
            }
    )
    public void  addStudent(@Valid
                                @RequestBody StudentDto studentDto){
        studentService.addManyStudents();
    }

    @GetMapping("prop")
    public String testProperity(){
        return topic;
    }


}

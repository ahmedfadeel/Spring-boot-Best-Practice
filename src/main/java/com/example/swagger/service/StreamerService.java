package com.example.swagger.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class StreamerService implements CommandLineRunner {



    @Override
    public void run ( String... args ) throws Exception {
        /*
        Optional<List<String>> optionalList = Optional.of(List.of("a", "b", "c"));

        optionalList.stream ().flatMap (Collection::stream)
                .forEach ( ele -> System.out.println (ele ) );


        List<Student>  students = List.of (new Student ( "ahmed" , List.of(new Course ("java")) ) ,
                new Student ( "ali" , List.of(new Course ("python")) ) ,
                new Student ( "Hesham" , List.of(new Course ("spring")) ) );

        students.stream ()
                .flatMap ( student -> student.getCourses ().stream () )
                .forEach ( course -> System.out.println (course.name ) );

         */



    }


}





class Student {
 String name ;
 List<Course> courses ;

 public Student(String name, List<Course> courses) {
     this.name = name;
     this.courses=courses;
 }

 public List<Course> getCourses() {
     return courses;
 }
}
class Course {
 String name;
 public Course(String name) {
     this.name = name;
 }
}
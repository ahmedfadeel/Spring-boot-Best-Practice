package com.example.swagger.service;

import com.example.swagger.dto.StudentDto;
import com.example.swagger.mapper.CourseMapper;
import com.example.swagger.model.Course;
import com.example.swagger.model.Student;
import com.example.swagger.repository.StudentRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    CourseMapper courseMapper;

    @Cacheable(value="students"  )
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setName(student.getName());
                    studentDto.setAge(student.getAge());
                    studentDto.setCourses(courseMapper.toDto(student.getCourses()));
                    return studentDto;
                }).collect(Collectors.toList());
    }
    @Transactional
    @CachePut(value = "products")
    public void addStudent(StudentDto studentDto) {
      Student student = new Student();
      student.setName("ali");

      Course course1 = new Course();
      course1.setName("java1");


      Course course2 = new Course();
      course2.setName("python1");

      student.getCourses().add(course1);
      student.getCourses().add(course2);
      studentRepository.save(student);


    }
    public void findStudent(int id) {
       Student student= studentRepository.findById(17).get();
       student.getCourses().forEach(course -> System.out.println(course.getName()));
    }
    public void findStudent2(int id) {
        studentRepository.findById(1);



    }
    public void addManyStudents() {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        executor.execute(new StudentWorker());

        executor.shutdown();

    }
     class StudentWorker implements Runnable {

         @Override
         public void run() {
             for (int i = 2000; i <= 9000; i++) {
                 Student student = new Student();
                 student.setName("ali" + i);

                 Course course1 = new Course();
                 course1.setName("java1" + i);


                 Course course2 = new Course();
                 course2.setName("python1" + i);

                 student.getCourses().add(course1);
                 student.getCourses().add(course2);
                 studentRepository.save(student);

             }
         }
     }
}

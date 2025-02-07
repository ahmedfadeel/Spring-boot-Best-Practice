package com.example.swagger.repository;

import com.example.swagger.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository < Course, Integer> {
}

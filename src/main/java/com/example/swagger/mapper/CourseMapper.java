package com.example.swagger.mapper;

import com.example.swagger.dto.CourseDto;
import com.example.swagger.model.Course;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class CourseMapper {

    public CourseDto toDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        return courseDto;
    }
    public List<CourseDto> toDto(Set<Course> courses) {
        return courses.stream().map(this::toDto)
                .collect(Collectors.toList());
    }


}

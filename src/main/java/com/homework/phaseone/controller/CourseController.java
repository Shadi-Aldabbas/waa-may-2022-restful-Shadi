package com.homework.phaseone.controller;

import com.homework.phaseone.domain.Course;
import com.homework.phaseone.dto.CourseDto;
import com.homework.phaseone.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping
    public CourseDto addCourse(@RequestBody CourseDto course) {
        return courseService.save(course);

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@RequestBody CourseDto course, @PathVariable int id) {
        return courseService.update(course, id);
    }
}

package com.homework.phaseone.controller;

import com.homework.phaseone.domain.Course;
import com.homework.phaseone.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepo.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseRepo.getById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        courseRepo.save(course);
        return course;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseRepo.delete(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable int id) {
        return courseRepo.update(course, id);
    }
}

package com.homework.phaseone.controller;

import com.homework.phaseone.domain.Course;
import com.homework.phaseone.dto.*;
import com.homework.phaseone.repository.StudentRepo;
import com.homework.phaseone.services.CourseService;
import com.homework.phaseone.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class StudentControllerV2 {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/studentsByMajor/{major}")
    public List<StudentDto>  getStudentByMajor(@PathVariable String major) {
        System.out.println("-------------start " + major);
        return studentService.getByMajor(major);
    }

    @GetMapping(path = "/CoursesByStudentId/{id}")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return courseService.getCoursesByStudentId(id);
    }
}

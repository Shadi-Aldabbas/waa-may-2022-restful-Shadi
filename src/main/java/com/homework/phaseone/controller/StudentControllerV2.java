package com.homework.phaseone.controller;

import com.homework.phaseone.domain.Course;
import com.homework.phaseone.domain.Student;
import com.homework.phaseone.repository.StudentRepo;
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
    private StudentRepo studentRepo;

    @GetMapping(path = "/studentsByMajor/{major}")
    public List<Student>  getStudentByMajor(@PathVariable String major) {
        System.out.println("-------------start " + major);
        return studentRepo.getByMajor(major);
    }

    @GetMapping(path = "/CoursesByStudentId/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}

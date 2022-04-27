package com.homework.phaseone.controller;


import com.homework.phaseone.domain.Course;
import com.homework.phaseone.domain.Student;
import com.homework.phaseone.repository.StudentRepo;
import com.homework.phaseone.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentRepo.getById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentRepo.delete(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        return studentRepo.update(student, id);
    }


}

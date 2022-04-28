package com.homework.phaseone.controller;


import com.homework.phaseone.services.StudentService;
import com.homework.phaseone.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto student) {
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto student, @PathVariable int id) {
        return studentService.update(student, id);
    }


}

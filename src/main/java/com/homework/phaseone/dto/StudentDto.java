package com.homework.phaseone.dto;


import com.homework.phaseone.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String major;
    private float gpa;
    private ArrayList<Course> courses;
}

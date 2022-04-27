package com.homework.phaseone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String major;
    private float gpa;
    private ArrayList<Course> courses;

}

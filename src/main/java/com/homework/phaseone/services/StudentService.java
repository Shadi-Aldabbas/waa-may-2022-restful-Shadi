package com.homework.phaseone.services;

import com.homework.phaseone.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto dto);

    void delete(int id);

    List<StudentDto> getAll();

    List<StudentDto> getByMajor(String major);
    StudentDto update(StudentDto Dto, int id);

    StudentDto getById(int id);
}

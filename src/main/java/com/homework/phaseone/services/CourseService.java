package com.homework.phaseone.services;

import com.homework.phaseone.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto save(CourseDto dto);

    void delete(int id);

    List<CourseDto> getAll();

    List<CourseDto> getCoursesByStudentId(int stuId);

    CourseDto update(CourseDto courseDto, int id);

    CourseDto getById(int id);
}

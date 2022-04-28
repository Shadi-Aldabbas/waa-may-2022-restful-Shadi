package com.homework.phaseone.services.impl;

import com.homework.phaseone.services.CourseService;
import com.homework.phaseone.repository.CourseRepo;
import com.homework.phaseone.repository.StudentRepo;
import com.homework.phaseone.dto.CourseDto;
import com.homework.phaseone.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

    @Override
    public CourseDto save(CourseDto dto) {
        Course c = new Course();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setCode(dto.getCode());
        courseRepo.save(c);
        return dto;
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<CourseDto> getAll() {
        var entityList=  courseRepo.getAll();

        var result = new ArrayList<CourseDto>();
        entityList.forEach(l->{
            //convert
            CourseDto dto = new CourseDto();
            dto.setId(l.getId());
            dto.setName(l.getName());
            dto.setCode(l.getCode());
            result.add(dto);
        });
        return result;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int stuId) {
        var stu = studentRepo.getById(stuId);
        var result = new ArrayList<CourseDto>();
       stu.getCourses().forEach(l ->{
        CourseDto dto = new CourseDto();
        dto.setId(l.getId());
        dto.setName(l.getName());
        dto.setCode(l.getCode());
        result.add(dto);
       });
        return result;
    }

    @Override
    public CourseDto update(CourseDto courseDto, int id) {
        Course c = new Course();
        c.setId(courseDto.getId());
        c.setName(courseDto.getName());
        c.setCode(courseDto.getCode());
        courseRepo.update(c,id);
        return courseDto;
    }

    @Override
    public CourseDto getById(int id) {
        Course c =courseRepo.getById(id);
        return new CourseDto(c.getId(),c.getName(),c.getCode());
    }
}

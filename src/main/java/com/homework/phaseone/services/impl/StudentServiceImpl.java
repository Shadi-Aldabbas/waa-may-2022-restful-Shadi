package com.homework.phaseone.services.impl;

import com.homework.phaseone.repository.StudentRepo;
import com.homework.phaseone.domain.Student;
import com.homework.phaseone.dto.StudentDto;
import com.homework.phaseone.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;


    @Override
    public StudentDto save(StudentDto dto) {
        Student stu = new Student(dto.getId(), dto.getFName(), dto.getLName(), dto.getEmail(), dto.getMajor(), dto.getGpa(), dto.getCourses());
        studentRepo.save(stu);
        return dto;
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> entityList=  studentRepo.getAll();
        var result = new ArrayList<StudentDto>();
        entityList.forEach(dto->{
            StudentDto stu = new StudentDto(dto.getId(), dto.getFName(), dto.getLName(), dto.getEmail(), dto.getMajor(), dto.getGpa(), dto.getCourses());
            result.add(stu);
        });
        return result;
    }
    @Override
    public List<StudentDto> getByMajor(String major) {
        return getAll().stream().filter(stu -> stu.getMajor().equals(major)).collect(Collectors.toList());
    }

    @Override
    public StudentDto update(StudentDto dto, int id) {
        Student stu = new Student(dto.getId(), dto.getFName(), dto.getLName(),
                dto.getEmail(), dto.getMajor(), dto.getGpa(), dto.getCourses());
        studentRepo.update(stu,id);
        return dto;
    }

    @Override
    public StudentDto getById(int id) {
        Student stu =studentRepo.getById(id);
        return new StudentDto(stu.getId(),stu.getFName(),stu.getLName(),stu.getEmail(),stu.getMajor(),stu.getGpa(),stu.getCourses());
    }
}

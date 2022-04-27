package com.homework.phaseone.repository;

import com.homework.phaseone.domain.Course;
import com.homework.phaseone.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    private static ArrayList<Student> students = new ArrayList<>();


    public List<Student> getAll() {
        return students;
    }

    public List<Student> getByMajor(String major) {
        return students.stream().filter(stu -> stu.getMajor().equals(major)).collect(Collectors.toList());
    }
   public List<Course> getCoursesByStudentId(int stuId) {
        var stu = students
                .stream()
               .filter(l -> l.getId() == stuId)
               .findFirst()
               .orElse(null);
        return stu.getCourses();
    }

    public void save(Student stu) {
        students.add(stu);
    }

    public void delete(int id) {
        students.stream()
                .filter(l -> l.getId() == id)
                .forEach(l -> students.remove(l));
    }

    public Student getById(int id) {
        return students
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student update(Student student, int id) {
        Student oldStudent = students.stream().filter(c -> c.getId() == id).findFirst().get();
        students.set(students.indexOf(oldStudent), student);
        return student;
    }


}

package com.homework.phaseone.repository;

import com.homework.phaseone.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    private static ArrayList<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public void save(Course course) {
        courses.add(course);
    }
    public void delete(int id) {
        courses.stream()
                .filter(l -> l.getId() == id)
                .forEach(l -> courses.remove(l));
    }

    public Course getById(int id) {
        return courses
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course update(Course course, int id)
    {
        Course oldCourse = courses.stream().filter(c -> c.getId() == id).findFirst().get();
        courses.set(courses.indexOf(oldCourse), course);
        return course;

    }

}

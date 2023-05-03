package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Course;
import com.randradee.spring.tutorial.school.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("test")
                .lastName("test")
                .build();

        System.out.println(teacherRepository.save(teacher));
    }

    @Test
    public void saveTeacherWithCourse(){
        Course course = Course.builder()
                .title("test")
                .credits(5)
                .build();

        List<Course> courses = new ArrayList<>();
        courses.add(course);

        Teacher teacher = Teacher.builder()
                .firstName("testWithCourse")
                .lastName("testWithCourse")
//                .courses(courses)
                .build();

        System.out.println(teacherRepository.save(teacher));
    }
}

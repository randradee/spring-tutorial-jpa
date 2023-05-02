package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Course;
import com.randradee.spring.tutorial.school.entities.CourseMaterial;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseWithCourseMaterial(){
        Course course = Course.builder()
                .title("test course")
                .credits(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.test")
                .course(course)
                .build();

        System.out.println(courseMaterialRepository.save(courseMaterial));
        System.out.println(courseRepository.save(course));
    }

    @Test
    public void getAllCourses(){
        System.out.println(courseRepository.findAll());
    }
}
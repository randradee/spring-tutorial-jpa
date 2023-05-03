package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Course;
import com.randradee.spring.tutorial.school.entities.Teacher;
import net.bytebuddy.TypeCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

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
                .build();

        System.out.println(teacherRepository.save(teacher));
    }

    @Test
    public void getAllTeachersWithPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        System.out.println(teacherRepository.findAll(firstPageWithThreeRecords));
    }
}

package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Course;
import com.randradee.spring.tutorial.school.entities.CourseMaterial;
import com.randradee.spring.tutorial.school.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


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
    public void saveCourseWithTeacherAndCourseMaterial(){
        Teacher teacher = Teacher.builder()
                .firstName("teacherTest")
                .lastName("test test")
                .build();

        Course course = Course.builder()
                .title("test course with teacher")
                .credits(2)
                .teacher(teacher)
                .build();

        System.out.println(courseRepository.save(course));
    }

    @Test
    public void getAllCourses(){
        System.out.println(courseRepository.findAll());
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("t", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

//    @Test
//    public void saveCourseWithStudentAndTeacher() {
//
//        Teacher teacher = Teacher.builder()
//                .firstName("Lizze")
//                .lastName("Morgan")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Abhishek")
//                .lastName("Singh")
//                .emailId("abhishek@gmail.com")
//                .build();
//
//        Course course = Course
//                .builder()
//                .title("AI")
//                .credits(12)
//                .teacher(teacher)
//                .build();
//
//        course.addStudents(student);
//
//        courseRepository.save(course);
//    }
}
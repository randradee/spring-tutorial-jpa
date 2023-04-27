package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .firstName("test")
                .lastName("test")
                .emailId("test@test1")
                .guardianName("test")
                .guardianEmail("test@test")
                .guardianMobile("test")
                .build();
    }

    @Test
    public void saveStudent(){
        Student savedStudent = studentRepository.save(student);

        assertEquals(student.getFirstName(), savedStudent.getFirstName());
    }

    @Test
    public void printAllStudents(){
        System.out.println(studentRepository.findAll());
    }
}
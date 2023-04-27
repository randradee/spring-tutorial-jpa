package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Guardian;
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
    private Student studentWithGuardian;

    private Guardian guardian;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void saveStudentWithGuardian(){
        guardian = Guardian.builder()
                .name("Papi")
                .email("papi@email.com")
                .mobile("999999999")
                .build();

        studentWithGuardian = Student.builder()
                .firstName("Shivam")
                .lastName("Kumar")
                .emailId("shivam@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(studentWithGuardian);
    }

    @Test
    public void saveStudent(){
        student = Student.builder()
                .firstName("test")
                .lastName("test")
                .emailId("test@test1")
//                .guardianName("test")
//                .guardianEmail("test@test")
//                .guardianMobile("test")
                .build();

        Student savedStudent = studentRepository.save(student);

        assertEquals(student.getFirstName(), savedStudent.getFirstName());
    }

    @Test
    public void printAllStudents(){
        System.out.println(studentRepository.findAll());
    }
}
package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

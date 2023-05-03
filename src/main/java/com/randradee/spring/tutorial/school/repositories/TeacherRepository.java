package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

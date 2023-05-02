package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}

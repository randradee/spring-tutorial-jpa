package com.randradee.spring.tutorial.school.services;

import com.randradee.spring.tutorial.school.entities.Teacher;
import com.randradee.spring.tutorial.school.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}


package com.randradee.spring.tutorial.school.services;

import com.randradee.spring.tutorial.school.entities.Teacher;
import com.randradee.spring.tutorial.school.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Teacher> getTeachersWithPagination(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return teacherRepository.findAll(pageable);
    }
}


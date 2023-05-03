package com.randradee.spring.tutorial.school.controllers;

import com.randradee.spring.tutorial.school.entities.Teacher;
import com.randradee.spring.tutorial.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> fetchTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }

}

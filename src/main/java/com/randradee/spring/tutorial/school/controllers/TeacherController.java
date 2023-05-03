package com.randradee.spring.tutorial.school.controllers;

import com.randradee.spring.tutorial.school.entities.Teacher;
import com.randradee.spring.tutorial.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> fetchTeachersWithPagination(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam (value = "size", defaultValue = "10") int size){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachersWithPagination(page, size).getContent());
    }
}

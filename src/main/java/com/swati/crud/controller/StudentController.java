package com.swati.crud.controller;


import com.swati.crud.service.StudentService;
import com.swati.crud.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studservice;

    @GetMapping
    public List<Student> getAllStudents()
    {
        return (List<Student>) studservice.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studservice.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@Validated @RequestBody Student student) {
        return studservice.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        studservice.deleteStudent(id);
       return ResponseEntity.noContent().build();
    }
}


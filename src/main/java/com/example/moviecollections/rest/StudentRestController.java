package com.example.moviecollections.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviecollections.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // sample data at class level
    private final List<Student> theStudents = new ArrayList<>();

    public StudentRestController() {
        theStudents.add(new Student("Ram", "Krishna", "ram1@gmail.com"));
        theStudents.add(new Student("Sam", "Krishna", "samr@gmail.com"));
        theStudents.add(new Student("Jam", "Krishna", "jamk@yahoo.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    
}


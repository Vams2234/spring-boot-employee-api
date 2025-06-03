package com.example.moviecollections.dao;

import com.example.moviecollections.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int studentId);

    void update(Student student);

    void delete(int studentId);

    int deleteAll();

    List<Student> findAll();
}

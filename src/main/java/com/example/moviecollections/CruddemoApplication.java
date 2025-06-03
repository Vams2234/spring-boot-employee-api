package com.example.moviecollections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.moviecollections.dao.StudentDAO;
import com.example.moviecollections.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
            // createStudent(studentDAO);
            
            createMultipleStudents(studentDAO);
            
            // updateStudent(studentDAO);
            
            // deleteStudent(studentDAO);
            
            // deleteAllStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new Student object...");
        Student temp = new Student("John", "Sins", "johnysins@pumbling.com");
        studentDAO.save(temp);
        System.out.println("Saved Student with ID: " + temp.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student objects...");
        Student s1 = new Student("John", "Sins", "johnysins@pumbling.com");
        Student s2 = new Student("Mia", "Khalifa", "mia_k@gmail.com");
        Student s3 = new Student("Karizma", "Suzao", "karizma_s@yahoo.com");

        System.out.println("Saving the Students...");
        studentDAO.save(s1);
        studentDAO.save(s2);
        studentDAO.save(s3);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int id = 1;
        System.out.println("Looking for student with ID " + id);
        Student student = studentDAO.findById(id);
        if (student != null) {
            student.setFirstName("Ram");
            studentDAO.update(student);
            System.out.println("Updated Student: " + student);
        } else {
            System.out.println("Student not found with ID " + id);
        }
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 3;
        System.out.println("Deleting student with ID: " + id);
        studentDAO.delete(id);
        System.out.println("Deleted student: " + id);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int count = studentDAO.deleteAll();
        System.out.println("Number of students deleted: " + count);
    }
}

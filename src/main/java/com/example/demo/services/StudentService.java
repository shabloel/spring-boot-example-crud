package com.example.demo.services;

import com.example.demo.model.Student;

import java.util.List;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/
public interface StudentService {
    List<Student> getStudents();
    void addNewStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, String name, String email);
}

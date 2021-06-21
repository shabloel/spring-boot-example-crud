package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/

@RestController
@RequestMapping("api/test")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("students")
    public List<Student> test(){
        return studentService.getStudents();
    }

    @PostMapping("newstudent")
    public void saveStudent(@RequestBody  Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}

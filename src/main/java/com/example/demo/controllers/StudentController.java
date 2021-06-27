package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/
@Slf4j
@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    @ApiOperation(value="Returns all students",
            notes="Hit the endpoint and a json will be returnes with all students",
            response=List.class)


    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    @ApiOperation(value="Finds a student by id",
            notes="Provide an id to look up specific student",
            response=Student.class)
    public Student getStudentById(@ApiParam(value="ID value for the Student you want to retirece",
                                       required = true)
                                @PathVariable Long id){
        logger.trace("Students are being retrieved");
        return studentService.getStudentById(id);
    }

    @PostMapping("/newstudent")
    public void saveStudent(@RequestBody  Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}

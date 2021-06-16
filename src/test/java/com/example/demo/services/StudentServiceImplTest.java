package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

/**
 * @author : christiaan.griffioen
 * @since :  16-6-2021, wo
 **/

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepo studentRepo; //we already know studentrepo works, therefore iso @Autowired, we can Mock it.

/*    @ExtendWith(MockitoExtension.class) takes care of this
    private AutoCloseable autoCloseable;*/


    private StudentService studentService;

/*    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepo);
    }*/

/*    @MockitoExtension.class takes care of this
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    void getStudents() {
        //when
        studentService.getStudents();
        //then
        //verify that studentRepo was invoked after studentService.getStudents was called.
        //we don't want to actually call the DB, so to make our unit test fast, we mock studentRepo.
        verify(studentRepo).findAll();
    }

    @Test
    void addNewStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}
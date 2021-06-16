package com.example.demo.repositories;

import com.example.demo.model.Gender;
import com.example.demo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/
@DataJpaTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @AfterEach
    void tearDown(){
        studentRepo.deleteAll();
    }

    @Test
    void findStudentByEmail() {
        //given
        Student s = new Student();
        String email = "peppa@gmail.com";
        s.setFirstName("Peppa");
        s.setGender(Gender.FEMALE);
        s.setEmail(email);
        studentRepo.save(s);

        //when
        Student studentFromRepo = studentRepo.findStudentByEmail("peppa@gmail.com").get();

        //then
        assertThat(studentFromRepo).isEqualTo(s);
    }

    @Test
    void notFoundStudentByEmailStudent() {
        //given
        Student s = new Student();
        String email = "peppa@gmail.com";
        s.setFirstName("Peppa");
        s.setGender(Gender.FEMALE);
        s.setEmail(email);
        studentRepo.save(s);

        //when
        Optional<Student> studentOptional = studentRepo.findStudentByEmail("jansen@gmail.com");

        //then
        assertThat(studentOptional).isEmpty();
    }
}
package com.example.demo.bootstrap;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/
@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args -> {
           Student s1 =  new Student();
           Student s2 =  new Student();
           s1.setFirstName("Susy");
           s1.setLastName("Sheep");
           s1.setAge(23);
           s1.setEmail("susy@yahoo.com");
           s2.setFirstName("Peppa");
           s2.setLastName("Pig");
           s2.setAge(12);
           s2.setEmail("peppa@gmail.com");

           repo.saveAll(List.of(s1, s2));
        };
    }
}

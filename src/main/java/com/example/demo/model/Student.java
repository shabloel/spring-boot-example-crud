package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/

@Data
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "student_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Transient
    private String interests;

}

package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/

@Data
@Entity
@Table
@ApiModel(description = "Details about the Student")
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
    private Gender gender;
    private int age;
    @ApiModelProperty(notes="unique email on which you can search")
    private String email;

    @Transient
    private String interests;

}

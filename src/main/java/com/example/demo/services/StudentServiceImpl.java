package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : christiaan.griffioen
 * @since :  15-6-2021, di
 **/

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =  studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        boolean exists = studentRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id " + id + "is not present in DB");
        }
        studentRepo.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + id + "does not exist"
                ));
        if(name != null && name.length() > 0 && !Objects.equals(student.getFirstName(), name)){
            student.setFirstName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepo
                    .findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}

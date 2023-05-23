package com.spring_boot_thymeleaf.service;

import com.spring_boot_thymeleaf.model.Student;
import com.spring_boot_thymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

//    @Override
//    public void saveStudent(Student student) {
//        this.studentRepository.save(student);
//    }
}

package com.spring_boot_thymeleaf.service;

import com.spring_boot_thymeleaf.model.Employee;
import com.spring_boot_thymeleaf.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
//    void saveStudent(Student student);
}

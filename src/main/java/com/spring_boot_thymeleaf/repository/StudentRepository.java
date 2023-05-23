package com.spring_boot_thymeleaf.repository;

import com.spring_boot_thymeleaf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}

package com.spring_boot_thymeleaf.controller;

//import com.spring_boot_thymeleaf.model.Employee;
//import com.spring_boot_thymeleaf.model.Student;
import com.spring_boot_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String viewHomepage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudent());
        return "index";
    }

//    @PostMapping("/saveStudents")
//    public String saveStudent(@ModelAttribute("student")Student student){
//        //save employee to database
//        studentService.saveStudent(student);
//        return "redirect:/";
//    }
}

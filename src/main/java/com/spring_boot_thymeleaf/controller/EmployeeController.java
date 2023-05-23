package com.spring_boot_thymeleaf.controller;


import com.spring_boot_thymeleaf.model.Employee;
import com.spring_boot_thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public String viewHomepage(Model model){
//        model.addAttribute("listEmployees",employeeService.getAllEmployees());
//        return "index";
        return findPaginated(1,"firstName","asc",model);

    }

    @GetMapping("/ShowNewEmployeeForm")
    public String ShowNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";

    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/ShowFormForUpdate/{id}")
    public String ShowFormForUpdate(@PathVariable (value = "id") long id, Model model){
        //get employee from the service
        Employee employee=employeeService.getEmployeeById(id);
        //get employee as a model attribute to pre-populated the form
        model.addAttribute("employee",employee);
        return "update_employee";

    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public  String findPaginated(@PathVariable (value = "pageNo")int pageNo,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDir") String sortDir, Model model){
        int pageSize=5;
        Page<Employee> page=employeeService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Employee> listEmployee=page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
//        model.addAttribute("listEmployee",listEmployee);
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

}

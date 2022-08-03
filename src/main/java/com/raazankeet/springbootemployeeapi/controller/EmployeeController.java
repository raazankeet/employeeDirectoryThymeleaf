package com.raazankeet.springbootemployeeapi.controller;

import com.raazankeet.springbootemployeeapi.entity.Employee;
import com.raazankeet.springbootemployeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees_new")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees_new/{eid}")
    public Optional<Employee> getAllEmployee(@PathVariable String eid) {
        System.out.println("Id is:"+eid);
        return employeeRepository.findById(Integer.valueOf(eid));
    }


}

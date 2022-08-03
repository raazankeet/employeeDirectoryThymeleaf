package com.raazankeet.springbootemployeeapi.controller;

import com.raazankeet.springbootemployeeapi.entity.Employee;
import com.raazankeet.springbootemployeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UIController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/time")
    public String sayHello(Model model) {
        model.addAttribute("serverTime", new java.util.Date());
        return "time";

    }

    @GetMapping("/list-employees")
    public String listEmployees(Model model) {

//        List<Employee> allEmployees= employeeRepository.findAll();
        List<Employee> allEmployees = employeeRepository.findAllByOrderByLastNameAsc();

        model.addAttribute("employees", allEmployees);
        return "list-employees";

    }

    @GetMapping("/list-employees/{eid}")
    public String getAllEmployee(@PathVariable String eid, Model model) {

        Employee employee = employeeRepository.findById(Integer.valueOf(eid)).orElse(new Employee());
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model theModel) {
        Employee employee = new Employee();
        theModel.addAttribute(employee);
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        if (!((theEmployee.getEmail() == "") &&
                (theEmployee.getFirstName() == "") &&
                (theEmployee.getLastName() == ""))) {
            employeeRepository.save(theEmployee);
        }

        return "redirect:/list-employees";
    }

    @GetMapping("/deleteEmployee/{eid}")
    public String deleteEmployee(@PathVariable String eid) {
        Employee employee = employeeRepository.findById(Integer.valueOf(eid)).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
        return "redirect:/list-employees";
    }
}

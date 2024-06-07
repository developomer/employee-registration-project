package org.cydeo.controller;

import org.cydeo.bootstrap.DataGenerator;
import org.cydeo.model.EmployeeModel;
import org.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model) {

        model.addAttribute("employee", new EmployeeModel());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") @Valid EmployeeModel employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
        model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeService.readAllEmployees());
        return "employee/employees";
    }



}

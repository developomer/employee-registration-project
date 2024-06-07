package org.cydeo.service;

import org.cydeo.model.EmployeeModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {


    public static List<EmployeeModel> employeeList = new ArrayList<>();


    public void saveEmployee(EmployeeModel employee) {
        employeeList.add(employee);
    }

    public List<EmployeeModel> readAllEmployees() {
        return employeeList;
    }

}

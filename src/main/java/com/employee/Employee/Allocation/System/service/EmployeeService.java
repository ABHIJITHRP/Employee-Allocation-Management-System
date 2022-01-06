package com.employee.Employee.Allocation.System.service;

import java.util.List;

import com.employee.Employee.Allocation.System.entity.Employee;
import com.employee.Employee.Allocation.System.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // adding employees
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //view all employees
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

}

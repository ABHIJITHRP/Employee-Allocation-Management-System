package com.employee.Employee.Allocation.System.controller;

import java.util.List;

import com.employee.Employee.Allocation.System.entity.Allocation;
import com.employee.Employee.Allocation.System.entity.Employee;
import com.employee.Employee.Allocation.System.service.AllocationService;
import com.employee.Employee.Allocation.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EmployeeController
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AllocationService allocationService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "employees";
    }

    @GetMapping("/employee/new")
    public String createEmployeeForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/save/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/allocation/new")
    public String createAllocationForm(Model model) {

        Allocation allocation = new Allocation();
        List<Employee> listOfEmployees = employeeService.findAllEmployees();
        model.addAttribute("allocation", allocation);
        model.addAttribute("listOfEmployees", listOfEmployees);
        return "create_allocation";
    }

    @PostMapping("/save/allocation")
    public String saveAllocation(@ModelAttribute("allocation") Allocation allocation) {
        allocationService.saveAllocation(allocation);
        return "redirect:/employees";
    }

    // @GetMapping("/allocation/search")
    // public String allocationSearchForm(Model model) {
    // Allocation allocation = new Allocation();
    // model.addAttribute("allocation", allocation);
    // return "allocation_search";
    // }

    @GetMapping("/view/Allocation")
    public String showStudentBySurname(@RequestParam(value = "search", required = false) Long employeeId, Model model) {
        model.addAttribute("search", allocationService.findAllocation(employeeId));
        return "allocation_view";
    }
}
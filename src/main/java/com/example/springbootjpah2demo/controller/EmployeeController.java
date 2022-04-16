package com.example.springbootjpah2demo.controller;

import com.example.springbootjpah2demo.entity.Employee;
import com.example.springbootjpah2demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/v1/employee/")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/api/v1/employees/")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.createEmployees(employees);
    }

    @GetMapping("/api/v1/employee/")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/api/v1/employees/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

    @PutMapping("/api/v1/employee/")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

    @DeleteMapping("/api/v1/employee/")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}

}

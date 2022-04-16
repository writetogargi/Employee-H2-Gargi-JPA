package com.example.springbootjpah2demo.service;

import com.example.springbootjpah2demo.dao.EmployeeRepository;
import com.example.springbootjpah2demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> createEmployees(List <Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    ///update
    public Employee updateEmployee(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            Employee _employee = optionalEmployee.get();
            _employee.setFirstName(employee.getFirstName());
            _employee.setLastName(employee.getLastName());
            _employee.setEmail(employee.getEmail());
            employeeRepository.save(_employee);

            return _employee;
        }
        else{
            return new Employee();
        }
    }

    public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "User got deleted";
	}

}

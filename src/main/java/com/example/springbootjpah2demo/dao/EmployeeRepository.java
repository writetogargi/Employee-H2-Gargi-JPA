package com.example.springbootjpah2demo.dao;

import com.example.springbootjpah2demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

package com.example.demo2.services;

import com.example.demo2.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee newEmployee);

    public void deleteById(int theId);
}

package com.example.demo2.services;

import com.example.demo2.dao.EmployeeDAO;
import com.example.demo2.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO theEmployeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return theEmployeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee newEmployee) {
        theEmployeeDAO.save(newEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        theEmployeeDAO.deleteById(theId);
    }
}

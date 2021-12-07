package com.example.demo2.services;


import com.example.demo2.dao.EmployeeRepository;
import com.example.demo2.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository theEmployeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.theEmployeeRepository = theEmployeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
//        findall and sort by ascending order
        return theEmployeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional
    public Optional<Employee> findById(int theId) {
        return theEmployeeRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee newEmployee) {
        theEmployeeRepository.save(newEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        theEmployeeRepository.deleteById(theId);
    }


}

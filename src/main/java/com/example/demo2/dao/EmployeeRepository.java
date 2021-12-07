package com.example.demo2.dao;

import com.example.demo2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    adds method to sort by last Name ascending spring behind the scenes work
    public List<Employee> findAllByOrderByLastNameAsc();
}

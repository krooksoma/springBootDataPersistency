package com.example.demo2.dao;

import com.example.demo2.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPATempl implements EmployeeDAO{
//defines a field for Entity Manager
    private EntityManager theEntityManager;

//    Constructor DI

    public EmployeeDAOJPATempl(EntityManager theEntityManager) {
        this.theEntityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
//       create a query
        Query query = theEntityManager.createQuery("FROM Employee");
//        execute query and get the result list
        List<Employee> employees = query.getResultList();

//        return results
//      shorty >> return query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
//     get employee
        Employee theEmployee=
                theEntityManager.find(Employee.class, theId);
//     return employee
//      shorty >> return theEntityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
//        save or update the employee
        Employee dbEmployee = theEntityManager.merge(theEmployee);

//        update with id from db ... so we can get id for save/insert later
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
//        delete object with primary key
        Query query = theEntityManager.createQuery(
                "DELETE from Employee WHERE id=:employeeId");

        query.setParameter("employeeId", theId);

        query.executeUpdate();
    }
}

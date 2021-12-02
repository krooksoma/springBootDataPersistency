package com.example.demo2.restControllers;

import com.example.demo2.entity.Employee;
import com.example.demo2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService theEmployeeService;
//    quick and dirty solution: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
    this.theEmployeeService = theEmployeeService;
}

//    expose"/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return theEmployeeService.findAll();
    }

//   get employee by Id
    @RequestMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = theEmployeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee not found");
        }
        return theEmployee;
    }

//    create a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

//        also jst in case they pass and id in JSON.... set id to 0
//        this is also to force a save of new item---- instead of update
        theEmployee.setId(0);

        theEmployeeService.save(theEmployee);

        return theEmployee;

    }

//    update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        theEmployeeService.save(theEmployee);
        return theEmployee;
    }

//    add mapping for delete
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = theEmployeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee not in this DB");
        }
        theEmployeeService.deleteById(employeeId);

        return "Deleted employee with id - " + employeeId;
    }


}

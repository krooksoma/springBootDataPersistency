package com.example.demo2.controllers;

import com.example.demo2.entity.Employee;
import com.example.demo2.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

// Constructor DI
    public EmployeeController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

//    add mapping to get the employees list
    @GetMapping("/list")
    public String listEmployees(Model themodel){
        List<Employee> employeeList = employeeService.findAll();
//        add data to spring MVC model
        themodel.addAttribute("employees", employeeList);

        return "employeeList";
    }

//    creates mapping to allow data binding
    @GetMapping("/showaddemployeeform")
    public String showAddEmployeeForm(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "newEmployeeForm";
    }
//  updates employee information
    @GetMapping("/showformforupdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
// Get the employee info from the database
        Optional<Employee> theEmployee = employeeService.findById(theId);

//   set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

    return"updateEmployeeForm";
    }
//   saves new employee data to database
    @PostMapping("/save")
    public String addNewEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);

        return"redirect:/employees/list";
    }

    @DeleteMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);

        return"redirect:/employees/list";
    }


}

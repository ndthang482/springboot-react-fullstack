package com.springbootbackend.controller;

import com.springbootbackend.entity.Employee;
import com.springbootbackend.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }
    @GetMapping("/employee")
    public List<Employee> findById(){
        return employeeService.findAll();
    }
    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.create(employee);
    }
    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        employeeService.update(id, employee);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }
}

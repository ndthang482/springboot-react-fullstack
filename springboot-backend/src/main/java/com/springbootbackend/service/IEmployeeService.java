package com.springbootbackend.service;

import com.springbootbackend.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee findById(Long id);
    List<Employee> findAll();
    void create(Employee employee);
    void update(Long id, Employee employee);
    void deleteById(Long id);
}

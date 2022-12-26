package com.springbootbackend.service;

import com.springbootbackend.entity.Employee;
import com.springbootbackend.exception.ResourceNotFoundException;
import com.springbootbackend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found employee with id"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmailId(employee.getEmailId());
        employeeRepository.save(employee);
    }

    @Override
    public void update(Long id, Employee employee) {
        employee.setId(id);
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmailId(employee.getEmailId());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}

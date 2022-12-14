package com.spring.mastery.service;

import com.spring.mastery.dto.Employee;
import com.spring.mastery.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mastery.dao.EmployeeDao;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        return employeeDao.getAllEmployees();
    }

    public Employee getById(long employee_id) throws ResourceNotFoundException {
        if (employeeDao.getEmployeeById(employee_id) == null) {
            throw new ResourceNotFoundException("There is no employee with id " + employee_id);
        }
        return employeeDao.getEmployeeById(employee_id);
    }

    public void add(Employee newEmployee) throws ResourceNotFoundException {
        if (newEmployee == null) {
            throw new IllegalArgumentException();
        }
        employeeDao.addEmployee(newEmployee);
    }

    public void delete(Long employeeToDeleteId) throws ResourceNotFoundException {
        if (employeeDao.getEmployeeById(employeeToDeleteId) == null) {
            throw new ResourceNotFoundException("There is no employee with id " + employeeToDeleteId);
        }
        employeeDao.deleteEmployee(employeeToDeleteId);
    }

    public void update(Employee newEmployee, long id) throws ResourceNotFoundException {
        if (employeeDao.getEmployeeById(id) == null) {
            throw new ResourceNotFoundException("There is no employee with id " + newEmployee);
        } else
            employeeDao.updateEmployee(newEmployee, id);
    }
}


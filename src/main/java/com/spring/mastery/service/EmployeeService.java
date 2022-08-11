package com.spring.mastery.service;

import com.spring.mastery.dto.Employee;
import com.spring.mastery.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mastery.dao.EmployeeDao;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(){}
    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /*@Autowired
    public EmployeeService(EmployeeService employeeService) {
    }*/

    public List<Employee> getAll() {
        return employeeDao.getAllEmployees();
    }

    public Employee getById(long employee_id) throws ResourceNotFoundException {
        if(employeeDao.getEmployeeById(employee_id) == null){
            throw new ResourceNotFoundException("There is no employee with id " + employee_id);
        }
        return employeeDao.getEmployeeById(employee_id);
    }

    /*public List<Employee> getByLastname(String lastname) throws ResourceNotFoundException {
        if(employeeRepository.findByLastName(lastname).isEmpty()){
            throw new ResourceNotFoundException("There is no employee with lastname " + lastname);
        }
        return employeeRepository.findByLastName(lastname).stream().toList();
    }
    public List<Employee> getByLastnameContaining(String lastname) throws ResourceNotFoundException {
        if(employeeRepository.findByLastNameContainingIgnoreCase(lastname).isEmpty()){
            throw new ResourceNotFoundException("There is no employee with lastname like " + lastname);
        }
        return employeeRepository.findByLastNameContainingIgnoreCase(lastname).stream().toList();
    }*/

    public void add(Employee newEmployee) throws ResourceNotFoundException {
        if (newEmployee == null){
            throw new IllegalArgumentException();
        }
        employeeDao.addEmployee(newEmployee);
    }


    public void delete(Long employeeToDeleteId) throws ResourceNotFoundException {
        if(employeeDao.getEmployeeById(employeeToDeleteId) == null){
            throw new ResourceNotFoundException("There is no employee with id " + employeeToDeleteId);
        }
        employeeDao.deleteEmployee(employeeToDeleteId);
    }

    public void update(Employee newEmployee, long id) throws ResourceNotFoundException {

        Optional<Employee> checkIfInDB = Optional.ofNullable(employeeDao.getEmployeeById(newEmployee.getEmployeeID()));
        if (checkIfInDB.isPresent()) {
            employeeDao.updateEmployee(newEmployee, id);
          /*  Employee oldEmployee = checkIfInDB.get();
            if(!newEmployee.getFirstName().isEmpty()) {
                oldEmployee.setFirstName(newEmployee.getFirstName());
            }
            if(!newEmployee.getLastName().isEmpty()) {
                oldEmployee.setLastName(newEmployee.getLastName());
            }
            if(newEmployee.getDateOfBirth() != null) {
                oldEmployee.setDateOfBirth(newEmployee.getDateOfBirth());
            }
            if(!newEmployee.getJobTitle().isEmpty()) {
                oldEmployee.setJobTitle(newEmployee.getJobTitle());
            }
            if(newEmployee.getGender() != null) {
                oldEmployee.setGender(newEmployee.getGender());
            }
            if(newEmployee.getDepartmentID() != 0) {
                oldEmployee.setDepartmentID(newEmployee.getDepartmentID());
            }
            employeeDao.addEmployee(oldEmployee);*/
        } else throw new ResourceNotFoundException("There is no employee with id " + newEmployee);
    }
}


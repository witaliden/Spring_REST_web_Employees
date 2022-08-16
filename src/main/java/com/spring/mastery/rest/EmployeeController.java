package com.spring.mastery.rest;
import com.spring.mastery.dto.Employee;
import com.spring.mastery.exceptions.ResourceNotFoundException;
import com.spring.mastery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("v1/employees")
public class EmployeeController {
    public EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    List<Employee> getAll(){
        return employeeService.getAll();
    }
    /*ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);    }*/

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getById(@PathVariable(value = "id") long employee_id) {
        return new ResponseEntity<>(employeeService.getById(employee_id), HttpStatus.OK);
    }

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> addEmployee(@RequestBody Employee newEmployee){
        employeeService.add(newEmployee);
        return new ResponseEntity<>("User was successfully created", HttpStatus.OK);
    }

    @PutMapping("/{id}/edit/")
    @ResponseBody
    public ResponseEntity<String> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee updatedEmployee){
        employeeService.update(updatedEmployee, employeeId);
        return new ResponseEntity<>("Employee was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete/")
    @ResponseBody
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long employeeToDeleteId) {
        try {
            employeeService.delete(employeeToDeleteId);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("There is no employee with id " + employeeToDeleteId);
        }
        return new ResponseEntity<>("Employee was successfully deleted", HttpStatus.OK);
    }
}

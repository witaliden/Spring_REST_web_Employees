package com.spring.mastery.rest;
import com.spring.mastery.dto.Employee;
import com.spring.mastery.exceptions.ResourceNotFoundException;
import com.spring.mastery.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable(value = "id") long employee_id) {
        return new ResponseEntity<>(employeeService.getById(employee_id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        employeeService.add(employee);
        return new ResponseEntity<>("User was successfully created", HttpStatus.OK);
    }

    @PutMapping("/{employeeId}/edit")
    public ResponseEntity<String> updateEmployee(@PathVariable(value = "employeeId") Long employeeId, @RequestBody Employee employee){
        employeeService.update(employee, employeeId);
        return new ResponseEntity<>("Employee was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "employeeId") Long employeeId) {
        try {
            employeeService.delete(employeeId);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("There is no employee with id " + employeeId);
        }
        return new ResponseEntity<>("Employee was successfully deleted", HttpStatus.OK);
    }
}

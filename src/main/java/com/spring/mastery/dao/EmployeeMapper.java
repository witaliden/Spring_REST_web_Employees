package com.spring.mastery.dao;

import com.spring.mastery.dto.Employee;
import org.springframework.jdbc.core.RowMapper;
import com.spring.mastery.dto.Gender;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeID(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDateOfBirth(resultSet.getDate("date_of_birth"));
        employee.setGender(Gender.values()[resultSet.getInt("gender")]);
        employee.setDepartmentID(resultSet.getInt("department_id"));
        employee.setJobTitle(resultSet.getString("job_title"));
        return employee;
    }
}

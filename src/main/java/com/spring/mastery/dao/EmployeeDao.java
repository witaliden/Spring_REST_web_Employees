package com.spring.mastery.dao;

import com.spring.mastery.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

//@Repository
@Component
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employees";
        return jdbcTemplate.query(query, new EmployeeMapper());
    }
    public Employee getEmployeeById(long employeeId) {
        String query = "SELECT * FROM employees WHERE 'employee_id' = ?";
        return jdbcTemplate.queryForObject(query, new Object[] {employeeId}, new EmployeeMapper());
    }

    public void addEmployee(Employee e){
        jdbcTemplate.update("INSERT INTO employees(first_name, last_name, department_id, job_title,  gender)" +
                " VALUES(?, ?, ?, ?, ?)", e.getFirstName(), e.getLastName(), e.getDepartmentID(), e.getJobTitle(), e.getGender());
    }
    public int updateEmployee(Employee e, long id){
        String query = "update employees set first_name = ?, last_name = ?, job_title = ?, gender = ? WHERE employee_id = ?";
        return jdbcTemplate.update(query, e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getGender(), id);
    }
    public int deleteEmployee(long employee_id){
        String query = "DELETE FROM employees WHERE employee_id = ?";
        return jdbcTemplate.update(query, employee_id);
    }

}

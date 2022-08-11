package com.spring.mastery.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
//@Builder
@Getter
@Setter
@Data
@Entity(name = "Employees")
public class Employee implements Comparable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "department_id")
    private int departmentID;
    @Column(name = "job_title")
    private String jobTitle;

    //----- constructors
    public Employee() {
    }
    public Employee(String firstName, String lastName, int departmentID, String jobTitle, Gender gender, Date dateOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    public Employee(Long employeeID, String firstName, String lastName, int departmentID, String jobTitle, Gender gender, Date dateOfBirth)
    {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /*
    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }*/

    //----- override methods of Object class
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee employee))
            return false;
        return Objects.equals(this.employeeID, employee.employeeID) && Objects.equals(this.firstName, employee.firstName)
                && Objects.equals(this.lastName, employee.lastName) && Objects.equals(this.gender, employee.gender);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.employeeID, this.firstName, this.lastName, this.gender);
    }
    @Override
    public String toString() {
        return "Employee { " + "id = " + this.employeeID + ", name = '" + this.firstName + ", lastName = '" + this.lastName + '\'' + ", gender = '" + this.gender + '\'' + " }";
    }

    @Override
    public int compareTo(Object o) {
        if (this.employeeID < ((Employee)o).employeeID)
            return -1;
        else if (this.employeeID > ((Employee)o).employeeID)
            return 1;
        return 0;
    }
}

package com.spring.mastery.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
@Getter
@Setter
/*@Entity(name = "employees")*/
public class Employee {
    private Long employeeID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;

    private int departmentID;

    private String jobTitle;

    //----- constructors
    public Employee() {
    }

    public Employee(String firstName, String lastName, int departmentID, String jobTitle, Gender gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(Long employeeID, String firstName, String lastName, int departmentID, String jobTitle, Gender gender, Date dateOfBirth) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }


    //----- override methods of Object class
    @Override
    public boolean equals(Object o) {
        if ((this == o) || (!(o instanceof Employee)))
            return true;
        Employee t = (Employee) o;
        return (this.employeeID.equals(t.employeeID) &&
                this.firstName.equals(t.firstName) &&
                this.lastName.equals(t.lastName) &&
                this.dateOfBirth.equals(t.dateOfBirth) &&
                this.gender.equals(t.gender) &&
                this.jobTitle.equals(t.jobTitle) &&
                this.departmentID == t.departmentID);
    }

    @Override
    public int hashCode() {
        int prime = 27;
        return prime + ((employeeID == 0 ? 0 : employeeID.hashCode())
                + (firstName == null ? 0 : firstName.hashCode())
                + (lastName == null ? 0 : lastName.hashCode())
                + (dateOfBirth == null ? 0 : dateOfBirth.hashCode())
                + (gender == null ? 0 : gender.hashCode())
                + (jobTitle == null ? 0 : jobTitle.hashCode())
                + (departmentID == 0 ? 0 : ((Integer) departmentID).hashCode()));
    }

    @Override
    public String toString() {
        return "Employee { " + "id = " + this.employeeID + ", name = '" + this.firstName + ", lastName = '" + this.lastName + '\'' + ", gender = '" + this.gender + '\'' + " }";
    }

}
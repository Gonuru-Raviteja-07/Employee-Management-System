package com.project.EMS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeEmail;
    private String employeeDepartment;
    private String employeeLocation;

    // constructor(with feilds)
    employee(String employeeName, String employeeEmail, String employeeDepartment,String employeeLocation) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeDepartment = employeeDepartment;
        this.employeeLocation=employeeLocation;
    }

    // constructor(without feilds)
    employee() {

    }

    // getters
    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public String getEmployeeLocation(){
        return employeeLocation;
    }

    // setters
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public void setEmployeeLocation(String employeeLocation){
        this.employeeLocation=employeeLocation;
    }

}

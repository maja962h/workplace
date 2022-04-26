package com.example.demo.models;

import java.util.Date;

public class Employee {

    private int employeeID;
    private String employeeName;
    private String job;
    private int manager;
    private java.sql.Date hireDate;
    private int salary;
    private int commission;
    private int departmentNumber;

    public Employee(int employeeID, String employeeName, String job, int manager, java.sql.Date hireDate, int salary, int commission, int departmentNumber) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public java.sql.Date getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommission() {
        return commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }
}

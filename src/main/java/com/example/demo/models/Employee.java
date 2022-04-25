package com.example.demo.models;

public class Employee {

    private int employeeID;
    private String employeeName;
    private String job;
    private String manager;
    private String hireDate;
    private String salary;
    private String commission;
    private String departmentNumber;

    public Employee(int employeeID, String employeeName, String job, String manager, String hireDate, String salary, String commission, String departmentNumber) {
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

    public String getManager() {
        return manager;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getSalary() {
        return salary;
    }

    public String getCommission() {
        return commission;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }
}

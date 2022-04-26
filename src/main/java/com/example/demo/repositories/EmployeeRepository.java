package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository <Employee> {

    Connection conn;

    public EmployeeRepository(){
        conn = DatabaseConnectionManager.getConnection();
    }


    @Override
    public List<Employee> getAllEntities() {
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee empToView = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(empToView);
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Employee empToView = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE id = " + id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                empToView = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }

        return empToView;
    }

    @Override
    public void create(Employee entity) {

        try{

            PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO `workplace`.`employees` (`employee_name`, `job`, `manager`, `hiredate`, salary, commission, `department_number`) " +
                    "VALUES (?,?,?,?,?,?,?)");

                pstmt.setString(1, entity.getEmployeeName());
                pstmt.setString(2, entity.getJob());
                pstmt.setInt(3, entity.getManager());
                pstmt.setDate(4, entity.getHireDate());
                pstmt.setInt(5, entity.getSalary());
                pstmt.setInt(6, entity.getCommission());
                pstmt.setInt(7, entity.getDepartmentNumber());

            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("Something's wrong.");
            e.printStackTrace();
        }

    }

    public boolean commissionLimit(Employee employee){
        boolean isValid;

        if (employee.getCommission() > employee.getSalary()){
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

}

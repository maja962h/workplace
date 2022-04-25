package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository <Employee> {

    Connection conn;
    Statement stmt;
    String sqlString;

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
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
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
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
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
        String name = entity.getEmployeeName();
        String job = entity.getJob();
        String manager = entity.getManager();
        String dateOfHire = entity.getHireDate();
        String salary = entity.getSalary();
        String commission = entity.getCommission();
        String deptNum = entity.getDepartmentNumber();

        try{

            stmt = conn.createStatement();
            sqlString = "INSERT INTO `workplace`.`employees` (`employee_name`, `job`, manager, hiredate, salary, commission, department_number) " +
                    "VALUES ('" + name + "', '" + job + "', " + manager + ", " + dateOfHire + ", "  + salary + ", " + commission + ", " + deptNum + ") ";

            stmt.executeUpdate(sqlString);


        } catch (SQLException e){
            System.out.println("Something's wrong.");
            e.printStackTrace();
        }

    }
}

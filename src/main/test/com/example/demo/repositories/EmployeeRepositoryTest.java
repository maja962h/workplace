package com.example.demo.repositories;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    void commissionLimit() {
        //Arrange
       EmployeeRepository emR = new EmployeeRepository();
       java.sql.Date date = new java.sql.Date(2020,1,1);
       Employee empTest = new Employee(34, "JOHNJOHN", "HR", 46, date, 1200000, 300000, 10);
       Employee empTest1 = new Employee(34, "BOB", "LOL", 46, date, 18000, 30000, 10);
       boolean expectedResult = true;

        //Act
       boolean resultOfTest = emR.commissionLimit(empTest);

        //Assert
       assertEquals(expectedResult, resultOfTest);

    }
}
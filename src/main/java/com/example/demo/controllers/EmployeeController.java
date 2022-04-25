package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;


@Controller
public class EmployeeController {
    private final IRepository <Employee> employeeRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public String employees(Model model){
        model.addAttribute("employees", employeeRepository.getAllEntities());
        return "employees";
    }

    @GetMapping("/single_employee")
    public String oneEmployees(Model model, @RequestParam int id){
        //int employeeID = Integer.parseInt(id.getParameter("id"));
        model.addAttribute("employees", employeeRepository.getSingleById(id));
        return "employees";
    }

    @GetMapping("/create_employee")
    public String create(){
        return "/createemployee";
    }

    @PostMapping("/new_employee")
    public String createNewEmployee(WebRequest formDate){
        EmployeeRepository er = new EmployeeRepository();

        String name = formDate.getParameter("name");
        String job = formDate.getParameter("job");
        String manager = formDate.getParameter("manager");
        String hireDate = formDate.getParameter("hireDate");
        String salary = formDate.getParameter("salary");
        String commission = formDate.getParameter("commission");
        String deptNum = formDate.getParameter("deptNum");

        Employee employeeToAdd = new Employee(-1, name, job, manager, hireDate, salary, commission, deptNum);
        er.create(employeeToAdd);


        return "redirect:/employees";
    }


}

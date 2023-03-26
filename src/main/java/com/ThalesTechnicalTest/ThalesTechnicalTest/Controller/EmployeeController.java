package com.ThalesTechnicalTest.ThalesTechnicalTest.Controller;

import com.ThalesTechnicalTest.ThalesTechnicalTest.Data.Employee;
import com.ThalesTechnicalTest.ThalesTechnicalTest.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = employeeRepository.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable String id, Model model) {
        try {
            int employeeId = Integer.parseInt(id);
            Employee employee = employeeRepository.getEmployeeById(employeeId);
            model.addAttribute("employee", employee);
            return "employee";
        } catch (NumberFormatException e) {
            List<Employee> employees = employeeRepository.getAllEmployees();
            model.addAttribute("employees", employees);
            return "index";
        }
    }
}

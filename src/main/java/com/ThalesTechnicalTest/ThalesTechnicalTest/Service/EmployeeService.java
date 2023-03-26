package com.ThalesTechnicalTest.ThalesTechnicalTest.Service;

import com.ThalesTechnicalTest.ThalesTechnicalTest.DAO.EmployeeDAO;
import com.ThalesTechnicalTest.ThalesTechnicalTest.Data.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        employees.forEach(this::calculateAnnualSalary);
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        calculateAnnualSalary(employee);
        return employee;
    }

    private void calculateAnnualSalary(Employee employee) {
        employee.setEmployeeSalary((int) (employee.getEmployeeSalary() * 12));
    }
}

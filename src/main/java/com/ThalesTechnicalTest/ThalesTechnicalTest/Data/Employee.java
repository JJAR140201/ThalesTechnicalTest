package com.ThalesTechnicalTest.ThalesTechnicalTest.Data;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String employeeName;
    private Integer employeeSalary;
    private Integer employeeAge;
    private String profileImage;

    public Double getEmployeeSalaryAnnual() {
        return employeeSalary * 12.0;
    }
}


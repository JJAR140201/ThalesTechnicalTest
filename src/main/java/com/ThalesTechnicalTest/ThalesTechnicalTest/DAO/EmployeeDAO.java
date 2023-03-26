package com.ThalesTechnicalTest.ThalesTechnicalTest.DAO;

import com.ThalesTechnicalTest.ThalesTechnicalTest.Data.Employee;
import com.ThalesTechnicalTest.ThalesTechnicalTest.Data.EmployeeListResponse;
import com.ThalesTechnicalTest.ThalesTechnicalTest.Data.EmployeeResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeDAO {

    private static final String EMPLOYEES_ENDPOINT = "http://dummy.restapiexample.com/api/v1/employees";
    private static final String EMPLOYEE_ENDPOINT = "http://dummy.restapiexample.com/api/v1/employee/{id}";

    private final RestTemplate restTemplate;

    public EmployeeDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        ResponseEntity<EmployeeListResponse> response = restTemplate.exchange(
                EMPLOYEES_ENDPOINT,
                HttpMethod.GET,
                null,
                EmployeeListResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getData();
        } else {
            throw new RuntimeException("Error al obtener la lista de empleados");
        }
    }

    public Employee getEmployeeById(int id) {
        ResponseEntity<EmployeeResponse> response = restTemplate.exchange(
                EMPLOYEE_ENDPOINT,
                HttpMethod.GET,
                null,
                EmployeeResponse.class,
                id);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getData();
        } else {
            throw new RuntimeException("Error al obtener el empleado con ID: " + id);
        }
    }
}


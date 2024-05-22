package pro.sky.employeeBookMap.service;

import pro.sky.employeeBookMap.Employee;

import java.util.HashMap;
import java.util.Map;

public interface EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of());
    int MAX_OF_EMPLOYEES = 10;

    Map<String, Employee> printEmployees();

    public Employee addEmployee(String firstName, String lastName);

    public Employee removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);
}

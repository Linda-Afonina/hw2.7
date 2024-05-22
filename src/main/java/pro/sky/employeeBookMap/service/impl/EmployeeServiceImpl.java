package pro.sky.employeeBookMap.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeBookMap.Employee;
import pro.sky.employeeBookMap.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeBookMap.exceptions.EmployeeNotFoundException;
import pro.sky.employeeBookMap.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeeBookMap.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Новикова Елена Геннадьевна",
            new Employee("Новикова", "Елена Геннадьевна"),
            "Голиков Сергей Иванович",
            new Employee("Голиков", "Сергей Иванович"),
            "Кондратьев Олег Петрович",
            new Employee("Кондратьев", "Олег Петрович"),
            "Соколова Инна Ивановна",
            new Employee("Соколова", "Инна Ивановна"),
            "Петров Алексей Владимирович",
            new Employee("Петров", "Алексей Владимирович"),
            "Григорьев Кирилл Александрович",
            new Employee("Григорьев", "Кирилл Александрович")
//            new Employee("Нестерова", "Ольга Михайловна", 2, 89950),
//            new Employee("Меньшов", "Кирилл Александрович", 4, 101570),
//            new Employee("Меньшова", "Наталья Юрьевна", 4, 72290),
//            new Employee("Королькова", "Светлана Николаевна", 5, 96440)
    ));

    @Override
    public Map<String, Employee> printEmployees() {
        return new HashMap<>(employees);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен.");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employees.get(employee.getFullName());
    }
}

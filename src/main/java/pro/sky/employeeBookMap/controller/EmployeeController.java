package pro.sky.employeeBookMap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBookMap.Employee;
import pro.sky.employeeBookMap.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public Map<String, Employee> printEmployees() {
        return employeeService.printEmployees();
    }

    @GetMapping("add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName) {

        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam("firstname") String firstName,
                                 @RequestParam("lastname") String lastName) {

        return employeeService.findEmployee(firstName, lastName);
    }
}

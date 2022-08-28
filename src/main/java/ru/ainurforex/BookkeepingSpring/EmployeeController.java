package ru.ainurforex.BookkeepingSpring;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "add")
    public Employee add(@RequestParam("firstName") String firstname,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("salary") int salary) {
        return employeeService.addEmployee(firstname, lastName, department, salary);
    }

    @GetMapping(path = "addTest")
    public Collection<Employee> addTest() {
        employeeService.addTestEmployee();
        return employeeService.printAllEmployee();
    }

    @GetMapping(path = "remove")
    public Employee remove(@RequestParam("firstName") String firstname,
                           @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstname, lastName);
    }

    @GetMapping(path = "find")
    public Employee find(@RequestParam("firstName") String firstname,
                         @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstname, lastName);
    }

    @GetMapping(path = "printAllEmployee")
    public Collection<Employee> printAllEmployee() {
        return employeeService.printAllEmployee();
    }


    @GetMapping(path = "/departments/max-salary")
    public Optional<Employee> findEmployeesMaxSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return employeeService.findEmployeesMaxSalaryInDepartmentId(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Optional<Employee> findEmployeesMinSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return employeeService.findEmployeesMinSalaryInDepartmentId(department);
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public Collection<Employee> listOfEmployeesInDepartment(@RequestParam("departmentId") Integer department) {
        return employeeService.listOfEmployeesInDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public Collection<Employee> listOfEmployeesInDepartment() {
        return employeeService.listOfEmployeesAllDepartment();

    }
}

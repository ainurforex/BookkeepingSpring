package ru.ainurforex.BookkeepingSpring;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;



@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "add")
    public Employee add(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstname, lastName);
    }

    @GetMapping(path = "remove")
    public Employee remove(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstname, lastName);
    }

    @GetMapping(path = "find")
    public Employee find(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstname, lastName);
    }

    @GetMapping(path = "printAllEmployee")
    public Collection<Employee> printAllEmployee() {
        return employeeService.printAllEmployee();
    }
}

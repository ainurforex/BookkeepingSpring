package ru.ainurforex.BookkeepingSpring;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "add")
    public String add(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {

        Employee employee = new Employee(firstname, lastName);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeAlreadyAddedException e) {
            return e.getMessage();
        }
        return employee.toString();
    }

    @GetMapping(path = "remove")
    public String remove(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstname, lastName);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return employee.toString();
    }

    @GetMapping(path = "find")
    public String find(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstname, lastName);
        try {
            if (employeeService.findEmployee(employee)) {
                return employee.toString();
            }
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return "";
    }

    @GetMapping(path = "printallemployee")
    public List printAllEmployee() {
        return employeeService.printAllEmployee();
    }

    @GetMapping(path = "printindex")
    public Employee printIndex(@RequestParam("index") int index) {
        return employeeService.getEmployeeForIndex(index);
    }

}

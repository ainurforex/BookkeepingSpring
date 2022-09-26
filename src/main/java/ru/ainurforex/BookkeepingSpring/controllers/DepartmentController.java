package ru.ainurforex.BookkeepingSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ainurforex.BookkeepingSpring.services.DepartmentService;
import ru.ainurforex.BookkeepingSpring.classes.Employee;
import ru.ainurforex.BookkeepingSpring.services.DepartmentServiceInterface;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "employee/departments")
public class DepartmentController {
    final private DepartmentServiceInterface departmentService;

    public DepartmentController(DepartmentServiceInterface departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "max-salary")
    public Optional<Employee> findEmployeesMaxSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesMaxSalaryInDepartmentId(department);
    }

    @GetMapping(path = "min-salary")
    public Optional<Employee> findEmployeesMinSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesMinSalaryInDepartmentId(department);
    }

    @GetMapping(path = "all", params = "departmentId")
    public Collection<Employee> listOfEmployeesInDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.listOfEmployeesInDepartment(department);
    }

    @GetMapping(path = "all")
    public Collection<Employee> listOfEmployeesInDepartment() {
        return departmentService.listOfEmployeesAllDepartment();
    }
}

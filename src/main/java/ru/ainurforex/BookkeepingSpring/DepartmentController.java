package ru.ainurforex.BookkeepingSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "employee")
public class DepartmentController {
    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/departments/max-salary")
    public Optional<Employee> findEmployeesMaxSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesMaxSalaryInDepartmentId(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Optional<Employee> findEmployeesMinSalaryInDepartmentId(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesMinSalaryInDepartmentId(department);
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public Collection<Employee> listOfEmployeesInDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.listOfEmployeesInDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public Collection<Employee> listOfEmployeesInDepartment() {
        return departmentService.listOfEmployeesAllDepartment();

    }
}

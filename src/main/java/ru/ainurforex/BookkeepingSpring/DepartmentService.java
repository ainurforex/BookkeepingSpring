package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    final private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> findEmployeesMaxSalaryInDepartmentId(int department) {

        return Optional.of(employeeService.getEmployeesBook().values()
                .stream().filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingInt(e -> e.getSalary())).orElseThrow(() -> new DepartmentNotFound()));
    }

    public Optional<Employee> findEmployeesMinSalaryInDepartmentId(int department) {
        return Optional.of(employeeService.getEmployeesBook().values().stream()
                .filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList())
                .stream().min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new DepartmentNotFound()));
    }


    public Collection<Employee> listOfEmployeesInDepartment(int department) {
        return Collections.unmodifiableCollection(employeeService.getEmployeesBook().values().stream()
                .filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList()));
    }

    public Collection<Employee> listOfEmployeesAllDepartment() {
        HashSet<Integer> departments = new HashSet<>(employeeService.getEmployeesBook().values().stream()
                .map(d -> d.getDepartment())
                .collect(Collectors.toList()));
        List<Employee> listOfEmployeesSortByDepartment = new ArrayList<>();
        departments.forEach(integer -> listOfEmployeesSortByDepartment.addAll(employeeService.getEmployeesBook().values().stream()
                .filter(d -> d.getDepartment() == integer)
                .collect(Collectors.toList()))
        );
        return Collections.unmodifiableCollection(listOfEmployeesSortByDepartment);
    }

}

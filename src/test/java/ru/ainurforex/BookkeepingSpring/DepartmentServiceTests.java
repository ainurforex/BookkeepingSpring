package ru.ainurforex.BookkeepingSpring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ainurforex.BookkeepingSpring.classes.Employee;
import ru.ainurforex.BookkeepingSpring.exceptions.DepartmentNotFound;
import ru.ainurforex.BookkeepingSpring.services.DepartmentService;
import ru.ainurforex.BookkeepingSpring.services.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static ru.ainurforex.BookkeepingSpring.Constats.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {
    @Mock
    private EmployeeService employeeServiceMock;
    private DepartmentService departmentService;

    @BeforeEach
    public void initDepartmentService() {
        departmentService = new DepartmentService(employeeServiceMock);
    }


    @Test
    public void shouldFindEmployeesMaxSalaryInDepartmentId() {
        Optional<Employee> actual = Optional.of(new Employee(firstName, lastName, department, salary));
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        Assertions.assertEquals(departmentService.findEmployeesMaxSalaryInDepartmentId(1).toString(), actual.toString());
    }

    @Test
    public void shouldThrowDepartmentNotFoundByfindEmployeesMaxSalaryInDepartmentIdByDepartmentNotFound() {
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        Assertions.assertThrows(DepartmentNotFound.class, () -> departmentService.findEmployeesMaxSalaryInDepartmentId(10));
    }

    @Test
    public void shouldFindEmployeesMinSalaryInDepartmentId() {
        Optional<Employee> actual = Optional.of(new Employee(firstName2, lastName2, department2, salary2));
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        Assertions.assertEquals(departmentService.findEmployeesMinSalaryInDepartmentId(1).toString(), actual.toString());
    }

    @Test
    public void shouldThrowDepartmentNotFoundByfindEmployeesMinSalaryInDepartmentIdByDepartmentNotFound() {
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        Assertions.assertThrows(DepartmentNotFound.class, () ->
                departmentService.findEmployeesMinSalaryInDepartmentId(10));
    }

    @Test
    public void shouldlistOfEmployeesInDepartment() {
        Collection<Employee> actual = new ArrayList<>(List.of(
                new Employee(firstName, lastName, department, salary),
                new Employee(firstName2, lastName2, department2, salary2))).
                stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        List<Employee> excepted = departmentService.listOfEmployeesInDepartment(1).stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
        Assertions.assertEquals(excepted.toString(), actual.toString());
    }

    @Test
    public void shouldlistOfEmployeesAllDepartment() {
        Collection<Employee> actual = List.of(
                        new Employee(firstName, lastName, department, salary),
                        new Employee(firstName2, lastName2, department2, salary2),
                        new Employee(firstName3, lastName3, department3, salary3),
                        new Employee(firstName4, lastName4, department4, salary4)).
                stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
        when(employeeServiceMock.getEmployeesBook()).thenReturn(mapOfEmployee);
        Collection<Employee> excepted = departmentService.listOfEmployeesAllDepartment().stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
        Assertions.assertEquals(excepted.toString(), actual.toString());
    }

}

package ru.ainurforex.BookkeepingSpring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ainurforex.BookkeepingSpring.classes.Employee;
import ru.ainurforex.BookkeepingSpring.exceptions.EmployeeAlreadyAddedException;
import ru.ainurforex.BookkeepingSpring.exceptions.EmployeeNotFoundException;
import ru.ainurforex.BookkeepingSpring.exceptions.InvalidInputException;
import ru.ainurforex.BookkeepingSpring.services.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static ru.ainurforex.BookkeepingSpring.Constats.*;

public class EmployeeServiceTests {
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    public void shouldAddEmployee() {

        employeeService.addEmployee(firstName, lastName, department, salary);
        String actual = "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary +
                '\"' + "}" + "," + "\n" + "</p>";
        String excepted = employeeService.toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionByAlreadyAddedEployee() {
        employeeService.addEmployee(firstName, lastName, department, salary);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.addEmployee(firstName, lastName, department, salary));
    }

    @Test
    public void shouldRemoveEmployee() {
        employeeService.addEmployee(firstName, lastName, department, salary);
        String actual = "\n" + "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary +
                '\"' + "}" + "," + "\n" + "</p>";
        String excepted = employeeService.removeEmployee(firstName, lastName).toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionByNotFoundEployeeByRemoveEmployee() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.removeEmployee(firstName, lastName));
    }

    @Test
    public void shouldFindEmployee() {
        employeeService.addEmployee(firstName, lastName, department, salary);
        String actual = "\n" + "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary +
                '\"' + "}" + "," + "\n" + "</p>";
        String excepted = employeeService.findEmployee(firstName, lastName).toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionByNotFoundEployeeByFindEmployee() {
        employeeService.addEmployee(firstName, lastName, department, salary);
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.findEmployee(firstName2, lastName2));
    }

    @Test
    public void shouldPrintAllEmployee() {
        employeeService.addEmployee(firstName, lastName, department, salary);
        employeeService.addEmployee(firstName2, lastName2, department2, salary2);
        String actual = "[" + "\n" + "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName2 +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName2 +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department2 +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary2 +
                '\"' + "}" + "," + "\n" + "</p>" + "," + " " + "\n" + "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary +
                '\"' + "}" + "," + "\n" + "</p>" + "]";
        String excepted = employeeService.printAllEmployee().toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldGetEmployeeBook() {
        Map<String, Employee> actual = new HashMap<>();
        actual.put(firstName + lastName, new Employee(firstName, lastName, department, salary));
        actual.put(firstName2 + lastName2, new Employee(firstName2, lastName2, department2, salary2));
        employeeService.addEmployee(firstName, lastName, department, salary);
        employeeService.addEmployee(firstName2, lastName2, department2, salary2);
        Map<String, Employee> excepted = employeeService.getEmployeesBook();
        Assertions.assertEquals(excepted.keySet(), actual.keySet());
    }

    @Test
    public void shouldThrowInvalidInputExceptionByValidateInput() {
        Assertions.assertThrows(InvalidInputException.class, () ->
                employeeService.addEmployee(firstNameNotValid, lastNameNotValid, department, salary));
    }
}

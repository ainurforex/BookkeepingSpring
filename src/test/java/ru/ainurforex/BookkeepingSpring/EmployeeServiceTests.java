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

        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        String actual = "firstName " + FIRST_NAME + " lastName " + LAST_NAME +
                " department " + DEPARTMENT + " salary " + SALARY + "\n";
        String excepted = employeeService.toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionByAlreadyAddedEployee() {
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    public void shouldRemoveEmployee() {
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        String actual = "firstName " + FIRST_NAME + " lastName " + LAST_NAME +
                " department " + DEPARTMENT + " salary " + SALARY + "\n";
        String excepted = employeeService.removeEmployee(FIRST_NAME, LAST_NAME).toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionByNotFoundEployeeByRemoveEmployee() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.removeEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldFindEmployee() {
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        String actual = "firstName " + FIRST_NAME + " lastName " + LAST_NAME +
                " department " + DEPARTMENT + " salary " + SALARY + "\n";
        String excepted = employeeService.findEmployee(FIRST_NAME, LAST_NAME).toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionByNotFoundEployeeByFindEmployee() {
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.findEmployee(FIRST_NAME_2, LAST_NAME_2));
    }

    @Test
    public void shouldPrintAllEmployee() {
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        employeeService.addEmployee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
        String actual = "["+"firstName " + FIRST_NAME_2 + " lastName " + LAST_NAME_2 +
                " department " + DEPARTMENT_2 + " salary " + SALARY_2 + "\n";
        actual = actual + ","+" "+"firstName " + FIRST_NAME + " lastName " + LAST_NAME +
                " department " + DEPARTMENT + " salary " + SALARY + "\n"+"]";
        String excepted = employeeService.printAllEmployee().toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void shouldGetEmployeeBook() {
        Map<String, Employee> actual = new HashMap<>();
        actual.put(FIRST_NAME + LAST_NAME, new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
        actual.put(FIRST_NAME_2 + LAST_NAME_2, new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2));
        employeeService.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);
        employeeService.addEmployee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
        Map<String, Employee> excepted = employeeService.getEmployeesBook();
        Assertions.assertEquals(excepted.keySet(), actual.keySet());
    }

    @Test
    public void shouldThrowInvalidInputExceptionByValidateInput() {
        Assertions.assertThrows(InvalidInputException.class, () ->
                employeeService.addEmployee(FIRST_NAME_NOT_VALID, LAST_NAME_NOT_VALID, DEPARTMENT, SALARY));
    }
}

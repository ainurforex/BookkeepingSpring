package ru.ainurforex.BookkeepingSpring.services;

import ru.ainurforex.BookkeepingSpring.classes.Employee;

import java.util.Collection;
import java.util.Map;


public interface EmployeeServiceInterface {

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Collection<Employee> addTestEmployee();

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> printAllEmployee();

    Map<String, Employee> getEmployeesBook();

}

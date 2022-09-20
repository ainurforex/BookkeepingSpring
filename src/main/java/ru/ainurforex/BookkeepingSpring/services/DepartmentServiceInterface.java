package ru.ainurforex.BookkeepingSpring.services;

import ru.ainurforex.BookkeepingSpring.classes.Employee;

import java.util.*;

public interface DepartmentServiceInterface {

    Optional<Employee> findEmployeesMaxSalaryInDepartmentId(int department);

    Optional<Employee> findEmployeesMinSalaryInDepartmentId(int department);

    Collection<Employee> listOfEmployeesInDepartment(int department);

    Collection<Employee> listOfEmployeesAllDepartment();

}

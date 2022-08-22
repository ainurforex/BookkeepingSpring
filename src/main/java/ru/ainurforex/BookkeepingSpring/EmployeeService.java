package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private Map<String, Employee> employeesBook;

    public EmployeeService() {
        this.employeesBook = new HashMap<>();
    }

    @Override
    public String toString() {
        String result = "<p>" + "\n";
        for (Employee value : employeesBook.values()) {
            result = result + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + value.getFirstName() + '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + value.getLastName() + '\"' + "}" + "," + "\n";
        }
        return result + "</p>";
    }

    public Employee addEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employeesBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Работник с данными параметрами уже существует");
        }
        employeesBook.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesBook.containsKey(employee.getFullName())) {
            employeesBook.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesBook.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Collection<Employee> printAllEmployee() {
        return Collections.unmodifiableCollection(employeesBook.values());
    }

}

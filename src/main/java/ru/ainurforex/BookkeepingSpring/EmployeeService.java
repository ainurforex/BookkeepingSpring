package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;
import java.util.*;


import static org.apache.commons.lang3.StringUtils.*;

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
            result = result + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + value.getFirstName() +
                    '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + value.getLastName() +
                    '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + value.getDepartment() +
                    '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + value.getSalary() +
                    '\"' + "}" + "," + "\n";
        }
        return result + "</p>";
    }

    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeesBook.containsKey(employee.takeFullName())) {
            throw new EmployeeAlreadyAddedException("Работник с данными параметрами уже существует");
        }
        employeesBook.put(employee.takeFullName(), employee);
        return employee;
    }

    public Collection<Employee> addTestEmployee() {
        employeesBook.put("Petrov" + "Petr", new Employee("Petrov", "Petr", 4, 1000));
        employeesBook.put("Maksimov" + "Maksim", new Employee("Maksimov", "Maksim", 1, 2000));
        employeesBook.put("Vasil" + "Vas", new Employee("Vasil", "Vas", 2, 3000));
        employeesBook.put("Pikiv" + "Pik", new Employee("Pikiv", "Pik", 2, 1000));
        employeesBook.put("Gatov" + "Gat", new Employee("Gatov", "Gat", 6, 11000));
        employeesBook.put("Ribov" + "Rib", new Employee("Ribov", "Rib", 1, 16000));
        return Collections.unmodifiableCollection(employeesBook.values());
    }

    public Employee removeEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);
        String keyFullName = firstName + lastName;
        if (employeesBook.containsKey(keyFullName)) {
            Employee employeeReturn = employeesBook.get(keyFullName);
            employeesBook.remove(keyFullName);
            return employeeReturn;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Employee findEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);
        String keyFullName = firstName + lastName;
        if (employeesBook.containsKey(keyFullName)) {
            Employee employeeReturn = employeesBook.get(keyFullName);
            return employeeReturn;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Collection<Employee> printAllEmployee() {
        return Collections.unmodifiableCollection(employeesBook.values());
    }

    public  Map<String, Employee> getEmployeesBook() {
        return Collections.unmodifiableMap(employeesBook);
    }

    private void validateInput(String firstName,String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new invalidInputException("Имя и фамилия должны состоять только из букв");
        }
    }
}

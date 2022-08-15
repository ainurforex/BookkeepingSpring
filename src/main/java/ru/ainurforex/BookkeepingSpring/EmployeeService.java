package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeesBook;

    public EmployeeService() {
        this.employeesBook = new ArrayList<>();
    }

    public Employee addEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (findEmployeeInList(employee) >= 0) {
            throw new EmployeeAlreadyAddedException("Работник с данными параметрами уже существует");
        }

        employeesBook.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = findEmployeeInList(employee);
        if (index >= 0) {
            employeesBook.set(index, null);
            return employee;
        }

        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = findEmployeeInList(employee);
        if (index >= 0) {
            return employee;
        }

        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }

    private int findEmployeeInList(Employee employee) {
        for (int i = 0; i < employeesBook.size(); i++) {
            if (employeesBook.get(i) == null) {
                continue;
            }
            if (employeesBook.get(i).equals(employee)) {
                return i;
            }
        }
        return -1;
    }

    public List printAllEmployee() {
        return employeesBook;
    }

}

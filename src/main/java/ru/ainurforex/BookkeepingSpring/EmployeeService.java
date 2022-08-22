package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employeesBook;

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
        if (findEmployeeInMap(employee)) {
            throw new EmployeeAlreadyAddedException("Работник с данными параметрами уже существует");
        }
        employeesBook.put(employee.hashCode(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (findEmployeeInMap(employee)) {
            employeesBook.remove(employee.hashCode());
            return employee;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (findEmployeeInMap(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }

    private boolean findEmployeeInMap(Employee employee) {

        if (employeesBook.containsKey(employee.hashCode())) {
            return true;
        }
        return false;
    }

    public List printAllEmployee() {
        List<Employee> list = new ArrayList<>(employeesBook.values());
        return list;
    }

}

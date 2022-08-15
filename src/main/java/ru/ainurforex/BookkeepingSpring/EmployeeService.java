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

    @Override
    public String toString() {
        String stringEmployeeBook = "";
        for (int i = 0; i < employeesBook.size(); i++) {
            if (employeesBook.get(i) != null) {
                stringEmployeeBook = stringEmployeeBook + "N:" + i +
                        " First name:" + employeesBook.get(i).getFirstName() +
                        " Last name:" + employeesBook.get(i).getLastName() + "\n";
            }


        }
        return stringEmployeeBook;
    }

    public void addEmployee(Employee employee) {

        try {
            if (findEmployee(employee) == true) {
                throw new EmployeeAlreadyAddedException("Работник с данными параметрами уже существует");
            }
        } catch (EmployeeNotFoundException e) {
            employeesBook.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        for (int i = 0; i < employeesBook.size(); i++) {
            if (employeesBook.get(i) == null) {
                continue;
            }
            if (employeesBook.get(i).equals(employee)) {
                employeesBook.set(i, null);
                break;
            }
            if (i == employeesBook.size() - 1) {
                throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
            }
        }

    }

    public boolean findEmployee(Employee employee) {
        for (int i = 0; i < employeesBook.size(); i++) {
            if (employeesBook.get(i) == null) {
                continue;
            }
            if (employeesBook.get(i).equals(employee)) {
                return true;
            }

        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }

    public Employee getEmployeeForIndex(int employeeIndex) {
        try {
            return employeesBook.get(employeeIndex);
        } catch (NullPointerException e) {
            throw new IndexNotFound();
        }
    }

    public List printAllEmployee() {
        return employeesBook;
    }

}

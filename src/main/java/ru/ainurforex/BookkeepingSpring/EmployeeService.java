package ru.ainurforex.BookkeepingSpring;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Employee addEmployee(String firstname, String lastName, int department, int salary) {
        Employee employee = new Employee(firstname, lastName, department, salary);
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
        return Collections.unmodifiableCollection(employeesBook.values());
    }

    public Employee removeEmployee(String firstName, String lastName) {
        int department = 0;
        int salary = 0;
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeesBook.containsKey(employee.takeFullName())) {
            Employee employeeReturn = employeesBook.get(employee.takeFullName());
            employeesBook.remove(employee.takeFullName());
            return employeeReturn;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Employee findEmployee(String firstName, String lastName) {
        int department = 0;
        int salary = 0;
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeesBook.containsKey(employee.takeFullName())) {
            Employee employeeReturn = employeesBook.get(employee.takeFullName());
            return employeeReturn;
        }
        throw new EmployeeNotFoundException("Работник с данными параметрами не найден.");
    }


    public Collection<Employee> printAllEmployee() {
        return Collections.unmodifiableCollection(employeesBook.values());
    }

    public Optional<Employee> findEmployeesMaxSalaryInDepartmentId(int department) {
        return Optional.of(employeesBook.values()
                .stream().filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingInt(e -> e.getSalary())).orElseThrow(() -> new DepartmentNotFound()));
    }

    public Optional<Employee> findEmployeesMinSalaryInDepartmentId(int department) {
        return Optional.of(employeesBook.values()
                .stream().filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList())
                .stream().min(Comparator.comparingInt(e -> e.getSalary())).orElseThrow(() -> new DepartmentNotFound()));
    }


    public Collection<Employee> listOfEmployeesInDepartment(int department) {
        return Collections.unmodifiableCollection(employeesBook.values().stream().filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList()));
    }

    public Collection<Employee> listOfEmployeesAllDepartment() {
        HashSet<Integer> departments = new HashSet<>(employeesBook
                .values().stream().map(d -> d.getDepartment())
                .collect(Collectors.toList()));
        List<Employee> listOfEmployeesSortByDepartment = new ArrayList<>();
        departments.forEach(integer -> listOfEmployeesSortByDepartment
                .addAll(employeesBook.values().stream()
                        .filter(d -> d.getDepartment() == integer)
                        .collect(Collectors.toList()))
        );
        return Collections.unmodifiableCollection(listOfEmployeesSortByDepartment);
    }

}

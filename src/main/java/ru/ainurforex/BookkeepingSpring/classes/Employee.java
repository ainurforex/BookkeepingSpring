package ru.ainurforex.BookkeepingSpring.classes;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n" + "<p>" + "\n" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName +
                '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName +
                '\"' + "," + '\"' + "department" + '\"' + ":" + '\"' + department +
                '\"' + "," + '\"' + "salary" + '\"' + ":" + '\"' + salary +
                '\"' + "}" + "," + "\n" + "</p>";
    }

    @Override
    public final int hashCode() {
        return (firstName + lastName).hashCode();
    }

    public final boolean equals(Employee employee) {
        return (this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String takeFullName() {
        return firstName + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
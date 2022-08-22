package ru.ainurforex.BookkeepingSpring;

public class Employee {
    private String firstName;
    private String lastName;



    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "<p>" + "{" + '\"' + "firstName" + '\"' + ":" + '\"' + firstName + '\"' + "," + '\"' + "lastName" + '\"' + ":" + '\"' + lastName + '\"' + "}" + "</p>";
    }

    @Override
    public int hashCode() {
        return (firstName + lastName).hashCode();
    }

    public boolean equals(Employee employee) {
        return (this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName+lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
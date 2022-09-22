package ru.ainurforex.BookkeepingSpring;

import ru.ainurforex.BookkeepingSpring.classes.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Constats {

    public final static String firstName = "Petr";
    public final static String lastName = "Petrov";
    public final static int department = 1;
    public final static int salary = 30000;
    public final static String firstName2 = "Ivan";
    public final static String lastName2 = "Ivanov";
    public final static int department2 = 1;
    public final static int salary2 = 20000;

    public final static String firstName3 = "Sidr";
    public final static String lastName3 = "Sidorov";
    public final static int department3 = 2;
    public final static int salary3 = 30000;

    public final static String firstName4 = "Vasia";
    public final static String lastName4 = "Vasilev";
    public final static int department4 = 2;
    public final static int salary4 = 35000;
    public final static String firstNameNotValid = "Ivan1";
    public final static String lastNameNotValid = "Ivano%v";

    public final static Map<String, Employee> mapOfEmployee = Map.of(
            firstName + lastName, new Employee(firstName, lastName, department, salary),
            firstName2 + lastName2, new Employee(firstName2, lastName2, department2, salary2),
            firstName3 + lastName3, new Employee(firstName3, lastName3, department3, salary3),
            firstName4 + lastName4, new Employee(firstName4, lastName4, department4, salary4));

}

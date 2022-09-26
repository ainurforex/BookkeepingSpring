package ru.ainurforex.BookkeepingSpring;

import ru.ainurforex.BookkeepingSpring.classes.Employee;

import java.util.Map;



public class Constats {

    public final static String FIRST_NAME = "Petr";
    public final static String LAST_NAME = "Petrov";
    public final static int DEPARTMENT = 1;
    public final static int SALARY = 30000;
    public final static String FIRST_NAME_2 = "Ivan";
    public final static String LAST_NAME_2 = "Ivanov";
    public final static int DEPARTMENT_2 = 1;
    public final static int SALARY_2 = 20000;

    public final static String FIRST_NAME_3 = "Sidr";
    public final static String LAST_NAME_3 = "Sidorov";
    public final static int DEPARTMENT_3 = 2;
    public final static int SALARY_3 = 30000;

    public final static String FIRST_NAME_4 = "Vasia";
    public final static String LAST_NAME_4 = "Vasilev";
    public final static int DEPARTMENT_4 = 2;
    public final static int SALARY_4 = 35000;
    public final static String FIRST_NAME_NOT_VALID = "Ivan1";
    public final static String LAST_NAME_NOT_VALID = "Ivano%v";

    public final static Map<String, Employee> MAP_OF_EMPLOYEE = Map.of(
            FIRST_NAME + LAST_NAME, new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY),
            FIRST_NAME_2 + LAST_NAME_2, new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2),
            FIRST_NAME_3 + LAST_NAME_3, new Employee(FIRST_NAME_3, LAST_NAME_3, DEPARTMENT_3, SALARY_3),
            FIRST_NAME_4 + LAST_NAME_4, new Employee(FIRST_NAME_4, LAST_NAME_4, DEPARTMENT_4, SALARY_4));

}

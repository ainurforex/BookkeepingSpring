package ru.ainurforex.BookkeepingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookkeepingSpringApplication {

	public static void main(String[] args) {
		/*Employee employee1=new Employee("Ainur","Sharipov");
		System.out.println(employee1);
		EmployeeService employeeService1=new EmployeeService();
		employeeService1.addEmployee("Ainur","Sharipov");
		employeeService1.addEmployee("Vas","Vivov");
		employeeService1.addEmployee("Vas1","Vivov");
		employeeService1.addEmployee("Vas2","Vivov");
		employeeService1.addEmployee("Vas3","Vivov");
		System.out.println(employeeService1);
		System.out.println(employeeService1.findEmployeeIndex("Ainur", "Sharipov"));
		System.out.println(employeeService1);*/
		SpringApplication.run(BookkeepingSpringApplication.class, args);
	}

}

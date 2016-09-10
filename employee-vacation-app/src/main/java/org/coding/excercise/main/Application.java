package org.coding.excercise.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.coding.excercise.service.EmployeeVacationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Application {

	public static void main(String[] args) {
		
		// building data
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeVacationService service = (EmployeeVacationService) ctx.getBean("employeeVacationService");
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Integer empId = service.createEmployee("Venkat", "Uppalapati", "uvks");
		System.out.println(empId);
		try {
			service.addVacation(empId, sdf.parse("09/09/2016"), sdf.parse("09/12/2016"));
			service.addVacation(empId, sdf.parse("09/20/2016"), sdf.parse("09/26/2016"));
			service.addVacation(empId, sdf.parse("10/01/2016"), sdf.parse("10/03/2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

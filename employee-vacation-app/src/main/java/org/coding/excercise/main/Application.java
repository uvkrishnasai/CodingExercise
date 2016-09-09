package org.coding.excercise.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.coding.excercise.dao.EmployeeDAO;
import org.coding.excercise.entitybeans.Employee;
import org.coding.excercise.entitybeans.Vacation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeDAO employeeDAO = (EmployeeDAO) ctx.getBean("employeeDAO");
        Employee emp = new Employee();
        emp.setUserName("uvks");
        emp.setFirstName("Venkat");
        emp.setLastName("Uppalapati");
        emp.setVacationInfoList(new ArrayList<Vacation>());
        
        Vacation vac = new Vacation();
        Vacation vac1 = new Vacation();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
			vac.setFromDate(sdf.parse("09/08/2019"));
			vac.setToDate(sdf.parse("09/10/2019"));
			emp.getVacationInfoList().add(vac);
			vac1.setFromDate(sdf.parse("09/15/2019"));
			vac1.setToDate(sdf.parse("09/16/2019"));
			emp.getVacationInfoList().add(vac1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        employeeDAO.insertEmployee(emp);
        
        Employee emp1 = employeeDAO.getEmployee(1);
        System.out.println("*********");
		System.out.println(emp1.getUserName());
		for (Vacation vacation : emp1.getVacationInfoList()) {
			System.out.println(vacation.getVacationId());
			System.out.println(vacation.getFromDate());
			System.out.println(vacation.getToDate());
			System.out.println(vacation.getEmployee());
		}
		System.out.println("*********");
	}
}

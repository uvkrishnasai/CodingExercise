package org.coding.excercise.service;

import java.util.ArrayList;
import java.util.Date;

import org.coding.excercise.dao.EmployeeDAO;
import org.coding.excercise.entitybeans.Employee;
import org.coding.excercise.entitybeans.Vacation;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeVacationServiceImpl implements EmployeeVacationService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void createEmployee(String firstName, String lastName, String userName){
		Employee emp = new Employee();
        emp.setUserName(userName);
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        employeeDAO.insertEmployee(emp);
	}
	
	public void addVacation(Integer empId, Date fromDate, Date toDate){
		Employee emp = employeeDAO.getEmployee(empId);
		if (emp!=null) {
			if (emp.getVacationInfoList() == null) {
				emp.setVacationInfoList(new ArrayList<Vacation>());
			}
			Vacation vac = new Vacation();
			vac.setFromDate(fromDate);
			vac.setToDate(toDate);
			vac.setEmployee(emp);
		}
		employeeDAO.addVacation(emp);
	}
	
	public Employee getEmployee(Integer empId){
		return employeeDAO.getEmployee(empId);
	}

}

package org.coding.excercise.service;

import java.util.Date;

import org.coding.excercise.entitybeans.Employee;

public interface EmployeeVacationService {
	
	public void createEmployee(String firstName, String lastName, String userName);
	public void addVacation(Integer empId, Date fromDate, Date toDate);
	public Employee getEmployee(Integer empId);
}

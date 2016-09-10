package org.coding.excercise.service;

import java.util.Date;
import java.util.List;

import org.coding.excercise.entitybeans.Employee;

/**
 * 
 * @author Venkata.Uppalapati
 *
 */
public interface EmployeeVacationService {
	
	public Integer createEmployee(String firstName, String lastName, String userName);
	public void addVacation(Integer empId, Date fromDate, Date toDate);
	public Employee getEmployee(Integer empId);
	public List<Employee> getAllEmployees();
}

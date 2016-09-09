package org.coding.excercise.dao;

import org.coding.excercise.entitybeans.Employee;

public interface EmployeeDAO {

	public void insertEmployee(Employee employee);
	
	public Employee getEmployee(Integer empId);
	
	public void addVacation(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer empId);
	
}

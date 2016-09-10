package org.coding.excercise.dao;

import java.util.List;

import org.coding.excercise.entitybeans.Employee;

/**
 * 
 * @author Venkata.Uppalapati
 *
 */
public interface EmployeeDAO {

	public Integer insertEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(Integer empId);
	
	public void addVacation(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer empId);
	
}

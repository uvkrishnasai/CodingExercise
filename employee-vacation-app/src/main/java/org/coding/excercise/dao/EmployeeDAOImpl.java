package org.coding.excercise.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.coding.excercise.db.DBConnections;
import org.coding.excercise.entitybeans.Employee;
import org.coding.excercise.entitybeans.Vacation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Venkata.Uppalapati
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	public DBConnections h2Connection;

	/**
	 * Create Employee
	 * @param employee
	 * @return
	 */
	@Override
	public Integer insertEmployee(Employee employee) {
		Integer empId = null;
		Connection connection = h2Connection.getDBConnection();
		PreparedStatement empPreparedStatement = null;
		try {
			
			if (employee != null) {
				String selectEMPSeq = "SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL";
				CallableStatement empSEQCallableStatement = connection.prepareCall(selectEMPSeq);
				ResultSet employeeResultSet = empSEQCallableStatement.executeQuery();
				if(employeeResultSet.next())
					empId = employeeResultSet.getInt(1);
				
				if (empId == null) {
					throw new RuntimeException("Sequnce not created properly");
				}
				
				String insertEMPTableSQL = "INSERT INTO EMPLOYEE"
		        		+ "("
		        		+ "EMP_ID, "
		        		+ "USERNAME, "
		        		+ "FIRSTNAME, "
		        		+ "LASTNAME"
		        		+ ") "
		        		+ "VALUES"
		        		+ "(?,?,?,?)";
				empPreparedStatement = connection.prepareStatement(insertEMPTableSQL);
				empPreparedStatement.setInt(1, empId);
				empPreparedStatement.setString(2, employee.getUserName());
				empPreparedStatement.setString(3, employee.getFirstName());
				empPreparedStatement.setString(4, employee.getLastName());
				empPreparedStatement.executeUpdate();
				
				empSEQCallableStatement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.commit();
				if(empPreparedStatement!=null)
					empPreparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empId;
	}
	
	/**
	 * Get All Employees
	 * @return
	 */
	public List<Employee> getAllEmployees(){
		Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		Connection connection = h2Connection.getDBConnection();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE LEFT JOIN VACATION ON EMPLOYEE.EMP_ID = VACATION.EMP_ID");
			while (resultSet.next()) {
				Integer empId = resultSet.getInt("EMP_ID");
				
				if (empId == 0) {
					continue;
				}
				
				Employee emp = employeeMap.get(empId);
				
				if (emp == null) {
					emp = new Employee();
					emp.setEmpId(resultSet.getInt("EMP_ID"));
					emp.setFirstName(resultSet.getString("FIRSTNAME"));
					emp.setLastName(resultSet.getString("LASTNAME"));
					emp.setUserName(resultSet.getString("USERNAME"));
					emp.setVacationInfoList(new ArrayList<Vacation>());
					employeeMap.put(empId, emp);
				}
				
				Integer vacationId = resultSet.getInt("VACATION_ID");
				
				if (vacationId!=null && vacationId.compareTo(Integer.valueOf(0))!=0) {
					Vacation vacation = new Vacation();
					vacation.setVacationId(vacationId);
					vacation.setFromDate(resultSet.getDate("FROM_DATE"));
					vacation.setToDate(resultSet.getDate("END_DATE"));
					
					emp.getVacationInfoList().add(vacation);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (employeeMap.values()!=null && !employeeMap.values().isEmpty())?new ArrayList<Employee>(employeeMap.values()): new ArrayList<Employee>();
	}

	/**
	 * Get Employees by Employee Id
	 * @param empId
	 * @return
	 */
	@Override
	public Employee getEmployee(Integer empId) {
		Employee employee = new Employee();
		Connection connection = h2Connection.getDBConnection();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE LEFT JOIN VACATION ON EMPLOYEE.EMP_ID = VACATION.EMP_ID WHERE EMPLOYEE.EMP_ID = " + empId);
			
			boolean skip = false;
			
			while (resultSet.next()) {
				if (!skip) {
					employee.setEmpId(resultSet.getInt("EMP_ID"));
					employee.setFirstName(resultSet.getString("FIRSTNAME"));
					employee.setLastName(resultSet.getString("LASTNAME"));
					employee.setUserName(resultSet.getString("USERNAME"));
					employee.setVacationInfoList(new ArrayList<Vacation>());
					skip = true;
				}
				
				Integer vacationId = resultSet.getInt("VACATION_ID");
				
				if (vacationId!=null && vacationId.compareTo(Integer.valueOf(0))!=0) {
					Vacation vacation = new Vacation();
					vacation.setVacationId(vacationId);
					vacation.setEmployee(employee);
					vacation.setFromDate(resultSet.getDate("FROM_DATE"));
					vacation.setToDate(resultSet.getDate("END_DATE"));
				}
				
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return employee;
	}
	
	/**
	 * Add Employee vacation
	 * @param employee
	 */
	public void addVacation(Employee employee){
		Connection connection = h2Connection.getDBConnection();
		PreparedStatement vacPreparedStatement= null;
		try {
			
			
			if (employee != null) {
				
				if (employee.getVacationInfoList()!=null && !employee.getVacationInfoList().isEmpty()) {
					String selectVACATIONSeq = "SELECT SEQ_VACATION_ID.NEXTVAL FROM DUAL";
					CallableStatement vacSEQCallableStatement = connection.prepareCall(selectVACATIONSeq);
					String insertVACTableSQL = "INSERT INTO VACATION"
				        		+ "("
				        		+ "VACATION_ID, "
				        		+ "EMP_ID, "
				        		+ "FROM_DATE, "
				        		+ "END_DATE"
				        		+ ") "
				        		+ "VALUES"
				        		+ "(?,?,?,?)";
					
					ResultSet vacResultSet = vacSEQCallableStatement.executeQuery();
					Integer vacationId = null;
					if (vacResultSet.next()) 
						vacationId = vacResultSet.getInt(1);
					
					for (Vacation vacation : employee.getVacationInfoList()) {
						
						if (vacationId == null) {
							throw new RuntimeException("Vaction Sequnce not initiated properly");
						}
						
						vacPreparedStatement = connection.prepareStatement(insertVACTableSQL);
						vacPreparedStatement.setInt(1, vacationId);
						vacPreparedStatement.setInt(2, employee.getEmpId());
						vacPreparedStatement.setDate(3, vacation.getFromDate()!=null?new Date(vacation.getFromDate().getTime()):null);
						vacPreparedStatement.setDate(4, vacation.getToDate()!=null?new Date(vacation.getToDate().getTime()):null);
						vacPreparedStatement.executeUpdate();
					}
					
					vacSEQCallableStatement.close();
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.commit();
				if(vacPreparedStatement!=null)
					vacPreparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Update employee demographics
	 * @param employee
	 */
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	/**
	 * delete employee
	 * @param empId
	 */
	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub

	}

}

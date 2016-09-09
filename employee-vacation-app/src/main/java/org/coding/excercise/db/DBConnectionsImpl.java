package org.coding.excercise.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

public class DBConnectionsImpl implements DBConnections {

	public String DB_DRIVER = null;
	public String DB_CONNECTION = null;
	public String DB_USER = null;
	public String DB_PASSWORD = null;

	public DBConnectionsImpl(String dB_DRIVER, String dB_CONNECTION, String dB_USER, String dB_PASSWORD) {
		super();
		DB_DRIVER = dB_DRIVER;
		DB_CONNECTION = dB_CONNECTION;
		DB_USER = dB_USER;
		DB_PASSWORD = dB_PASSWORD;
	}

	public Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	@PostConstruct
	public void initDB() {
		String CreateEMPTABLEStmt = "CREATE TABLE EMPLOYEE"
				+ "("
				+ "EMP_ID int primary key, "
				+ "USERNAME varchar(30),"
				+ "FIRSTNAME varchar(30),"
				+ "LASTNAME varchar(30))";
		
		String CreateVACATIONTABLEStmt = "CREATE TABLE VACATION"
				+ "("
				+ "VACATION_ID int primary key, "
				+ "EMP_ID int, "
				+ "FROM_DATE DATE,"
				+ "END_DATE DATE, "
				+ "FOREIGN KEY (EMP_ID) "
				+ "REFERENCES public.EMPLOYEE(EMP_ID))";
		
		String createEMPSeq = "CREATE SEQUENCE "
				+ "IF NOT EXISTS "
				+ "SEQ_EMP_ID "
				+ "START WITH 1 "
				+ "INCREMENT BY 10 "
				+ "NOCYCLE NOCACHE";
		
		String createVACSeq = "CREATE SEQUENCE "
				+ "IF NOT EXISTS "
				+ "SEQ_VACATION_ID "
				+ "START WITH 1 "
				+ "INCREMENT BY 10 "
				+ "NOCYCLE NOCACHE";
		
		String selectEMPSeq = "call NEXT VALUE FOR SEQ_EMP_ID";
		String selectVACATIONSeq = "call NEXT VALUE FOR SEQ_VACATION_ID";
		
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;
		CallableStatement callableStatement = null;
		try {
			createPreparedStatement = connection.prepareStatement(CreateEMPTABLEStmt);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			createPreparedStatement = connection.prepareStatement(CreateVACATIONTABLEStmt);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			createPreparedStatement = connection.prepareStatement(createEMPSeq);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			createPreparedStatement = connection.prepareStatement(createVACSeq);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			callableStatement = connection.prepareCall(selectEMPSeq);
			ResultSet employeeResultSet = callableStatement.executeQuery(); // TEST EMPLOYEE SEQUENCE
			while (employeeResultSet.next()) {
				System.out.println("*********");
				System.out.println(employeeResultSet.getRow());
				System.out.println("*********");
			}
			employeeResultSet.close();
			
			callableStatement = connection.prepareCall(selectVACATIONSeq); // TEST VACATION SEQUENCE
			ResultSet vacationResultSet = callableStatement.executeQuery();
			while (vacationResultSet.next()) {
				System.out.println("*********");
				System.out.println(vacationResultSet.getRow());
				System.out.println("*********");
			}
			vacationResultSet.close();
			callableStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

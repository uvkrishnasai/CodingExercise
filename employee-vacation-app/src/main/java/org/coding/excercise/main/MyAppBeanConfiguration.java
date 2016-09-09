package org.coding.excercise.main;

import org.coding.excercise.dao.EmployeeDAO;
import org.coding.excercise.dao.EmployeeDAOImpl;
import org.coding.excercise.db.DBConnections;
import org.coding.excercise.db.DBConnectionsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:jdbc.properties")
public class MyAppBeanConfiguration {
	
	@Value("${DB_DRIVER}")
    String dbDriver;
	
	@Value("${DB_CONNECTION}")
    String dbConnection;
	
	@Value("${DB_USER}")
    String dbUser;
	
	@Value("${DB_PASSWORD}")
    String dbPassword;
	
	@Bean
	public DBConnections dbConnections() {
		DBConnections dbConn = new DBConnectionsImpl(dbDriver, dbConnection, dbUser, dbPassword);
		return dbConn;
	}
	
	@Bean
	public EmployeeDAO employeeDAO() {
		return new EmployeeDAOImpl();
	}
	
	//Declare Other Beans

}

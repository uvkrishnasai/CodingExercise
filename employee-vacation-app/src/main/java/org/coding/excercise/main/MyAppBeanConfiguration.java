package org.coding.excercise.main;

import org.coding.excercise.dao.EmployeeDAO;
import org.coding.excercise.dao.EmployeeDAOImpl;
import org.coding.excercise.db.DBConnections;
import org.coding.excercise.db.DBConnectionsImpl;
import org.coding.excercise.service.EmployeeVacationService;
import org.coding.excercise.service.EmployeeVacationServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "org.coding.excercise.controller")
@PropertySource(value="classpath:jdbc.properties")
//@EnableWebMvc
public class MyAppBeanConfiguration// extends WebMvcConfigurerAdapter
{
	
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
	
	@Bean
	public EmployeeVacationService employeeVacationService() {
		return new EmployeeVacationServiceImpl();
	}
	
	/*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }*/
	
	//Declare Other Beans

}

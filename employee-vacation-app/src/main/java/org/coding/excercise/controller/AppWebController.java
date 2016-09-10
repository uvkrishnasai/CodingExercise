package org.coding.excercise.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.coding.excercise.entitybeans.Employee;
import org.coding.excercise.entitybeans.Vacation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Venkata.Uppalapati
 *
 */
@Controller
@RequestMapping("/web")
public class AppWebController {
	
	/**
	 * MVC - web display main page
	 * @return
	 */
	@RequestMapping("/")
	public String displayMain(){
		return "main";
	}
	
	/**
	 * mvc web controller . create employee
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/createEmployee", method = RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute("employee") Employee emp){
		ModelMap model = new ModelMap();
		Integer empId = 0;
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder url = new StringBuilder("http://localhost:8080/emp-vac-app/employee/createEmployee?");
		url.append("firstName="+emp.getFirstName());
		url.append("&lastName="+emp.getLastName());
		url.append("&userName="+emp.getUserName());
		ResponseEntity<Integer> empIdentity = restTemplate.getForEntity(url.toString(), Integer.class);
		empId = empIdentity.getBody();
		System.out.println(empId);
		model.addAttribute("empId", empId);
		return new ModelAndView("main",model);
	}
	
	/**
	 * mvc web controller . getEmployeeByEmpId
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/getEmployee", method = RequestMethod.POST)
	public ModelAndView getEmployeeByEmpId(@ModelAttribute("employee") Employee employee){
		ModelMap model = new ModelMap();
		if (employee==null || employee.getEmpId() == null) {
			return new ModelAndView("main",model);
		}
		List<Employee> employees = new ArrayList<Employee>();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/emp-vac-app/employee/getEmployee?empId="+employee.getEmpId();
		ResponseEntity<Employee> emp = restTemplate.getForEntity(url, Employee.class);
		employees.add(emp.getBody());
		System.out.println(emp.getBody().getVacationInfoList());
		if (emp.getBody().getVacationInfoList() != null) {
			for (Vacation vac : emp.getBody().getVacationInfoList()) {
				System.out.println(vac.getFromDate() + " : " + vac.getToDate());
			}
		}
		model.addAttribute("employees", employees);
		return new ModelAndView("main",model);
	}
	
	/**
	 * mvc web controller . getAllEmployees
	 * @param empId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getAllEmployees", method = RequestMethod.POST)
	public ModelAndView getAllEmployees(){
		ModelMap model = new ModelMap();
		List<Employee> employees = new ArrayList<Employee>();
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.add("Accept-Charset", "UTF-8");
        HttpEntity request = new HttpEntity(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/emp-vac-app/employee/getAllEmployees";
		ResponseEntity<ArrayList> empList = restTemplate.postForEntity(url,request, ArrayList.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(empList.getBody() != null && empList.getBody().size() > 0){
			for (Object emp: empList.getBody()) {
				if(emp == null){
					break;
				}
				LinkedHashMap<String, Object> empMap = (LinkedHashMap<String, Object>)emp;
				Employee empl = new Employee();
				empl.setEmpId((Integer)empMap.get("empId"));
				empl.setFirstName((String)empMap.get("firstName"));
				empl.setLastName((String)empMap.get("lastName"));
				empl.setUserName((String)empMap.get("userName"));
				empl.setVacationInfoList(new ArrayList<Vacation>());
				List<LinkedHashMap<String, Object>> vacMapList = (List<LinkedHashMap<String, Object>>)empMap.get("vacationInfoList");
				if (vacMapList != null && !vacMapList.isEmpty()) {
					for (LinkedHashMap<String, Object> vac : vacMapList) {
						LinkedHashMap<String, Object> vacMap = (LinkedHashMap<String, Object>)vac;
						Vacation vacation = new Vacation();
						vacation.setVacationId((Integer)vacMap.get("vacationId"));
						try {
							vacation.setFromDate(sdf.parse((String)vacMap.get("fromDate")));
							vacation.setToDate(sdf.parse((String)vacMap.get("toDate")));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						empl.getVacationInfoList().add(vacation);
					}
				}
				employees.add(empl);
			}
		}
		model.addAttribute("employees", employees);
		return new ModelAndView("main",model);
	}
	
	@ModelAttribute("employee")
	 public Employee getEmployee() {
	  return new Employee();
	 }
	
}

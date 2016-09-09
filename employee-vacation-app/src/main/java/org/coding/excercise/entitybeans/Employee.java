package org.coding.excercise.entitybeans;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empId;
	private String userName;
	private String firstName;
	private String lastName;
	private List<Vacation> vacationInfoList;
	

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Vacation> getVacationInfoList() {
		return vacationInfoList;
	}

	public void setVacationInfoList(List<Vacation> vacationInfoList) {
		this.vacationInfoList = vacationInfoList;
	}
	
}

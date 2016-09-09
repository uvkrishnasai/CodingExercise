package org.coding.excercise.entitybeans;

import java.util.Date;

public class Vacation {

	private Integer vacationId;
	private Employee employee;
	private Date fromDate;
	private Date toDate;
	public Integer getVacationId() {
		return vacationId;
	}
	public void setVacationId(Integer vacationId) {
		this.vacationId = vacationId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employeeId) {
		this.employee = employeeId;
	}
	
}

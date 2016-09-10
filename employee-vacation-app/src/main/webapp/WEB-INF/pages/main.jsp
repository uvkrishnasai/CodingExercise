<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BCBS Coding Excercise</title>
</head>
<style>
	body {
		background: #555 url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAB9JREFUeNpi/P//PwM6YGLAAuCCmpqacC2MRGsHCDAA+fIHfeQbO8kAAAAASUVORK5CYII=);
	    font: 13px 'Lucida sans', Arial, Helvetica;
		color: #eee;
	    text-align: center;
	   }
	   
	.form-wrapper {
        width: 700px;
        padding: 15px;
        height:40px;
        margin: 15px auto 50px auto;
        background: #444;
        background: rgba(0,0,0,.2);
        -moz-border-radius: 10px;
        -webkit-border-radius: 10px;
        border-radius: 10px;
        -moz-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
        -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
        box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
    }
    
    .form-label {
        width: 150px;
        height: 15px;
        padding: 10px 5px;
        float: left;    
        font: bold 15px 'lucida sans', 'trebuchet MS', 'Tahoma';
        border: 0;
        -moz-border-radius: 3px 0 0 3px;
        -webkit-border-radius: 3px 0 0 3px;
        border-radius: 3px 0 0 3px;      
    }
    
    .form-wrapper-input {
        width: 330px;
        height: 15px;
        padding: 10px 5px;
        font: bold 15px 'lucida sans', 'trebuchet MS', 'Tahoma';
        border: 0;
        background: #eee;
        -moz-border-radius: 3px 0 0 3px;
        -webkit-border-radius: 3px 0 0 3px;
        border-radius: 3px 0 0 3px;      
    }
    
    .form-wrapper-input:focus {
        outline: 0;
        background: #fff;
        -moz-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
        -webkit-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
        box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
    }
    
    .form-wrapper-input::-webkit-input-placeholder {
       color: #999;
       font-weight: normal;
       font-style: italic;
    }
    
    .form-wrapper-input:-moz-placeholder {
        color: #999;
        font-weight: normal;
        font-style: italic;
    }
    
    .form-wrapper-input:-ms-input-placeholder {
        color: #999;
        font-weight: normal;
        font-style: italic;
    }    
    
    .form-wrapper-button {
		overflow: visible;
        position: relative;
        float: right;
        border: 0;
        padding: 0;
        cursor: pointer;
        height: 35px;
        width: 200px;
        font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';
        color: #fff;
        text-transform: uppercase;
        background: #d83c3c;
        -moz-border-radius: 0 3px 3px 0;
        -webkit-border-radius: 0 3px 3px 0;
        border-radius: 0 3px 3px 0;      
        text-shadow: 0 -1px 0 rgba(0, 0 ,0, .3);
    }   
      
    .form-wrapper-button:hover{		
        background: #e54040;
    }	
      
    .form-wrapper-button:active,
    .form-wrapper button:focus{   
        background: #c42f2f;    
    }
    
    .form-wrapper-button:before {
        content: '';
        position: absolute;
        border-width: 8px 8px 8px 0;
        border-style: solid solid solid none;
        border-color: transparent #d83c3c transparent;
        top: 12px;
        left: -6px;
    }
    
    .form-wrapper-button:hover:before{
        border-right-color: #e54040;
    }
    
    .form-wrapper-button:focus:before{
        border-right-color: #c42f2f;
    }    
    
    .form-wrapper-button::-moz-focus-inner {
        border: 0;
        padding: 0;
    }
	
	.byline p{
	  text-align:center;
	  color:#c6c6c6;
	  font: bold 18px Arial, Helvetica, Sans-serif;
	  text-shadow: 0 2px 3px rgba(0,0,0,0.1);
	}
	
	.rwd-table {
		background: #444;
        background: rgba(0,0,0,.2);
	    color: #fff;
	    border-radius: .4em;
	    overflow: hidden;
	}
	
	.rwd-table {
		margin: 15px auto 50px auto;
	   text-align: center;
	   padding: 15px;
	   font:  15px 'lucida sans', 'trebuchet MS', 'Tahoma';
	    min-width: 300px;
	}
	
	.rwd-table td:before {
	    color: #dd5;
	}
	
	.rwd-table th {
		font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';
	 	color: #dd5;
		font-weight: bold;
	}
	
	tr {
	    display: table-row;
	    vertical-align: inherit;
	    border-color: inherit;
	}
	
	table {
	 	border: 1px solid white;
	    display: table;
	    border-collapse: separate;
	    border-spacing: 2px;
	    border-color: grey;
	}
	
	td, th {
		border: 1px solid white;
	    display: table-cell;
	    vertical-align: inherit;
	}
	
</style>
<body>
	<!-- Modify the page to create Employee and add vacation -->
	<h1>
		BCBS Coding Exercise
	</h1>
	
	<h3>
	 CREATE EMPLOYEE
	</h3>
	<div id="createEmployee">
		<form:form modelAttribute="employee" action="createEmployee" methon="POST" class="form-wrapper" style="height:50px">
		      <label class="form-label" style="padding:0px">First Name:
		      <form:input path="firstName" type="text" title="First Name" class="form-wrapper-input" style="width:100px" />
		       </label>
		      <label class="form-label" style="padding:0px">Last Name: 
		      <form:input path="lastName" type="text" title="Last Name" class="form-wrapper-input"  style="width:100px" />
		      </label>
		      <label class="form-label" style="padding:0px">User Name: 
		      <form:input path="userName" type="text" title="User Name" class="form-wrapper-input" style="width:100px" />
		      </label>
		       <input type="submit" value="CREATE EMPLOYEE" class="form-wrapper-button" style="float:none;"/>
		</form:form>
	</div>
	
	<h3>
		Employee Search BOX
	</h3>
	<div id="searchEmployee">
		<form:form modelAttribute="employee" action="getEmployee" method="POST" class="form-wrapper">
			  <label title="Employee ID" class="form-label">EMPLOYEE ID:</label>
		      <form:input path="empId" type="text" title="Employee ID" class="form-wrapper-input" alt="Employee ID"/>
		      <input type="submit" value="GET Employee" class="form-wrapper-button" />
		</form:form>
	</div>
	
	<div id="searchAllEmployee">
		<form:form modelAttribute="employee" action="getAllEmployees" method="POST">
		       <input type="submit" value="GET ALL Employees" class="form-wrapper-button" style="float:none;"/>
		</form:form>
	</div>
	
	<div id="employeeSearchResults">
		<c:if test="${ not empty employees}">
			<table class="rwd-table">
				<thead>
					<td>EMP ID</td>
					<td>FIRST NAME</td>
					<td>LAST NAME</td>
					<td>USER NAME</td>
					<td>VACATION</td>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="employee">
					<tr>
						<td>
							<c:out value="${employee.getEmpId()}" />
						</td>
						<td>
							<c:out value="${employee.getFirstName()}" />
						</td>
						<td>
							<c:out value="${employee.getLastName()}" />
						</td>
						<td>
							<c:out value="${employee.getUserName()}" />
						</td>
						<td>
							<c:forEach items="${employee.getVacationInfoList()}" var="vacation">
								<ul>
									<li><label>VACATION ID: </label> <c:out value="${vacation.getVacationId()}" /></li>
									<li><label>VACATION FROM DATE: </label> <c:out value="${vacation.getFromDate()}" /></li>
									<li><label>VACATION TO DATE: </label> <c:out value="${vacation.getToDate()}" /></li>
								</ul>
							</c:forEach>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>
package com.chinasofti.vo.employee;

public class Employee_Role {

	private String employee_name;
	private String employee_loginname;
	private String role_name;
	private String role_state;
	private Integer role_id;
	private Integer employee_id;
	

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_loginname() {
		return employee_loginname;
	}

	public void setEmployee_loginname(String employee_loginname) {
		this.employee_loginname = employee_loginname;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_state() {
		return role_state;
	}

	public void setRole_state(String role_state) {
		this.role_state = role_state;
	}
	
	

}

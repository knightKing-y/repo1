package com.chinasofti.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasofti.vo.employee.Employee;


public interface EmployeeDaoInf {
	/**
	 * 查询所有员工
	 * @return 员工列表页
	 */
	    public   List<Employee>  selectEmployee();
	     /**
	 	 * 添加员工
	 	 * @return 员工列表页面
	 	 */
	 	public void  addEmployee(Employee  employee) ;
	 	
	 	public List<Employee> mhselect(Employee  employee);
	 	
	 	public Employee selectEmployeeBYID(int a);
	 	
	 	public void UpdateEmployeeBYID(Employee e);
	 	
	 	public void updatestatus(Employee employee);
	 	
        public void qiyong(int a);
}

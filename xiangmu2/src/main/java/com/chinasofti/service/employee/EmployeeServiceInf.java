package com.chinasofti.service.employee;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.startclass.StartClass;
public interface EmployeeServiceInf {
	/**
	 *  查询所有员工
	 *@return  员工列表页
	 */
	public List<Employee> selectEmployee();

	/**
	 * 添加员工
	 * @return 员工列表页面
	 */
	
	public   List<Employee>  addEmployee(Employee  employee) ;
	
	public  List<Employee> mhselect(Employee  employee);
	
	public Employee selectEmployeeBYID(int a);
	
	public List<Employee> UpdateEmployeeBYID(Employee e);
	
	public List<Employee> updatestatus(Employee employee);

	public List<Employee> qiyong(int a);
	
	
}

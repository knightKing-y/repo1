package com.chinasofti.service.employee;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chinasofti.dao.employee.EmployeeDaoInf;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.startclass.StartClass;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInf {

	@Autowired
	private EmployeeDaoInf   employeeDaoInf;


	/**
	 * 查询所有员工
	 * 
	 * @return 员工列表页
	 */

	public   List<Employee>    selectEmployee() {
		
		return employeeDaoInf.selectEmployee();
	}

	/**
	 * 添加员工
	 * @return 员工列表页面
	 */
	public  List<Employee>   addEmployee(Employee  employee) {
	   //添加员工
		employee.setEmployee_create_time(new Date());
	    employeeDaoInf.addEmployee(employee);
		//查询出所有员工
		return  employeeDaoInf.mhselect(employee);
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Employee> mhselect(Employee employee) {
		return employeeDaoInf.mhselect(employee);
		
	}

	@Override
	public Employee selectEmployeeBYID(int a) {
		return  employeeDaoInf.selectEmployeeBYID(a);
	}

	@Override
	public List<Employee> UpdateEmployeeBYID(Employee e) {
		employeeDaoInf.UpdateEmployeeBYID(e);
		return employeeDaoInf.selectEmployee();
	}

	@Override
	public List<Employee> updatestatus(Employee employee) {
		employeeDaoInf.updatestatus(employee);
		return employeeDaoInf.selectEmployee();
	}

	@Override
	public List<Employee> qiyong(int a) {
		employeeDaoInf.qiyong(a);
		return employeeDaoInf.selectEmployee();
	}

	

	
}

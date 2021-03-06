package com.chinasofti.service.quyu;

import java.util.List;

import com.chinasofti.vo.quyu.Department;


public interface DepartmentServiceInf {
	/**
	 *  添加部门
	 * @param quyu部门对象
	 */
	public void addDepartment(Department  department);
	
	/**
	 *  查询所有部门
	 *@return  部门列表页
	 */
	public List<Department> selectDepartment();

	/**
	 * 根据部门id,查询部门信息
	 * @return  部门列表页
	 */
	
	public  Department  selectDepartmentByid(int department_id);
	/**
	 *根据部门id,修改部门信息
	 *  @param department部门对象
	 */
	public void updateDepartment(Department  department);
	
}

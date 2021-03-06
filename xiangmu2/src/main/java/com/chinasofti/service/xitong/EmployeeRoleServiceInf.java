package com.chinasofti.service.xitong;

import java.util.List;

import org.springframework.ui.Model;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.employee.Employee_Role;
import com.chinasofti.vo.xitong.Authority;
import com.chinasofti.vo.xitong.EmployeeRole;
import com.chinasofti.vo.xitong.Role;

public interface EmployeeRoleServiceInf {
	/**
	 *  查询所有员工角色     
	 *@return  员工角色列表页
	 */
	public List<Employee_Role> selectEmployeeRole();
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role>  selectRole(int state) ;
	
	/**
	 * 根据ID查询出用户的信息
	 * @param employee_id
	 * @return
	 */
   public Employee getEmployeeById (String employee_id);
   
   /**
    * 向员工角色表中添加数据
    * @param employee
    * @param role
    */
  public void addEmployeeRole (Employee employee,Role role);

  
  //=====员工权限角色管理    左边是菜单，右边是按钮 ======
	
	
	/**
	 * 根据员工id查询一级分类
	 * @param employee_id
	 * @return
	 */
	public List<Authority> selectTwo(int employee_id);
	
	
	/**
	 * 根据员工id查询出二级分类
	 * @param employee_id
	 * @return
	 */
	public List<Authority> selectOne(int employee_id);
	
	/**
	 * 根据员工id查询出三级分类
	 * @param employee_id
	 * @return
	 */
	public List<Authority> selectThree(int employee_id);
	
	
	public Employee getEmployee(String employee_id);
	
}

package com.chinasofti.dao.user;

import java.util.List;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.user.Users;

public interface UserDaoInf {
	/**
	 * 用户注册功能
	 * 
	 * @param users
	 *            用户信息实体类
	 */
	public void zhuce(Users users);
	
	/**
	 * 验证用户名是否重复
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 用户信息实体类
	 */
	public Users selectUserName(Users users);
	/**
	 * 登录验证
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 用户信息实体类
	 */
	public Employee isLoginNamePwd(Employee employee);

}

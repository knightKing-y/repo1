package com.chinasofti.service.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.user.Users;

/**
 * @Description:  用户登录及注册模块业务处理接口
 * @Date: 2017.11.24
 * @author lv
 * @version 1.0
 */

public interface UserServiceInf {
	/**
	 * 用户注册功能
	 * 
	 * @param users
	 *            用户信息实体类
	 */
	public void zhuce(Users users);

	/**
	 * 此方法用于测试事务
	 * 
	 * @param users
	 */
	public void addUser(Users users);

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
	public Employee   isLoginNamePwd(Employee  em);
	
	/**
	 * 查一级二级栏目及按钮
	 * @param session
	 */
	public   void  selectAuth(HttpSession session);
}

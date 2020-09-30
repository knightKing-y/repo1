package com.chinasofti.dao.quanxian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.xitong.Authority;
import com.chinasofti.vo.xitong.Tree;


public interface  QuanXianDaoInf {
	
	
	/**
	 * 一级菜单栏
	 * @param employeeid  员工id
	 * @return  员工权限
	 */
	public List<Authority> selectOneAuth(int employeeid);
	
	
	/**
	 * 二级菜单栏
	 * @param employeeid  员工id
	 * @param parid   员工权限父亲id
	 * @return   员工权限
	 */
	public List<Authority> selectTwoAuth(int employeeid,int parid);
	
	/**
	 * 按钮
	 * @param employeeid  员工id
	 * @param parid   员工权限父亲id
	 * @return   员工权限
	 */
	public List<Authority> selectThreeAuth(int employeeid,int parid);
	
}

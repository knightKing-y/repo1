package com.chinasofti.service.employee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.xitong.Role;

public interface DaoRuServiceInf {

	public int daoru(MultipartFile file, HttpSession session,Employee  employ,Role role) throws Exception;
	/**
	 * 根据部门查询出职称
	 * @param Position职称信息
	 */
	public  List<Position>    selectDepatByposition(Department  deptid);
	

}

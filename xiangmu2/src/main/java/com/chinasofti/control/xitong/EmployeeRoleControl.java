package com.chinasofti.control.xitong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.service.xitong.EmployeeRoleServiceInf;
import com.chinasofti.util.MessageUtil;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.employee.Employee_Role;
import com.chinasofti.vo.xitong.Authority;
import com.chinasofti.vo.xitong.EmployeeRole;
import com.chinasofti.vo.xitong.Role;

/**
 * @Description: 角色权限管理
 * @Date: 2018.1.27
 * @author lv
 * @version 1.0
 */
@Controller
@RequestMapping("employeeRoleControl")
public class EmployeeRoleControl {

	@Autowired
	private EmployeeRoleServiceInf employeeroleServiceInf;

	/**
	 * 跳转到员工权限管理列表页
	 * 
	 * @return 员工权限管理列表页
	 */
	@RequestMapping("gotoEmployeeRoleList")
	public String gotoEmployeeRoleList() {
		// 先去查，在往页面上带值
		return "forward:/employeeRoleControl/selectEmployeeRole.action";
	}

	/**
	 * 查询所有员工权限
	 * 
	 * @return 员工权限管理列表页
	 */
	@RequestMapping("selectEmployeeRole")
	public String selectEmployeeRole(Model model) {

		String str = "/WEB-INF/xitong/employeeroleList.jsp";
		try {
			// 所有员工权限带到页面上
			List<Employee_Role> employeeroleList = employeeroleServiceInf.selectEmployeeRole();
			model.addAttribute("employeeroleList", employeeroleList);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 员工权限更新页面
	 * 
	 * @return 员工权限更新页面
	 */
	@RequestMapping("gotoUpdateEmployeeRole")
	public String gotoUpdateEmployeeRole(Model model, String employee_id) {

		String str = "/WEB-INF/xitong/updateemployeerole.jsp";
		try {
			// 有效的角色List
			List<Role> roleList = employeeroleServiceInf.selectRole(MessageUtil.ROLE_STATE_YOUXIAO);
			model.addAttribute("roleList", roleList);

			// 根据ID查询出用户的信息
			Employee employee = employeeroleServiceInf.getEmployeeById(employee_id);
			if(employee==null){
				employee=employeeroleServiceInf.getEmployee(employee_id);
			}
			model.addAttribute("employee", employee);

		} catch (Exception e) {
			str = "/error.jsp";

		}
		return str;

	}

	/**
	 * 向员工角色表中添加数据
	 * 
	 * @return 员工角色表添加数据
	 */
	@RequestMapping("addEmployeeRole")
	public String addEmployeeRole(Model model, Employee employee, Role role) {

		String str = "/WEB-INF/xitong/employeeroleList.jsp";
		try {
			// 向员工角色表中添加数据
			employeeroleServiceInf.addEmployeeRole(employee, role);

			// 所有员工角色带到页面上
			List<Employee_Role> employeeroleList = employeeroleServiceInf.selectEmployeeRole();
			model.addAttribute("employeeroleList", employeeroleList);

		} catch (Exception e) {
			str = "/error.jsp";

		}
		return str;

	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	@RequestMapping("selectRole")
	public String selectRole(Model model) {

		String str = "/WEB-INF/xitong/employeeroleList.jsp";
		try {
			// 所有员工权限带到页面上
			List<Role> roleList = employeeroleServiceInf.selectRole(MessageUtil.ROLE_STATE_YOUXIAO);
			model.addAttribute("roleList", roleList);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;

	}

}

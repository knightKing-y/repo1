package com.chinasofti.control.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chinasofti.service.employee.EmployeeServiceInf;
import com.chinasofti.service.quyu.DepartmentServiceInf;
import com.chinasofti.service.quyu.PositionServiceInf;
import com.chinasofti.service.quyu.QuyuServiceInf;
import com.chinasofti.service.xitong.RoleServiceInf;
import com.chinasofti.util.Fenye;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.kecheng.Tech;
import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.quyu.Quyu;
import com.chinasofti.vo.xitong.Role;
import com.chinasofti.service.kecheng.TechServiceInf;

/**
 * @Description: 用户管理
 * @Date: 2018.1.31
 * @author lv
 * @version 1.0
 */
@Controller
@RequestMapping("employeeControl")
public class EmployeeControl {

	@Autowired
	private EmployeeServiceInf employeeServiceInf; // 员工

	@Autowired
	private QuyuServiceInf quyuServiceInf; // 区域

	@Autowired
	private PositionServiceInf positionServiceInf; // 职称

	@Autowired
	private DepartmentServiceInf departmentServiceInf; // 部门

	@Autowired
	private TechServiceInf TechServiceInf;// 技术方向
	
	@Autowired
	private RoleServiceInf roleServiceInf;//角色

	/**
	 * 跳转到用户管理列表页
	 * 
	 * @return 用户管理列表页
	 */
	@RequestMapping("gotoEmployeeList")
	public String gotoEmployeeList() {
		// 先去查，在往页面上带值
		return "forward:/employeeControl/selectEmployee.action";
	}

	/**
	 * 查询所有用户
	 * 
	 * @return 用户列表页
	 */
	@RequestMapping("selectEmployee")
	public String selectEmployee(Employee employee,Model model,String auid) {
		System.out.println("auid="+auid);
		String str = "/WEB-INF/employee/employeeList.jsp";
		try {
			
			// 所有员工
			List<Employee> employeelist = employeeServiceInf.selectEmployee();
			model.addAttribute("employeelist", employeelist);
			model.addAttribute("auid", auid);
			
		} catch (Exception e) {
			e.printStackTrace();
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 跳转到添加员工页面
	 * 
	 * @return 员工页面
	 */
	@RequestMapping("gotoAddEmployee")
	public String gotoAddEmployee(Model model) {
		String str = "/WEB-INF/employee/addemployee.jsp";
		try {
			// 先去查，在往页面上带值
			// 所有区域
			List<Quyu> quyu = quyuServiceInf.selectQuyu();
			model.addAttribute("quyu", quyu);
			// 所有部门
			List<Department> department = departmentServiceInf.selectDepartment();
			model.addAttribute("department", department);
			// 所有职称
			List<Position> position = positionServiceInf.selectPosition();
			model.addAttribute("position", position);
			// 所有技术方向
			List<Tech> tech = TechServiceInf.selectTech();
			model.addAttribute("tech", tech);
		} catch (Exception e) {
			e.printStackTrace();
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 添加员工
	 * 
	 * @return 员工列表页面
	 */
	@RequestMapping("addEmployee")
	public String addEmployee(Model model,Employee  employee,Integer page) {
		String str = "/WEB-INF/employee/employeeList.jsp";
		try {
			
			
			  List<Employee>  employeelist = employeeServiceInf.addEmployee(employee);
		      model.addAttribute("employeelist", employeelist);
		      
		} catch (Exception e) {
			e.printStackTrace();
			str = "/error.jsp";
		}
		return str;
		}
	
	/**
	 * 跳转到批量导入员工页面
	 * 
	 * @return 员工页面
	 */
	@RequestMapping("gotoDaoruEmployee")
	public String gotoDaoruEmployee(Model model) {
		String str = "/WEB-INF/employee/daoruemployee.jsp";
		try {
			// 先去查，在往页面上带值
			// 所有区域
			List<Quyu> quyu = quyuServiceInf.selectQuyu();
			model.addAttribute("quyu", quyu);
			// 所有部门
			List<Department> department = departmentServiceInf.selectDepartment();
			model.addAttribute("department", department);
			// 所有职称
			List<Position> position = positionServiceInf.selectPosition();
			model.addAttribute("position", position);
			// 所有技术方向
			List<Tech> tech = TechServiceInf.selectTech();
			model.addAttribute("tech", tech);
			
			//所属角色
			List<Role>  role  = roleServiceInf.selectRole();
			model.addAttribute("role", role);
		} catch (Exception e) {
			e.printStackTrace();
			str = "/error.jsp";
		}
		return str;

	}
	
	/**
	 * 模糊查询
	 * @param employee
	 * @param model
	 * @return 
	 */
	@RequestMapping("mhselect")
	public String mhselect(Employee employee,Model model){
		// 当前页
					
		            List<Employee>  employeelist=employeeServiceInf.mhselect(employee);
		            model.addAttribute("employeelist", employeelist);
		            model.addAttribute("e",employee);
	            	return "/WEB-INF/employee/employeeList.jsp";
	}
	
	@RequestMapping("updateByemployeeidjsp")
	public String updateByemployeeid(int employee_id,Model model){
		Employee e=employeeServiceInf.selectEmployeeBYID(employee_id);
		List<Quyu> quyu = quyuServiceInf.selectQuyu();
		model.addAttribute("quyu", quyu);
		List<Department> department = departmentServiceInf.selectDepartment();
		model.addAttribute("department", department);
		// 所有职称
		List<Position> position = positionServiceInf.selectPosition();
		model.addAttribute("position", position);
		// 所有技术方向
		List<Tech> tech = TechServiceInf.selectTech();
		model.addAttribute("tech", tech);
		model.addAttribute("e",e);
		return "/WEB-INF/employee/updateemployee.jsp";
	}
	
	@RequestMapping("updateEmployee")
	public String updateEmployee(Employee employee,Integer page,Model model){
		
		List<Employee>  employeelist=employeeServiceInf.UpdateEmployeeBYID(employee);
		model.addAttribute("employeelist", employeelist);
       
		return "/WEB-INF/employee/employeeList.jsp";
	}
	
	@RequestMapping("updatestatus")
	public String updatestatus(Employee employee,Model model){
        
		
		List<Employee>  employeelist=employeeServiceInf.updatestatus(employee);
		model.addAttribute("employeelist", employeelist);
       
		return "/WEB-INF/employee/employeeList.jsp";
		
	}
	
	@RequestMapping("qiyong")
	public String qiyong(Employee employee,Model model,int employee_id){
       
		List<Employee>  employeelist=employeeServiceInf.qiyong(employee_id);
		model.addAttribute("employeelist", employeelist);
       
		return "/WEB-INF/employee/employeeList.jsp";
	}
}

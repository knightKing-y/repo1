package com.chinasofti.control.user;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.service.user.UserServiceInf;
import com.chinasofti.service.xitong.EmployeeRoleServiceInf;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.user.Users;
import com.chinasofti.vo.xitong.Authority;

/**
 * @Description: 用户等录及注册模
 * @Date: 2017.11.24
 * @author lv
 * @version 1.0
 */
@Controller
@RequestMapping("userControl")
public class UserControl {

	@Autowired
	UserServiceInf userServiceInf;
	@Autowired
	EmployeeRoleServiceInf  employeeroleServiceInf;

	/**
	 * 用户注册功能
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 注册跳转页面
	 */
	@RequestMapping("zhuce")
	public String zhuce(Users users) {

		// 密码加密--加密方式md5
		// users.setPwd(Md5Util.md5(users.getPwd()));

		userServiceInf.zhuce(users);
		return "/login.jsp";
	}

	/**
	 * 此方法用于测试事务
	 * 
	 * @param users
	 */
	@RequestMapping("addUser")
	public void addUser(Users users) {
		userServiceInf.addUser(users);
	}

	/**
	 * 验证用户名是否重复
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return JSON串，用于前台，给用户提示用户名是否重复
	 */
	@RequestMapping("validateUser")
	@ResponseBody
	public String validateUser(Users users) {

		// 去数据库中验证
		Users user = userServiceInf.selectUserName(users);

		// 形成JSON串
		String html = null;
		if (user == null ) {
			html = "{\"success\":1,\"msg\":\"you can use it！\"}";

		} else {
			html = "{\"success\":0,\"msg\":\"you not can use it！choose another!\"}";
		}
		System.out.println(html);
		return html;
	}

	/**
	 * 登录验证
	 * 
	 * @param users
	 *            用户信息实体类，这个类要实现Serializable接口
	 * @return 返回一个JSON串 因为后台用了JackJson技术 ,并且这里用到了@ResponseBody标签
	 */
	@RequestMapping("isLoginNamePwd")
	@ResponseBody
	public Employee isLoginNamePwd(Employee employee, HttpSession session) {

		Employee em = userServiceInf.isLoginNamePwd(employee);
		if (em != null) {

			session.setAttribute("user", em);

			// ==========用户的角色和权限（左边菜单右边按钮）==================
			
			//根据员工id查询出一级分类,二级分类,三级分类
			List<Authority> oneList = employeeroleServiceInf.selectOne(em.getEmployee_id());
			List<Authority> twoList = employeeroleServiceInf.selectTwo(em.getEmployee_id());
			//List<Authority> threeList = employeeroleServiceInf.selectThree(em.getEmployee_id());
			
			ServletContext  sc = session.getServletContext();
			sc.setAttribute("oneFenlei",oneList);
			sc.setAttribute("twoFenlei",twoList);
			//sc.setAttribute("threeFenlei",threeList);
			
		}
		return em;
	}

	/**
	 * 跳转到index.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("gotoIndex")
	public String gotoIndex(Model model, HttpSession session) {

		// 根据用户的角色，去数据库中找所对应的权限带到west2.jsp页面上，动态的显示出菜单
		userServiceInf.selectAuth(session);

		return "/WEB-INF/index.jsp";

	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping("userLoginOff")
	public String userLoginOff(HttpSession session) {
		session.invalidate();

		return "/login.jsp";

	}

	/*
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/add2", produces =
	 * "application/json; charset=utf-8") public String add2(String cid,
	 * HttpServletRequest request) { List<TCategory> list =
	 * categoryServiceInf.categorylist2(cid); String json =
	 * JSON.toJSONString(list); System.out.println(json); return json; }
	 * 
	 */

}

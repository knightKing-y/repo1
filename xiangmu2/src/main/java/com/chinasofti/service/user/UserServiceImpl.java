package com.chinasofti.service.user;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.dao.quanxian.QuanXianDaoInf;
import com.chinasofti.dao.user.UserDaoInf;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.user.ClassRoom;
import com.chinasofti.vo.user.Users;
import com.chinasofti.vo.xitong.Authority;

/**
 * @Description: 用户登录及注册模块业务处理类
 * @Date: 2017.11.24
 * @author lv
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserServiceInf {
	@Autowired
	private UserDaoInf userDaoInf;
	
	@Autowired
	private QuanXianDaoInf   quanXianDaoInf;

	/**
	 * 用户注册功能
	 * 
	 * @param users
	 *            用户信息实体类
	 */
	public void zhuce(Users users) {

		userDaoInf.zhuce(users);
	}

	/**
	 * 此方法用于测试事务
	 * 
	 * @param users
	 */
	public void addUser(Users users) {

		System.out.println("sss");

		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				// int j=10/0;
			}
			userDaoInf.zhuce(users);
		}

	}

	/**
	 * 验证用户名是否重复
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 用户信息实体类
	 */
	public Users selectUserName(Users users) {

		Users user = userDaoInf.selectUserName(users);
		return user;
	}

	/**
	 * 登录验证
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 用户信息实体类
	 */
	public Employee   isLoginNamePwd(Employee  em) {
		Employee   employee = userDaoInf.isLoginNamePwd(em);
		return employee;
	}
	
	/**
	 * 查一级二级栏目及按钮
	 * @param session
	 */
	public   void  selectAuth(HttpSession session){
		
		//根据用户的角色，去数据库中找所对应的权限带到west.jsp页面上，动态的显示出菜单
				
		int employeeid=((Employee)session.getAttribute("user")).getEmployee_id();
		
		
		ServletContext  sc = session.getServletContext();
		
		 //一级栏目  employeeid =员工id
	    List<Authority>  oneList=   quanXianDaoInf.selectOneAuth(employeeid);
		sc.setAttribute("oneList", oneList);//一级的
		List<Authority>  twoList = null;
		for(int i=0;i<oneList.size();i++){
			
			Authority  auth = oneList.get(i);
			
			//二级栏目    employeeid =员工id     一级栏目authid
			 twoList=   quanXianDaoInf.selectTwoAuth(employeeid,auth.getAUTHORITY_ID());
		
			}
		sc.setAttribute("twoList", twoList);
		
	}

}

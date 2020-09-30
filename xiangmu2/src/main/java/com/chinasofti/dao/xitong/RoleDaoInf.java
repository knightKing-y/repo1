package com.chinasofti.dao.xitong;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.quyu.Quyu;
import com.chinasofti.vo.xitong.Authority;
import com.chinasofti.vo.xitong.Role;
import com.chinasofti.vo.xitong.Role_Authority;
import com.chinasofti.vo.xitong.Tu;

public interface RoleDaoInf {
	/**
	 *  添加角色  ok
	 * @param position角色对象
	 */
	public void addRole(Role  role);
	
	/**
	 *  查询所有角色 ok
	 * @param b 
	 * @param a 
	 *@return 角色列表页
	 */
	public List<Role> selectRole();
	/**
	 *  按条件查询角色
	 *@return  角色列表页
	 */
	public List<Role> selectRoleByInfo(Role  role);

	/**
	 * 根据角色id,查询角色信息  ok
	 * @return  角色列表页
	 */
	
	public  Role  selectRoleByid(int role_id);
	
	
	//==========================权限树相关方法==============================
	
	/**
	 * 查询出主菜单
	 * 
	 * @return
	 */
	public List<Authority> getZhuAuthority();

	/**
	 * 查询出子菜单
	 * 
	 * @return
	 */
	public List<Authority> getZiAuthority(int parentid);

	/**
	 * 查询出按钮菜单
	 * 
	 * @return
	 */
	public List<Authority> getAnNiuAuthority(int parentid);
	
	/**
	 * 添加角色对应的权限
	 * @param authid  权限ID
	 * @param roleid   角色ID
	 */
	   public  void addRole_Authority(String  authid,int roleid);
	   /**
		 * 根据角色id查询出权限
		 * @param role_id 角色id
		 * @param request   
		 * @return 
		 */
	   public  List<Role_Authority>   getAuthIdByRoleid(int role_id);
	   
	 
	   /**
	    * 删除某个角色对应的权限
	    * @param roleid  角色ID
	    */
		public  void deleteAuthority(int roleid);
		
	
		
		/**
		 * 修改角色
		 * @param role   角色对象
		 */
		   public  void updateRole(Role  role);
		   
		   public List<Tu> getdata();
		   
		   public int count(String employee_name,String employee_loginname);
}

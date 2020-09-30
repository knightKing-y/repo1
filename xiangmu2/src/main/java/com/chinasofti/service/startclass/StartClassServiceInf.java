package com.chinasofti.service.startclass;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.startclass.ClassCourse;
import com.chinasofti.vo.startclass.CourseSys;
import com.chinasofti.vo.startclass.StartClass;
import com.chinasofti.vo.xitong.Role;

public interface StartClassServiceInf {
	
	public List<StartClass> selectBYAREAID(int a,int b);
	
	public void addclassroom(StartClass sc);

	public void updatenum(StartClass sc);
	
	public int count(int r,int a);
	
	public List<ClassCourse> selcetcoerse(int a,int b);
	
	public void addClassCourse(StartClass sc);
	
	public List<CourseSys> SelectClassSys();
	
	public int daoru(@RequestParam("upload") MultipartFile files,HttpSession session,ClassCourse cc,CourseSys cs) throws Exception, Throwable;

    public CourseSys coursesys_csid(int a);
    
    public void deleteCoursesysByid(int a);
    
    public void xuanke(int a,Integer[] s);

    public List<ClassCourse> selcetcoersenull(int a,int b);

	public List<ClassCourse> daochu(int id);

	public com.chinasofti.vo.jiaoshi.JiaoShi selectnum(int classroom_id);

	public Role selectRoleByName(String employee_loginname);

	public List<CourseSys> selectsysByRole(Role r);

	public List<StartClass> showclass(int start, int end,int r,int e);

	public Employee selectBYIDBYName(String employee_loginname);

	public void deleteClassCourseBYSYSiD(int coursesys_csid);


}

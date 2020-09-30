package com.chinasofti.dao.startclass;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.jiaoshi.JiaoShi;
import com.chinasofti.vo.startclass.ClassCourse;
import com.chinasofti.vo.startclass.CourseSys;
import com.chinasofti.vo.startclass.StartClass;
import com.chinasofti.vo.xitong.Role;

public interface StartClassDaoInf {

	public List<StartClass> selectBYAREAID(int a,int b);
	
	public void addclassroom(StartClass sc);
	
	public void updatenum(StartClass sc);
	
	public List<StartClass> showclass(@Param("a")int a,@Param("b")int b,@Param("r") int r,@Param("e") int e  );

	public int count(@Param("r")int r,@Param("a")int a);
	
	public List<ClassCourse> selcetcoerse(int a,int b);
	
	public void addClassCourse(StartClass sc);
	
	public List<CourseSys> SelectClassSys();
	
	public void insertClassCourse(ClassCourse employee);
	
	public void insertCourseSys(CourseSys cs );
	
	public CourseSys CourseSys(int a);

    public void deleteCoursesysByid(int a);

    public void xuanke(@Param("a") int a,@Param("s") Integer[] s);
    
    public List<ClassCourse> selcetcoersenull(int a,int b);

	public void updateClassCourse(ClassCourse employee);

	public List<CourseSys> selectCourseSysByID(int coursesys_csid);

	public void updateCourseSys(CourseSys cs);

	public List<ClassCourse> selectClassCourseBYID(int classsys_id);
	
	public CourseSys CourseSys_name(CourseSys cs);
	
	public CourseSys coursesys_csid(int cs);

	public void insertCourseSysID(CourseSys cs);

	public List<ClassCourse> daochu(int id);

	public JiaoShi selectnum(int classroom_id);

	public Role selectRoleByName(String employee_loginname);

	public List<CourseSys> selectsysByRole(Role r);

	public Employee selectBYIDBYName(String employee_loginname);

    public void deleteClassCourse(ClassCourse C);

	public void deleteClassCourseBYSYSiD(int coursesys_csid);
}

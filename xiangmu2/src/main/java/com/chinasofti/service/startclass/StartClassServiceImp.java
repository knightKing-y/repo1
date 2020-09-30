package com.chinasofti.service.startclass;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.dao.startclass.StartClassDaoInf;
import com.chinasofti.util.ToolUtil;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.jiaoshi.JiaoShi;
import com.chinasofti.vo.startclass.ClassCourse;
import com.chinasofti.vo.startclass.CourseSys;
import com.chinasofti.vo.startclass.StartClass;
import com.chinasofti.vo.xitong.Role;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class StartClassServiceImp implements StartClassServiceInf{

	@Autowired
	private StartClassDaoInf startClassDaoInf;
	

	@Override
	public List<StartClass> selectBYAREAID(int a, int b) {
		
		return startClassDaoInf.selectBYAREAID(a, b);
	}

	@Override
	public void addclassroom(StartClass sc) {
		
		startClassDaoInf.addclassroom(sc);
	}

	@Override
	public void updatenum(StartClass sc) {
		
		startClassDaoInf.updatenum(sc);
	}

	@Override
	public List<StartClass> showclass(int a,int b,int r,int e) {

		return startClassDaoInf.showclass(a,b,r,e);
	}

	@Override
	public int count(int r,int b) {
		
		return startClassDaoInf.count(r,b);
	}

	@Override
	public List<ClassCourse> selcetcoerse(int a,int b) {
		
		return startClassDaoInf.selcetcoerse(a,b);
	}

	@Override
	public void addClassCourse(StartClass sc) {
		
		startClassDaoInf.addClassCourse(sc);
	}

	@Override
	public List<CourseSys> SelectClassSys() {
		
		return startClassDaoInf.SelectClassSys();
	}

	@Override
	public int daoru(MultipartFile file, HttpSession session, ClassCourse cc, CourseSys cs) throws Throwable  {
		int count = 0;
		Workbook readwb = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (!file.isEmpty()) {
			InputStream instream;
			
				instream = file.getInputStream();
				readwb = Workbook.getWorkbook(instream);
				Sheet readsheet = readwb.getSheet(0);
				// 多少列
				int rsColumns = readsheet.getColumns();
				// 多少行
				int rsRows = readsheet.getRows();
				
				for (int i = 1; i < rsRows; i++) {

					ClassCourse employee = new ClassCourse();
					// 取每一行的各个列的值放在一个实体类对象中。
					for (int j = 0; j < rsColumns; j++) {
						// getCell(j, i) ---> j是列数，i是行数
						Cell cell = readsheet.getCell(j, i);
						switch (j) {
							case 0:
									employee.setClasscourse_name(cell.getContents());
									continue;
							case 1:
									employee.setClasscourse_starttime(ToolUtil.StringToDate(cell.getContents()));
									continue;
							case 2:
								    employee.setClasscourse_endtime(ToolUtil.StringToDate(cell.getContents()));
								    continue;
							case 3:
								    employee.setTech_tid(cs.getTech_id());
								    continue;
							case 4:
							        employee.setClasssys_id(cs.getCoursesys_csid());;
							        continue;
							default:
								  break;
						}
					}
					List<ClassCourse> list1=startClassDaoInf.selectClassCourseBYID(cs.getCoursesys_csid());
					if(list1.isEmpty()){
					    startClassDaoInf.insertClassCourse(employee);
						count++;
					}else{
						startClassDaoInf.deleteClassCourse(employee);
						startClassDaoInf.insertClassCourse(employee);
						//startClassDaoInf.updateClassCourse(employee);
						count++;
					}
					System.out.println(i + "行完了");
				} // 行循环完了
				List<CourseSys> list =startClassDaoInf.selectCourseSysByID(cs.getCoursesys_csid());
				if(list.isEmpty()){
				    startClassDaoInf.insertCourseSys(cs);
				    startClassDaoInf.insertCourseSysID(cs);
				}else{
					startClassDaoInf.updateCourseSys(cs);
				    startClassDaoInf.insertCourseSysID(cs);
				}
		}
		return count;
	}

	@Override
	public CourseSys coursesys_csid(int a) {
		
		return startClassDaoInf.coursesys_csid(a);
	}

	@Override
	public void deleteCoursesysByid(int a) {
		startClassDaoInf.deleteCoursesysByid(a);
		
	}

	@Override
	public void xuanke(int a,Integer[] s) {
		startClassDaoInf.xuanke(a,s);
	}

	@Override
	public List<ClassCourse> selcetcoersenull(int a, int b) {
		// TODO Auto-generated method stub
		return startClassDaoInf.selcetcoersenull(a, b);
	}

	@Override
	public List<ClassCourse> daochu(int id) {
		
		return startClassDaoInf.daochu(id);
	}

	@Override
	public JiaoShi selectnum(int classroom_id) {
		
		return startClassDaoInf.selectnum(classroom_id);
	}

	@Override
	public Role selectRoleByName(String employee_loginname) {
		// TODO Auto-generated method stub
		return startClassDaoInf.selectRoleByName(employee_loginname);
	}

	@Override
	public List<CourseSys> selectsysByRole(Role r) {
		
		return startClassDaoInf.selectsysByRole(r);
	}

	@Override
	public Employee selectBYIDBYName(String employee_loginname) {
		// TODO Auto-generated method stub
		return startClassDaoInf.selectBYIDBYName(employee_loginname);
	}

	@Override
	public void deleteClassCourseBYSYSiD(int coursesys_csid) {
		startClassDaoInf.deleteClassCourseBYSYSiD(coursesys_csid);
		
	}
}

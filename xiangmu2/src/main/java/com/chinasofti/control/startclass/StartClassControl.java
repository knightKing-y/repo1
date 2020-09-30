package com.chinasofti.control.startclass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.chinasofti.service.employee.EmployeeServiceInf;
import com.chinasofti.service.kecheng.TechServiceInf;
import com.chinasofti.service.quyu.QuyuServiceInf;
import com.chinasofti.service.startclass.StartClassServiceInf;
import com.chinasofti.util.Fenye;
import com.chinasofti.util.MessageUtil;
import com.chinasofti.util.ToolUtil;
import com.chinasofti.vo.employee.Employee;
import com.chinasofti.vo.employee.JsonStr;
import com.chinasofti.vo.jiaoshi.JiaoShi;
import com.chinasofti.vo.kecheng.Tech;
import com.chinasofti.vo.quyu.Quyu;
import com.chinasofti.vo.startclass.ClassCourse;
import com.chinasofti.vo.startclass.CourseSys;
import com.chinasofti.vo.startclass.StartClass;
import com.chinasofti.vo.xitong.Role;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



@Controller
@RequestMapping("startclassControl")
public class StartClassControl {

	@Autowired
	private QuyuServiceInf quyuServiceInf;
	
	@Autowired
	private TechServiceInf TechServiceInf;// 技术方向
	
	@Autowired
	private StartClassServiceInf startClassServiceInf;
	
	@Autowired
	private EmployeeServiceInf employeeServiceInf; // 员工
	
	@RequestMapping("startclass")
	public String startclass(Model model){
	
		//所有区域带到页面上
		List<Quyu>  quyuList = quyuServiceInf.selectQuyu();
		model.addAttribute("quyuList",quyuList );
		// 所有技术方向
		List<Tech> tech = TechServiceInf.selectTech();
		model.addAttribute("tech", tech);
		return "/WEB-INF/startclass/startclass.jsp";
	}
	
	
	@RequestMapping("selectBYAREAID")
	@ResponseBody
	public String selectBYAREAID(int tech_id,int startclass_region){
		List<StartClass> list=startClassServiceInf.selectBYAREAID(tech_id, startclass_region);
        String str=JSON.toJSONString(list);
        System.out.println(str);
		return str;
		
	}
	
	@RequestMapping("addclassroom")
	public String addclassroom(StartClass sc){
		startClassServiceInf.addclassroom(sc);
		startClassServiceInf.updatenum(sc);
		return "forward:/startclassControl/showclass";
		
	}
	
	@RequestMapping("showclass")
	public String showclass(Model model,int page,HttpSession session){
		// 当前页
		Employee e=(Employee)session.getAttribute("user");
		Role r=startClassServiceInf.selectRoleByName(e.getEmployee_loginname());
		e=startClassServiceInf.selectBYIDBYName(e.getEmployee_loginname());
					int currentpage = page;
					if(currentpage==0){
						currentpage=Fenye.currentpage;
					}
					// 一页显示多少条
					int Onepagecount = Fenye.Onepagecount;

					// 总条数
					int tiaoshu = startClassServiceInf.count(r.getRole_id(),e.getEmployee_id());
					// 总共显示多少页
					int yeshu = (tiaoshu - 1) / Onepagecount + 1;

					// 如果当前页>总页数
					if (currentpage > yeshu) {
						currentpage = yeshu;
					}
					// 如果当前页<0
					if (currentpage <= 0) {
						currentpage = 1;
					}
					int start = (currentpage - 1) * Onepagecount + 1;
					int end = start + Onepagecount;
		List<StartClass> sclist=startClassServiceInf.showclass(start,end,r.getRole_id(),e.getEmployee_id());
		List<Employee> emlist=employeeServiceInf.selectEmployee();
		List<Tech> tlist=TechServiceInf.selectTech();
		model.addAttribute("sclist", sclist);
		model.addAttribute("emlist", emlist);
		model.addAttribute("tlist", tlist);
		model.addAttribute("tiaoshu", tiaoshu);
		model.addAttribute("currentpage",currentpage);
		model.addAttribute("yeshu", yeshu);
		return "/WEB-INF/startclass/showclassroom.jsp";
	}
	
	@RequestMapping("kechengbiao")
	public String kechengbiao(int tech_id,int startclass_sid,Model model){
	
		List<ClassCourse> list=startClassServiceInf.selcetcoerse(tech_id,startclass_sid);
		if(list.isEmpty()){
			List<ClassCourse> list1=startClassServiceInf.selcetcoersenull(tech_id, startclass_sid);
			model.addAttribute("state", 0);
			model.addAttribute("list",list1);
			model.addAttribute("startclass_sid",startclass_sid);
			return "/WEB-INF/startclass/classcourse.jsp";
		}else{
			model.addAttribute("state", 1);
			model.addAttribute("list",list);
			model.addAttribute("startclass_sid",startclass_sid);
			return "/WEB-INF/startclass/classcourse.jsp";
		}
		
	}
	
	@RequestMapping("calsssys")
	public String calssSYS(Model model){
		List<CourseSys> list=startClassServiceInf.SelectClassSys();
		model.addAttribute("list",list);
		return "/WEB-INF/startclass/classsystem.jsp";
	}
	
	
	@RequestMapping("gotoAddCoursesys")
	public String gotoAddCoursesys(Model model){
		List<Tech> tech=TechServiceInf.selectTech();
		model.addAttribute("tech", tech);
		return "/WEB-INF/startclass/addclasssystem.jsp";
		
	}
	
	@ResponseBody
	@RequestMapping("daoru")
	public JsonStr daoru(@RequestParam("upload") MultipartFile files,HttpSession session,ClassCourse cc,CourseSys cs) throws Throwable{
		JsonStr json = new JsonStr();
		try {
			int count = startClassServiceInf.daoru(files, session,cc,cs);
			json.setSuccess(true);
			json.setMsg(MessageUtil.DAORU_SUCCESS + count + "条");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg(MessageUtil.DAORU_FAIL + e.getMessage());
			//logger.error(e.getMessage());
		}
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("/daochu")
	public void daochu(HttpServletResponse response,int id) {
         // 文件名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date()) + ".xls";
       
		response.setContentType("application/x-excel");
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);// excel文件名
         //得到要导出的数据
		List<ClassCourse> employeeList = this.startClassServiceInf.daochu(id);
		try {
			// 1.创建excel文件
			WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
			// 居中
			WritableCellFormat wf = new WritableCellFormat();
			wf.setAlignment(Alignment.CENTRE);
			// 2.创建sheet
			 WritableSheet sheet = book.createSheet("课程体系表", 0);
			// 3.添加第一行标题数据
			// (0,0) ---( 列[从0开始],行[从0开始] ）
			    sheet.addCell(new Label(0, 0, "课程名", wf));
				sheet.addCell(new Label(1, 0, "开始时间", wf));
				sheet.addCell(new Label(2, 0, "结束时间", wf));
				// 4.设置单元格的宽度
				sheet.setColumnView(0, 30);
				sheet.setColumnView(1, 30);
				sheet.setColumnView(2, 30);
				for (int i = 0; i < employeeList.size(); i++) {
					ClassCourse employee = employeeList.get(i);
					// 5.添加学生具体数据
					sheet.addCell(new Label(0, i + 1,employee.getClasscourse_name(), wf));
					sheet.addCell(new Label(1, i + 1,ToolUtil.DatetoString( employee.getClasscourse_starttime()) + "", wf));
					sheet.addCell(new Label(2, i + 1,ToolUtil.DatetoString( employee.getClasscourse_endtime()), wf));
				}
			// 6.从内存中写入文件中
			book.write();
			// 7.关闭资源，释放内存
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("selectCoursesysByid")
	public String selectCoursesysByid(Model model,int coursesys_csid){
		CourseSys cs=startClassServiceInf.coursesys_csid(coursesys_csid);
		List<Tech> tlist=TechServiceInf.selectTech();
		model.addAttribute("tlist", tlist);
		model.addAttribute("cs", cs);
		model.addAttribute("coursesys_csid",coursesys_csid);
		return "/WEB-INF/startclass/updateclasssystem.jsp";
	}
	
	@RequestMapping("deleteCoursesysByid")
	public String deleteCoursesysByid(Model model,int coursesys_csid){
		startClassServiceInf.deleteCoursesysByid(coursesys_csid);
		startClassServiceInf.deleteClassCourseBYSYSiD(coursesys_csid);
		List<CourseSys> list=startClassServiceInf.SelectClassSys();
		model.addAttribute("list",list);
		return  "/WEB-INF/startclass/classsystem.jsp";
	}

	@RequestMapping("xuanke")
	public String xuanke(int startclass_sid,String classcourse_id){
		System.out.println(startclass_sid); 
		String[] str=classcourse_id.split(",");
		Integer [] l=new Integer[str.length];
		for(int i=0;i<str.length;i++){
			l[i]=Integer.parseInt(str[i]);
		}
		for(int a:l){
		System.out.println(a);
		}
		startClassServiceInf.xuanke(startclass_sid,l);
		return "redirect:/startclassControl/showclass?page=1";
	} 
	
	@ResponseBody
	@RequestMapping("selectnum")
	public String selectnum(int classroom_id,int employee_num){
		JiaoShi js=startClassServiceInf.selectnum(classroom_id);
		String json=null;
		if(js!=null){
			if(js.getClass_num()> employee_num){
				json="{\"state\":1,\"msg\":\"you can use this room！\"}";
			}else if(js.getClass_num()== employee_num){
				json="{\"state\":1,\"msg\":\"you can use this room！\"}";
			}
			else{
				json="{\"state\":0,\"msg\":\"you not can use this room！choose another\"}";
			}
		}
		System.out.println(json);
		return json;
		
	}
}

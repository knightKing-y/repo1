package com.chinasofti.control.jiaoshi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.service.jiaoshi.classServiceInf;
import com.chinasofti.service.quyu.QuyuServiceInf;
import com.chinasofti.vo.jiaoshi.JiaoShi;
import com.chinasofti.vo.quyu.Quyu;

@Controller
@RequestMapping("jiaoshicontrol")
public class jiaoshiControl {

	@Autowired
	private classServiceInf classserviceInf;
	@Autowired
	private QuyuServiceInf QuyuServiceInf;
	
	@RequestMapping("showclass")
	public String showClass(Model model){
		List<JiaoShi> list=classserviceInf.findClass();
		model.addAttribute("list",list);
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		return "/WEB-INF/jiaoshi/showclass.jsp";
	}
	
	@RequestMapping("gotoaddclassjsp")
	public String gotoAddclassjsp(Model model){
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		return "/WEB-INF/jiaoshi/addclass.jsp";
		
	}
	
	@RequestMapping("addclass")
	public String addclass(JiaoShi j,Model model){
		List<JiaoShi> list=classserviceInf.addJiaoShi(j);
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		model.addAttribute("list",list);
		return "/WEB-INF/jiaoshi/showclass.jsp";
		
	}
	
	@RequestMapping("updateclassjsp")
	public String updateclassjsp(int class_id,Model model){
		JiaoShi js=classserviceInf.SelectClassBYID(class_id);
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		model.addAttribute("js", js);
		return "/WEB-INF/jiaoshi/updateclass.jsp";
	}
	
	@RequestMapping("updateclass")
	public String updateclass(JiaoShi j,Model model){
		classserviceInf.updateclass(j);
		List<JiaoShi> list=classserviceInf.findClass();
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		model.addAttribute("list",list);
		return "/WEB-INF/jiaoshi/showclass.jsp";
	}
	
	@RequestMapping("mhselectclass")
	public String mhselectclass(int area_id,Model model){
		List<JiaoShi> list =classserviceInf.mhselectclass(area_id);
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		model.addAttribute("list", list);
		model.addAttribute("a", area_id);
		return "/WEB-INF/jiaoshi/showclass.jsp";
	}
	
	@RequestMapping("deleteclass")
	public String deleteclass(int class_id,Model model){
		List<JiaoShi> list =classserviceInf.deleteclass(class_id);
		List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
		model.addAttribute("quyulist", quyulist);
		model.addAttribute("list", list);
		return "/WEB-INF/jiaoshi/showclass.jsp";
	}
	
//	@RequestMapping("selectRoomByname")
//	@ResponseBody
//	public String selectRoomByname(HttpServletRequest request){
//		String classroom_name=request.getParameter("classroom_name");
//		String str=null;
//		Classroom cr=classroomServiceInf.selectRoomByname(Integer.parseInt(classroom_name));
//		if(cr!=null){
//			str="{\"msg\":\"教室名重复\",\"bool\":2}";
//		}else{
//			str="{\"msg\":\"教室名可使用\",\"bool\":1}";
//		}
//		return str;
//	}
}

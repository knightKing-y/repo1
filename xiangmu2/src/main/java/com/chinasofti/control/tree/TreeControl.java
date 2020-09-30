package com.chinasofti.control.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.service.tree.TreeServiceInf;

import com.chinasofti.util.Md5Util;
import com.chinasofti.vo.user.ClassRoom;
import com.chinasofti.vo.user.Student;
import com.chinasofti.vo.user.Tree;
import com.chinasofti.vo.user.Users;

/**
 * @Description: 用户等录及注册模
 * @Date: 2017.11.24
 * @author lv
 * @version 1.0
 */
@Controller
@RequestMapping("treeControl")
public class TreeControl {

	@Autowired
	private TreeServiceInf treeServiceInf;

	/**
	 * 用户注册功能
	 * 
	 * @param users
	 *            用户信息实体类
	 * @return 注册跳转页面
	 */
	@RequestMapping("getTreeData")
	@ResponseBody
	public List<Tree> getTreeData(HttpServletRequest request, HttpServletResponse response,Tree tree){  
	   System.out.println("fdsf"); 
	    List<ClassRoom> classList =  treeServiceInf.getClassRoom();
	    //[{eventid:"c001",classname:'奥赛班',eventid:"c002",classname:'直播班',eventid:"c003",classname:'火箭班'}]  
	    
	    List<Tree> list = new ArrayList<Tree>();  
	    for(int i=0; i<classList.size(); i++){  
	        Tree model = new Tree();  
	        ClassRoom classRoom = (ClassRoom) classList.get(i);  
	        //{eventid:"c001",classname:'奥赛班'}  
	        String classId =  classRoom.getClassid(); 
	        String className = classRoom.getClassname();
	        model.setId(classId);   
	        model.setText(className);  
	        List<Student> studentList =  treeServiceInf.getStudent(classId);
	          
	        if(studentList.size() > 0){  
	            List<Tree> childrenList = new ArrayList<Tree>();  
	            for(int j = 0;j<studentList.size();j++){  
	                Tree model2 = new Tree();  
	                Student student = (Student)studentList.get(j);  
	                String sid = student.getSid();
	                String sname = student.getSname();
	                model2.setId(sid);  
	                model2.setText(sname);
	                
	                childrenList.add(model2);  
	            }  
	            model.setChildren(childrenList);  
	        }  
	        list.add(model);   
	    }  
	    return list;  
	}  

}

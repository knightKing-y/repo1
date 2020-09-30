package com.chinasofti.service.tree;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.tree.TreeDaoInf;
import com.chinasofti.vo.user.ClassRoom;
import com.chinasofti.vo.user.Student;
@Service
public class TreeServiceImpl implements TreeServiceInf{
	@Autowired
    private   TreeDaoInf  treeDaoInf;
    
    
	public List<ClassRoom> getClassRoom() {
		return treeDaoInf.getClassRoom();
		
	}

	public List<Student> getStudent(String classid) {
		
		return treeDaoInf.getStudent(classid);
	}

	

}

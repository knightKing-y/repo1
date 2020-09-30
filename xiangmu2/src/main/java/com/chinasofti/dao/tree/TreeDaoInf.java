package com.chinasofti.dao.tree;

import java.util.List;

import com.chinasofti.vo.user.ClassRoom;
import com.chinasofti.vo.user.Student;

public interface TreeDaoInf {

	public List<ClassRoom>   getClassRoom();
	public List<Student>     getStudent(String classid);

}

package com.chinasofti.service.tree;

import java.util.List;

import com.chinasofti.vo.user.ClassRoom;
import com.chinasofti.vo.user.Student;

public interface TreeServiceInf {

	public List<ClassRoom>   getClassRoom();
	public List<Student>     getStudent(String classid);

}

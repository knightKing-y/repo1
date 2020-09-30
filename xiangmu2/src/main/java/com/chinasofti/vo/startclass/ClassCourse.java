package com.chinasofti.vo.startclass;

import java.util.Date;

public class ClassCourse {

	private String classcourse_name;
	private int classcourse_id;
	private int startclass_sid;
	private Date classcourse_starttime;
	private Date classcourse_endtime;
	private int tech_tid;
	private int classsys_id;
	
	
	
	public int getClasssys_id() {
		return classsys_id;
	}
	public void setClasssys_id(int classsys_id) {
		this.classsys_id = classsys_id;
	}
	public int getTech_tid() {
		return tech_tid;
	}
	public void setTech_tid(int tech_tid) {
		this.tech_tid = tech_tid;
	}
	public String getClasscourse_name() {
		return classcourse_name;
	}
	public void setClasscourse_name(String classcourse_name) {
		this.classcourse_name = classcourse_name;
	}
	public int getClasscourse_id() {
		return classcourse_id;
	}
	public void setClasscourse_id(int classcourse_id) {
		this.classcourse_id = classcourse_id;
	}
	public int getStartclass_sid() {
		return startclass_sid;
	}
	public void setStartclass_sid(int startclass_sid) {
		this.startclass_sid = startclass_sid;
	}
	public Date getClasscourse_starttime() {
		return classcourse_starttime;
	}
	public void setClasscourse_starttime(Date classcourse_starttime) {
		this.classcourse_starttime = classcourse_starttime;
	}
	public Date getClasscourse_endtime() {
		return classcourse_endtime;
	}
	public void setClasscourse_endtime(Date classcourse_endtime) {
		this.classcourse_endtime = classcourse_endtime;
	}
	
	

}

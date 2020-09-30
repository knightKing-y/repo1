package com.chinasofti.vo.startclass;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StartClass implements Serializable{

	private int startclass_sid;    //开班管理表ID
	private int role_id;           //角色ID
	private int classroom_id;      //教室ID
	private String classroom_name;            //班级名称
	private int startclass_number;            //班级人数
	
	@DateTimeFormat(pattern="yyyy-MM-dd ")
	private Date startclass_starttime;        //开班时间
	@DateTimeFormat(pattern="yyyy-MM-dd ")
	private Date startclass_endtime;          //结束时间
	
	private int startclass_teacher;           //班级讲师id
	private int startclass_teahingassient;    //班级助教id
	private int startclass_classtutor;      //班主任id
	private String startclass_snature;      //班级性质
	private String startclass_status;      //班级状态
	private String startclass_school;      //学校信息
	private int startclass_region;         //开班地域
	private String employee_name;          //员工名字
	private int employee_id;               
	private int tech_id;
	private int employee_num;
	private String starttime;
	private String endtime;
	
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getEmployee_num() {
		return employee_num;
	}
	public void setEmployee_num(int employee_num) {
		this.employee_num = employee_num;
	}
	public int getTech_id() {
		return tech_id;
	}
	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getStartclass_sid() {
		return startclass_sid;
	}
	public void setStartclass_sid(int startclass_sid) {
		this.startclass_sid = startclass_sid;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	public String getClassroom_name() {
		return classroom_name;
	}
	public void setClassroom_name(String classroom_name) {
		this.classroom_name = classroom_name;
	}
	public int getStartclass_number() {
		return startclass_number;
	}
	public void setStartclass_number(int startclass_number) {
		this.startclass_number = startclass_number;
	}
	public Date getStartclass_starttime() {
		return startclass_starttime;
	}
	public void setStartclass_starttime(Date startclass_starttime) {
		this.startclass_starttime = startclass_starttime;
	}
	public Date getStartclass_endtime() {
		return startclass_endtime;
	}
	public void setStartclass_endtime(Date startclass_endtime) {
		this.startclass_endtime = startclass_endtime;
	}
	public int getStartclass_teacher() {
		return startclass_teacher;
	}
	public void setStartclass_teacher(int startclass_teacher) {
		this.startclass_teacher = startclass_teacher;
	}
	public int getStartclass_teahingassient() {
		return startclass_teahingassient;
	}
	public void setStartclass_teahingassient(int startclass_teahingassient) {
		this.startclass_teahingassient = startclass_teahingassient;
	}
	public int getStartclass_classtutor() {
		return startclass_classtutor;
	}
	public void setStartclass_classtutor(int startclass_classtutor) {
		this.startclass_classtutor = startclass_classtutor;
	}
	public String getStartclass_snature() {
		return startclass_snature;
	}
	public void setStartclass_snature(String startclass_snature) {
		this.startclass_snature = startclass_snature;
	}
	public String getStartclass_status() {
		return startclass_status;
	}
	public void setStartclass_status(String startclass_status) {
		this.startclass_status = startclass_status;
	}
	public String getStartclass_school() {
		return startclass_school;
	}
	public void setStartclass_school(String startclass_school) {
		this.startclass_school = startclass_school;
	}
	public int getStartclass_region() {
		return startclass_region;
	}
	public void setStartclass_region(int startclass_region) {
		this.startclass_region = startclass_region;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	
	
}

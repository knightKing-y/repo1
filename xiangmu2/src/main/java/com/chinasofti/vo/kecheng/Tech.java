package com.chinasofti.vo.kecheng;

import java.io.Serializable;
/**
 * @Description: 技术方向
 * @Date: 2018.2.1
 * @author lv
 * @version 1.0
 */
public class  Tech    implements Serializable{
	
	private int tech_id   ; //技术方向ID
	private String    tech_tname;  //技术方向名称
	
	
	public int getTech_id() {
		return tech_id;
	}
	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}
	public String getTech_tname() {
		return tech_tname;
	}
	public void setTech_tname(String tech_tname) {
		this.tech_tname = tech_tname;
	}
	
	
	
	

}

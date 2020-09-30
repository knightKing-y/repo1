package com.chinasofti.vo.xitong;

import java.io.Serializable;

/**
 * @Description: 角色权限管理
 * @Date: 2018.1.30
 * @author lv
 * @version 1.0
 */
public class Role_Authority implements Serializable{

	 private Integer AUTHORITY_ID;  //权限ID
	 private Integer   ROLE_ID ;  //角色ID
	 
	public Integer getAUTHORITY_ID() {
		return AUTHORITY_ID;
	}
	public void setAUTHORITY_ID(Integer aUTHORITY_ID) {
		AUTHORITY_ID = aUTHORITY_ID;
	}
	public Integer getROLE_ID() {
		return ROLE_ID;
	}
	public void setROLE_ID(Integer rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}
	 
	 

}

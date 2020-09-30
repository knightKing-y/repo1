package com.chinasofti.dao.jiaoshi;

import java.util.List;

import com.chinasofti.vo.jiaoshi.JiaoShi;

public interface classDaoInf {
	
	public List<JiaoShi> shoeClass();
	
	public void addJiaoShi(JiaoShi j);
	
	public JiaoShi SelectClassBYID(int a);
	
	public void updateclass(JiaoShi j);
	
	public List<JiaoShi> mhselectclass(int a);

	public void deleteclass(int a);
}

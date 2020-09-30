package com.chinasofti.service.jiaoshi;

import java.util.List;

import com.chinasofti.vo.jiaoshi.JiaoShi;



public interface classServiceInf {
	
	public List<JiaoShi> findClass();

	public List<JiaoShi> addJiaoShi(JiaoShi j);
	
	public JiaoShi SelectClassBYID(int a);
	
	public List<JiaoShi> updateclass(JiaoShi j);
	
	public List<JiaoShi> mhselectclass(int a);
	
	public List<JiaoShi> deleteclass(int a);
}

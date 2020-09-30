package com.chinasofti.service.jiaoshi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.jiaoshi.classDaoInf;
import com.chinasofti.vo.jiaoshi.JiaoShi;

@Service
public class classServiceImp implements classServiceInf{

	@Autowired
	private classDaoInf classdaoinf;
	
	@Override
	public List<JiaoShi> findClass() {
		
		return classdaoinf.shoeClass();
	}
	
	public List<JiaoShi> addJiaoShi(JiaoShi j){
		classdaoinf.addJiaoShi(j);
		List<JiaoShi> list=classdaoinf.shoeClass();
		return list;
	}

	@Override
	public JiaoShi SelectClassBYID(int a) {
		
		return classdaoinf.SelectClassBYID(a);
	}

	@Override
	public List<JiaoShi> updateclass(JiaoShi j) {
		classdaoinf.updateclass(j);
		List<JiaoShi> list=classdaoinf.shoeClass();
		return list;
	}

	@Override
	public List<JiaoShi> mhselectclass(int a) {
		
		return classdaoinf.mhselectclass(a);
	}

	@Override
	public List<JiaoShi> deleteclass(int a) {
		classdaoinf.deleteclass(a);
		return classdaoinf.shoeClass();
	}
}

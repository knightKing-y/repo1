package com.chinasofti.service.quyu;

import java.util.List;

import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.quyu.Quyu;


public interface PositionServiceInf {
	/**
	 *  添加职称
	 * @param position职称对象
	 */
	public void addPosition(Position  position);
	
	/**
	 *  查询所有职称
	 *@return  职称列表页
	 */
	public List<Position> selectPosition();
	/**
	 *  按条件查询职称
	 *@return  职称列表页
	 */
	public List<Position> selectPositionByInfo(Position  position);

	/**
	 * 根据职称id,查询职称信息
	 * @return  职称列表页
	 */
	
	public  Position  selectPositionByid(int position_id);
	/**
	 *根据职称id,修改职称信息
	 *  @param position 职称对象
	 */
	public void updatePosition(Position  position);
	/**
	 * 根据区域id,查找出部门信息
	 * 
	 * @return 职称列表页
	 */
	public  List<Department>  selectDepartmentByAreaid(int area_id);
	
	
}

package com.chinasofti.service.quyu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.dao.quyu.PositionDaoInf;
import com.chinasofti.vo.quyu.Department;
import com.chinasofti.vo.quyu.Position;
import com.chinasofti.vo.quyu.Quyu;

@Service
public class PositionServiceImpl implements PositionServiceInf {

	@Autowired
	private PositionDaoInf positionDaoInf;

	/**
	 * 添加职称
	 * 
	 * @param position职称对象
	 */
	public void addPosition(Position position) {
		positionDaoInf.addPosition(position);
	}

	/**
	 * 查询所有职称
	 * 
	 * @return 职称列表页
	 */
	public List<Position> selectPosition() {
		return positionDaoInf.selectPosition();
	}
	/**
	 *  按条件查询职称
	 *@return  职称列表页
	 */
	public List<Position> selectPositionByInfo(Position  position){
		
		return positionDaoInf.selectPositionByInfo(position);
		
	}
	/**
	 * 根据职称id,查询职称信息
	 * 
	 * @return 职称列表页
	 */

	public Position selectPositionByid(int position_id) {
		return positionDaoInf.selectPositionByid(position_id);
	}

	/**
	 * 根据职称id,修改职称信息
	 * 
	 * @param position
	 *            职称对象
	 */
	public void updatePosition(Position position) {
		positionDaoInf.updatePosition(position);

	}
	
	/**
	 * 根据区域id,查找出部门信息
	 * 
	 * @return 职称列表页
	 */
	public   List<Department>  selectDepartmentByAreaid(int area_id){
		return positionDaoInf.selectDepartmentByAreaid(area_id);
		
	}
	
	
}

package com.chinasofti.control.quyu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chinasofti.service.quyu.QuyuServiceInf;
import com.chinasofti.vo.quyu.Quyu;

/**
 * @Description: 区域管理
 * @Date: 2018.1.26
 * @author lv
 * @version 1.0
 */
@Controller
@RequestMapping("quyuControl")
public class QuyuControl {

	@Autowired
	private QuyuServiceInf QuyuServiceInf;

	/**
	 * 跳转到区域列表页
	 * 
	 * @return 区域列表页
	 */
	@RequestMapping("gotoQuyuList")
	public String gotoQuyuList() {
		// 先去查，在往页面上带值
		return "forward:/quyuControl/selectQuyu.action";
	}

	/**
	 * 跳转到区域添加页面
	 * 
	 * @return 区域添加页面
	 */
	@RequestMapping("gotoAddQuyu")
	public String gotoAddQuyu() {
		return "/WEB-INF/quyu/addquyu.jsp";
	}

	/**
	 * 添加区域
	 * 
	 * @return 区域列表页
	 */
	@RequestMapping("addQuyu")
	public String addQuyu(Quyu quyu) {
		String str = "forward:/quyuControl/selectQuyu.action";
		;
		try {
			QuyuServiceInf.addQuyu(quyu);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 查询所有区域
	 * 
	 * @return 区域列表页
	 */
	@RequestMapping("selectQuyu")
	public String selectQuyu(Model model) {

		String str = "/WEB-INF/quyu/quyuList.jsp";
		try {
			List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
			model.addAttribute("quyulist", quyulist);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 根据区域id,查找区域信息
	 * 
	 * @return 区域列表页
	 */
	@RequestMapping("selectQuyuByid")
	public String selectQuyuByid(int area_id, Model model) {
		String str = "/WEB-INF/quyu/updatequyu.jsp";
		try {
			Quyu quyu = QuyuServiceInf.selectQuyuByid(area_id);
			model.addAttribute("quyu", quyu);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;

	}

	/**
	 * 根据区域id,修改区域信息
	 * 
	 * @return 区域列表页
	 */
	@RequestMapping("updateQuyu")
	public String updateQuyu(Quyu quyu, Model model) {

		String str = "/WEB-INF/quyu/quyuList.jsp";
		try {
			// 先更新
			QuyuServiceInf.updateQuyu(quyu);
			// 在查找所有
			List<Quyu> quyulist = QuyuServiceInf.selectQuyu();
			model.addAttribute("quyulist", quyulist);
		} catch (Exception e) {
			str = "/error.jsp";
		}
		return str;
	}

	/*
	 * 
	 * 返回页面数据
	 * 
	 * @param returnString 返回数据
	 * 
	 * @throws CommonException 异常
	 * 
	 * response = ServletActionContext.getResponse();
	 * response.setContentType("application/json;charset=utf-8");
	 * response.getWriter().write(returnString); response.flushBuffer();
	 * response.getWriter().close();
	 * 
	 * 
	 */

}

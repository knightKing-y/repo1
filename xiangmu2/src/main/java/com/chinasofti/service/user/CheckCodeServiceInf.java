package com.chinasofti.service.user;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description: 验证码业务处理接口
 * @Date: 2017.11.24
 * @author lv
 * @version 1.0
 */

public interface CheckCodeServiceInf {
	/**
	 * 产生随机字母数字混合验证码
	 */
	public String generateRandomMixedCode();

	/**
	 * 生成校验码图片产生随机字母数字混合验证码
	 * 
	 * @param response
	 * @throws IOException
	 *             异常
	 */
	public BufferedImage getImage(String checkCode);

}

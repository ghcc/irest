package cn.codecoach.irest.impl;

import cn.codecoach.irest.IRestURL;
import cn.codecoach.irest.exception.IRestUrlException;

/**
 * url规范：<br>
 * /irest/JavaClassName/method?param
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestURLDefault implements IRestURL {

	public final static String IREST_URL_PREFIX = "/irest/";

	/**
	 * 解析URL
	 * 
	 * @param url
	 */
	public IRestURLDefault(String url) {
		if (url == null || "".equals(url.trim())) {
			throw new IRestUrlException("IRestURL错误： 不能为空！");
		}
		if (!url.startsWith(IRestURLDefault.IREST_URL_PREFIX)) {
			throw new IRestUrlException("IRestURL错误： URL必须以 【" + IRestURLDefault.IREST_URL_PREFIX
					+ "】开头！");
		}
		int paramIndex = url.indexOf("?");

		// 类名和方法名提取
		String javaClassNameAndMethod = null;
		if (paramIndex > -1) {
			javaClassNameAndMethod = url.substring(IRestURLDefault.IREST_URL_PREFIX.length(),
					paramIndex);
		} else {
			javaClassNameAndMethod = url.substring(IRestURLDefault.IREST_URL_PREFIX.length());
		}
		int methodIndex = javaClassNameAndMethod.indexOf('/');
		if (methodIndex == -1) {
			throw new IRestUrlException("IRestURL错误：  缺少类名或方法名；IRestURL规范为：【"
					+ IRestURLDefault.IREST_URL_PREFIX + "JavaClassName/method?param】");
		}

		setJavaClassName(javaClassNameAndMethod.substring(0, methodIndex));

		setJavaMethodName(javaClassNameAndMethod.substring(methodIndex + 1));

	}

	/**
	 * java类名
	 */
	private String javaClassName;

	/**
	 * 方法
	 */
	private String javaMethodName;

	public String getJavaClassName() {
		return javaClassName;
	}

	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}

	public String getJavaMethodName() {
		return javaMethodName;
	}

	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = javaMethodName;
	}

}

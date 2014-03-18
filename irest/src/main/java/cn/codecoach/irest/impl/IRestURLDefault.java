package cn.codecoach.irest.impl;

import cn.codecoach.irest.IRestURL;
import cn.codecoach.irest.exception.IRestUrlException;

/**
 * url�淶��<br>
 * /irest/JavaClassName/method?param
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestURLDefault implements IRestURL {

	public final static String IREST_URL_PREFIX = "/irest/";

	/**
	 * ����URL
	 * 
	 * @param url
	 */
	public IRestURLDefault(String url) {
		if (url == null || "".equals(url.trim())) {
			throw new IRestUrlException("IRestURL���� ����Ϊ�գ�");
		}
		if (!url.startsWith(IRestURLDefault.IREST_URL_PREFIX)) {
			throw new IRestUrlException("IRestURL���� URL������ ��" + IRestURLDefault.IREST_URL_PREFIX
					+ "����ͷ��");
		}
		int paramIndex = url.indexOf("?");

		// �����ͷ�������ȡ
		String javaClassNameAndMethod = null;
		if (paramIndex > -1) {
			javaClassNameAndMethod = url.substring(IRestURLDefault.IREST_URL_PREFIX.length(),
					paramIndex);
		} else {
			javaClassNameAndMethod = url.substring(IRestURLDefault.IREST_URL_PREFIX.length());
		}
		int methodIndex = javaClassNameAndMethod.indexOf('/');
		if (methodIndex == -1) {
			throw new IRestUrlException("IRestURL����  ȱ�������򷽷�����IRestURL�淶Ϊ����"
					+ IRestURLDefault.IREST_URL_PREFIX + "JavaClassName/method?param��");
		}

		setJavaClassName(javaClassNameAndMethod.substring(0, methodIndex));

		setJavaMethodName(javaClassNameAndMethod.substring(methodIndex + 1));

	}

	/**
	 * java����
	 */
	private String javaClassName;

	/**
	 * ����
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

package cn.codecoach.irest.impl.action;

import java.util.HashMap;
import java.util.Map;

import cn.codecoach.irest.action.IRestActionParam;

/**
 * action�Ĳ���
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestActionParamDefault implements IRestActionParam {

	/**
	 * ������
	 */
	private String javaMethodName;

	/**
	 * �ַ�������
	 */
	private Map<String, String> param = new HashMap<String, String>();

	/**
	 * ���Ӳ�����֧���ļ��ϴ��ȸ��Ӳ�����
	 */
	private Map<String, Object> complextParam = new HashMap<String, Object>();

	public IRestActionParamDefault(String url) {
		int paramsIndex = url.indexOf('?');
		if (paramsIndex > -1) {
			String params = url.substring(paramsIndex + 1);
			for (String param : params.split("&")) {
				String[] nameValue = param.split("=");
				addParam(nameValue[0], nameValue[1]);
			}
		}
	}

	public Map<String, String> getParam() {
		return param;
	}

	public Map<String, Object> getComplextParam() {
		return complextParam;
	}

	public String getJavaMethodName() {
		return javaMethodName;
	}

	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = javaMethodName;
	}

	public String getParam(String name) {
		return param.get(name);
	}

	public Object getComplexParam(String name) {
		return complextParam.get(name);
	}

	public void addParam(String name, String value) {
		param.put(name, value);
		complextParam.put(name, value);
	}

	public void addComplexParam(String name, String value) {
		complextParam.put(name, value);
	}

}

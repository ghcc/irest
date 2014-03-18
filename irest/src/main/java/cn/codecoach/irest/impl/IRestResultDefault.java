package cn.codecoach.irest.impl;

import java.util.HashMap;
import java.util.Map;

import cn.codecoach.irest.IRestResult;

/**
 * ���
 * 
 * @author yanchangyou@gmail.com
 */
public class IRestResultDefault implements IRestResult {
	/**
	 * �ַ���ֵ
	 */
	private Map<String, String> values = new HashMap<String, String>();

	/**
	 * ����ֵ(�����ַ���)
	 */
	private Map<String, Object> complextValues = new HashMap<String, Object>();

	public void addValue(String name, String value) {
		values.put(name, value);
		addComplextValue(name, value);
	}
	public String getValue(String name) {
		return values.get(name);
	}
	
	public void addComplextValue(String name, Object value) {
		complextValues.put(name, value);
	}

	public Object getComplextValue(String name) {
		return complextValues.get(name);
	}
	
}

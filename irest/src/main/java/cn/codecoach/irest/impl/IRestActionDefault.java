package cn.codecoach.irest.impl;

import cn.codecoach.irest.IRestAction;
import cn.codecoach.irest.impl.action.IRestActionParamDefault;

/**
 * Ĭ��action����<br>
 * ��������ͷ��ؽ��
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestActionDefault implements IRestAction {

	IRestActionParamDefault iRestActionParamDefault;
	IRestResultDefault iRestResultDefault;

	IRestActionParamDefault getiRestActionParamDefault() {
		return iRestActionParamDefault;
	}

	void setiRestActionParamDefault(IRestActionParamDefault iRestActionParamDefault) {
		this.iRestActionParamDefault = iRestActionParamDefault;
	}

	IRestResultDefault getiRestResultDefault() {
		return iRestResultDefault;
	}

	void setiRestResultDefault(IRestResultDefault iRestResultDefault) {
		this.iRestResultDefault = iRestResultDefault;
	}

	public void addValue(String name, String value) {
		iRestResultDefault.addValue(name, value);
	}

	public void addComplextValue(String name, Object value) {
		iRestResultDefault.addComplextValue(name, value);
	}

}

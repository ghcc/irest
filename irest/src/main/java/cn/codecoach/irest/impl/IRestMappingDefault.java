package cn.codecoach.irest.impl;

import cn.codecoach.irest.IRestAction;
import cn.codecoach.irest.IRestMapping;
import cn.codecoach.irest.IRestURL;
import cn.codecoach.irest.exception.IRestUrlException;

/**
 * Ĭ��ʵ��<br>
 * �������£�<br>
 * 1, ����url<br>
 * 2, ����action<br>
 * 3, ӳ�����<br>
 * 4, ���÷���<br>
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestMappingDefault implements IRestMapping {

	/**
	 * ����action
	 */
	public IRestAction fetchIRestAction(IRestURLDefault iRestURLDefault) {
		IRestAction iRestAction = null;
		Object temp = null;
		try {
			temp = Class.forName(iRestURLDefault.getJavaClassName()).newInstance();
		} catch (ClassNotFoundException e) {
			throw new IRestUrlException("IRestURL���� action��" + iRestURLDefault.getJavaClassName()
					+ "��������;IRestURL�淶Ϊ����" + IRestURLDefault.IREST_URL_PREFIX
					+ "JavaClassName/method?param��", e);
		} catch (InstantiationException e) {
			throw new IRestUrlException("IRestURL���� action��ҪĬ�Ϸ���", e);
		} catch (IllegalAccessException e) {
			throw new IRestUrlException("IRestURL���� new Action����ʧ��", e);
		}
		if (temp instanceof IRestAction) {
			iRestAction = (IRestAction) temp;
		} else {
			throw new IRestUrlException("IRestAction���� ����ʵ��IRestAction�ӿ�");
		}

		return iRestAction;
	}

	/**
	 * ӳ��
	 */
	public IRestAction mapping(IRestURL iRestURL) {
		IRestURLDefault iRestURLDefault = (IRestURLDefault) iRestURL;
		IRestAction iRestAction = fetchIRestAction(iRestURLDefault);
		return iRestAction;
	}
}

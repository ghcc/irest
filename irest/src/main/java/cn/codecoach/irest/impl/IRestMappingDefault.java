package cn.codecoach.irest.impl;

import cn.codecoach.irest.IRestAction;
import cn.codecoach.irest.IRestMapping;
import cn.codecoach.irest.IRestURL;
import cn.codecoach.irest.exception.IRestUrlException;

/**
 * 默认实现<br>
 * 流程如下：<br>
 * 1, 解析url<br>
 * 2, 生成action<br>
 * 3, 映射参数<br>
 * 4, 调用方法<br>
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestMappingDefault implements IRestMapping {

	/**
	 * 构造action
	 */
	public IRestAction fetchIRestAction(IRestURLDefault iRestURLDefault) {
		IRestAction iRestAction = null;
		Object temp = null;
		try {
			temp = Class.forName(iRestURLDefault.getJavaClassName()).newInstance();
		} catch (ClassNotFoundException e) {
			throw new IRestUrlException("IRestURL错误： action【" + iRestURLDefault.getJavaClassName()
					+ "】不存在;IRestURL规范为：【" + IRestURLDefault.IREST_URL_PREFIX
					+ "JavaClassName/method?param】", e);
		} catch (InstantiationException e) {
			throw new IRestUrlException("IRestURL错误： action需要默认方法", e);
		} catch (IllegalAccessException e) {
			throw new IRestUrlException("IRestURL错误： new Action操作失败", e);
		}
		if (temp instanceof IRestAction) {
			iRestAction = (IRestAction) temp;
		} else {
			throw new IRestUrlException("IRestAction错误： 必须实现IRestAction接口");
		}

		return iRestAction;
	}

	/**
	 * 映射
	 */
	public IRestAction mapping(IRestURL iRestURL) {
		IRestURLDefault iRestURLDefault = (IRestURLDefault) iRestURL;
		IRestAction iRestAction = fetchIRestAction(iRestURLDefault);
		return iRestAction;
	}
}

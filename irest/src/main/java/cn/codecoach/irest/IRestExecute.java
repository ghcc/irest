package cn.codecoach.irest;

import cn.codecoach.irest.action.IRestActionParam;

/**
 * ִ��
 * 
 * @author yanchangyou@gmail.com
 */
public interface IRestExecute {

	/**
	 * ִ��
	 * @param iRestResult 
	 * 
	 * @param iRestURL
	 */
	public IRestResult execute(IRestAction iRestAction, IRestActionParam iRestActionParamValue, IRestResult iRestResult);

}

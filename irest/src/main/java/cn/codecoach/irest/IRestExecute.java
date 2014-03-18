package cn.codecoach.irest;

import cn.codecoach.irest.action.IRestActionParam;

/**
 * Ö´ÐÐ
 * 
 * @author yanchangyou@gmail.com
 */
public interface IRestExecute {

	/**
	 * Ö´ÐÐ
	 * @param iRestResult 
	 * 
	 * @param iRestURL
	 */
	public IRestResult execute(IRestAction iRestAction, IRestActionParam iRestActionParamValue, IRestResult iRestResult);

}

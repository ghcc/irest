package cn.codecoach.irest;

/**
 * rest full 的filter<br>
 * 实现restfull风格的url映射
 * 
 * @author yanchangyou@gmail.com
 */
public interface IRestMapping {

	/**
	 * 过滤
	 * 
	 * @param iRestURL
	 */
	public IRestAction mapping(IRestURL iRestURL);

}

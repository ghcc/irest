package cn.codecoach.irest;

/**
 * rest full ��filter<br>
 * ʵ��restfull����urlӳ��
 * 
 * @author yanchangyou@gmail.com
 */
public interface IRestMapping {

	/**
	 * ����
	 * 
	 * @param iRestURL
	 */
	public IRestAction mapping(IRestURL iRestURL);

}

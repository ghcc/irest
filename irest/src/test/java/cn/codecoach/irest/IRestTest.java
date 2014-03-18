package cn.codecoach.irest;

import junit.framework.TestCase;
import cn.codecoach.irest.impl.IRestActionDefault;
import cn.codecoach.irest.impl.IRestExecuteDefault;
import cn.codecoach.irest.impl.IRestMappingDefault;
import cn.codecoach.irest.impl.IRestResultDefault;
import cn.codecoach.irest.impl.IRestURLDefault;
import cn.codecoach.irest.impl.action.IRestActionParamDefault;

public class IRestTest extends TestCase {

	public void test() {
		// fail("Not yet implemented");

		//服务器端获取的url
		String url = "/irest/cn.codecoach.irest.example.FirstAction/hello?who=world";

		//构造irest url对象
		IRestURLDefault iRestURL = new IRestURLDefault(url);

		IRestMappingDefault iRestMapping = new IRestMappingDefault();

		//映射action
		IRestActionDefault iRestAction = (IRestActionDefault) iRestMapping.mapping(iRestURL);

		IRestExecuteDefault iRestExecute = new IRestExecuteDefault();

		//参数
		IRestActionParamDefault param = new IRestActionParamDefault(url);
		
		param.setJavaMethodName(iRestURL.getJavaMethodName());
		
		//执行结果存储类
		IRestResultDefault iRestResult = new IRestResultDefault();
		
		//执行
		iRestExecute.execute(iRestAction, param, iRestResult);

		//获取结果
		String result = iRestResult.getValue("result");
		
		System.out.println("result : " + result);
	}

}

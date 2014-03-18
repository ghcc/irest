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

		//�������˻�ȡ��url
		String url = "/irest/cn.codecoach.irest.example.FirstAction/hello?who=world";

		//����irest url����
		IRestURLDefault iRestURL = new IRestURLDefault(url);

		IRestMappingDefault iRestMapping = new IRestMappingDefault();

		//ӳ��action
		IRestActionDefault iRestAction = (IRestActionDefault) iRestMapping.mapping(iRestURL);

		IRestExecuteDefault iRestExecute = new IRestExecuteDefault();

		//����
		IRestActionParamDefault param = new IRestActionParamDefault(url);
		
		param.setJavaMethodName(iRestURL.getJavaMethodName());
		
		//ִ�н���洢��
		IRestResultDefault iRestResult = new IRestResultDefault();
		
		//ִ��
		iRestExecute.execute(iRestAction, param, iRestResult);

		//��ȡ���
		String result = iRestResult.getValue("result");
		
		System.out.println("result : " + result);
	}

}

package cn.codecoach.irest.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import cn.codecoach.irest.IRestAction;
import cn.codecoach.irest.IRestExecute;
import cn.codecoach.irest.IRestResult;
import cn.codecoach.irest.action.IParam;
import cn.codecoach.irest.action.IRestActionParam;
import cn.codecoach.irest.exception.IRestUrlException;
import cn.codecoach.irest.impl.action.IRestActionParamDefault;

/**
 * 执行
 * 
 * @author yanchangyou@gmail.com
 */
public class IRestExecuteDefault implements IRestExecute {

	/**
	 * 执行
	 * 
	 * @param iRestURL
	 */
	public IRestResult execute(IRestAction iRestAction, IRestActionParam iRestActionParam,
			IRestResult iRestResult) {

		IRestActionParamDefault iRestActionParamDefault = (IRestActionParamDefault) iRestActionParam;
		((IRestActionDefault) iRestAction).setiRestActionParamDefault(iRestActionParamDefault);
		((IRestActionDefault) iRestAction).setiRestResultDefault((IRestResultDefault)iRestResult);
		
		Method javaMethod = null;
		String javaMethodName = iRestActionParamDefault.getJavaMethodName();
		Method[] methods = iRestAction.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(javaMethodName)) {
				javaMethod = method;
			}
		}
		if (javaMethod == null) {
			throw new IRestUrlException("IRestAction错误：类【" + iRestAction.getClass().getName()
					+ "】中必须存在方法【" + javaMethodName + "】");
		}

		Object[] javaParam = new Object[javaMethod.getParameterTypes().length];
		Annotation[][] annotationss = javaMethod.getParameterAnnotations();// .getAnnotations();
		int i = 0;
		for (Annotation[] annotations : annotationss) {
			for (Annotation annotation : annotations) {
				IParam iParam = (IParam) annotation;
				String name = iParam.value();
				javaParam[i++] = iRestActionParamDefault.getParam(name);
			}
		}

		try {
			javaMethod.invoke(iRestAction, javaParam);
		} catch (Exception e) {
			throw new IRestUrlException("IRestExecute错误：详细信息：" + e.getMessage(), e);
		}

		return iRestResult;
	}
}

package cn.codecoach.irest.action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * actionµÄ²ÎÊý
 * 
 * @author yanchangyou@gmail.com
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface IParam {

	String value();
}

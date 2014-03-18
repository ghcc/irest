package cn.codecoach.irest.example;

import cn.codecoach.irest.action.IParam;
import cn.codecoach.irest.impl.IRestActionDefault;

public class FirstAction extends IRestActionDefault {

	public void hello(@IParam("who") String who) {
		String result = "hello, " + who + "!";
		addValue("result", result);
	}
}

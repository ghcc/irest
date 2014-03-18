package cn.codecoach.irest.exception;

import cn.codecoach.irest.IRestException;

/**
 * URL“Ï≥£<br>
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestUrlException extends IRestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4379553628536610956L;

	public IRestUrlException() {
		super();
	}

	public IRestUrlException(String message) {
		super(message);
	}

	public IRestUrlException(String message, Exception e) {
		super(message,e);
	}

}

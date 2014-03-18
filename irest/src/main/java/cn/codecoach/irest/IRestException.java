package cn.codecoach.irest;

/**
 * 
 * “Ï≥£
 * 
 * @author yanchangyou@gmail.com
 * 
 */
public class IRestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4751173799084550382L;

	public IRestException() {
		super();
	}

	public IRestException(String message) {
		super(message);
	}

	public IRestException(String message, Exception e) {
		super(message, e);
	}

}

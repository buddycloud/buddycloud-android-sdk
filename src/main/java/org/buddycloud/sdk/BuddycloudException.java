package org.buddycloud.sdk;

public class BuddycloudException extends Exception {

	public BuddycloudException(String message) {
		super(message);
	}

	public BuddycloudException(Exception e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7640379576871356085L;

}

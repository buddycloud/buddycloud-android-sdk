package org.buddycloud.sdk;

public interface Callback<T> {

	void complete(T response);
	
}

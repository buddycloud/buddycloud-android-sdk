package org.buddycloud.sdk;

import org.buddycloud.sdk.model.NotificationSettings;
import org.buddycloud.sdk.model.Post;
import org.buddycloud.sdk.model.Subscriber;

public interface IBuddycloud {

	public void createAccount(String jid, String password, 
			Callback<Void> success,
			Callback<BuddycloudException> error);
	
	public void setCredentials(String jid, String password);
	
	public void getSubscribers(String channel, String node,
			Callback<RSMList<Subscriber>> success,
			Callback<BuddycloudException> error);
	
	public void getPosts(String channel, String node, 
			Callback<RSMList<Post>> success,
			Callback<BuddycloudException> error);
	
	public void createPost(String channel, String node, 
			Post post, Callback<BuddycloudException> error);
	
	public void registerForNotifications(NotificationSettings settings, 
			Callback<Void> success,
			Callback<BuddycloudException> error);
	
}

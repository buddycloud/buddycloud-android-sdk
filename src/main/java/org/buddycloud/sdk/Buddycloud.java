package org.buddycloud.sdk;

import org.buddycloud.sdk.model.NotificationSettings;
import org.buddycloud.sdk.model.Post;
import org.buddycloud.sdk.model.Subscriber;

public class Buddycloud implements IBuddycloud {

	private Buddycloud() {
	}

	/**
	 * @return a new instance of Buddycloud. The Buddycloud class abstracts
	 *         communication and the discovery process for Buddycloud API.
	 */
	public static Buddycloud create() {
		return new Buddycloud();
	}

	@Override
	public void createAccount(String jid, String password,
			Callback<Void> success, Callback<BuddycloudException> error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCredentials(String jid, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSubscribers(String channel, String node,
			Callback<RSMList<Subscriber>> success,
			Callback<BuddycloudException> error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPosts(String channel, String node,
			Callback<RSMList<Post>> success, Callback<BuddycloudException> error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPost(String channel, String node, Post post,
			Callback<BuddycloudException> error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerForNotifications(NotificationSettings settings,
			Callback<Void> success, Callback<BuddycloudException> error) {
		// TODO Auto-generated method stub
		
	}


}

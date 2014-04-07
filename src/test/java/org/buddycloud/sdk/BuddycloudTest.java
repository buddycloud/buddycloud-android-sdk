package org.buddycloud.sdk;

import org.buddycloud.sdk.model.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BuddycloudTest {

	@Test
	public void testSubscribers() throws InterruptedException {
		Buddycloud bc = Buddycloud.create();
		bc.setCredentials("abmargb@buddycloud.org", "password");
		bc.getSubscribers("lounge@topics.buddycloud.org", "posts",
				new Callback<RSMList<Subscriber>>() {

					public void complete(RSMList<Subscriber> response) {
						for (Subscriber subscriber : response.getContent()) {
							System.out.println(subscriber.getJid() + " "
									+ subscriber.getAffiliation());
						}
					}

				}, new Callback<BuddycloudException>() {

					public void complete(BuddycloudException e) {
						e.printStackTrace();
					}
				});
		
		Thread.sleep(5000);
	}

}

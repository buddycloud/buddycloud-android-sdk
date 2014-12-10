#Buddycloud SDK Design Thinking

##Setup

1. `git clone git@github.com:buddycloud/buddycloud-android-sdk.git`
2. Import the code into your Android Workspace: `File` > `Import...` > `Android` > `Existing Code into Android Workspace`
3. Add the Buddycloud project as a library project to the App that you wish to Buddycloud enable: `Properties` > `Android` > `Library` > `Add`
4. Add the following two lines of code in your AndroidManifest.xml:
```xml
<activity android:name="com.buddycloud.sdk......"
    android:theme="@android:style/Theme.NoTitleBar" />
```

##Configuration

You already have the SDK installed integrated into your project.
Now you will configure it to fit your needs to the extent possible.
SDKs usually require API keys or Authentication tokens in this step, as well as allow a series of handful configuration options.
In Buddycloud's case, there's no need for API keys.
You may want to hard-code and talk to a particular Buddycloud domain but you don't really have to know which domain you're talking to in order to get started.

What kinds of configuration values you absolutely require in order to use Buddycloud and add messaging into your app?
What kinds of use case scenarios are out there?

Well, there are as many use cases as there are stars in the sky at night. But as it turns out, there's no single configuration value that is absolutely needed for a user to add messaging into their Buddycloud app, as we can always default communication to, say, `buddycloud.org`. Thus we can use its API endpoint to pretty much do everything we need.

The SDK users are the app developers themselves.

* Bear in mind that they might not know exactly what Buddycloud is.
* We're assuming their most basic need is to add messaging to their app. This has top priority.

With both points in mind, once the developer has properly integrated the SDK into their project, they MUST be good to go: no need to setup a domain through our hosting service or anything, or even a Buddycloud account prior to running their  Buddycloud-powered app for the first time, as it must be possible to create an account (registered in `buddycloud.org` on the fly) as they try it for the first time.

So for the configuration step, they can simply do:

```java
public void onCreate() {
    Buddycloud.initialize(this);
}
```

Optionally, users can also define `BUDDYCLOUD_DOMAIN`, the Buddycloud domain they want to use:

```java
public void onCreate() {
    BuddycloudConfiguration cfg = new BuddycloudConfiguration();
    cfg.add(BuddycloudConfiguration.BUDDYCLOUD_DOMAIN, "your.own.bc.domain");
    Buddycloud.initialize(this, cfg.build());
}
```

As stated before, if this is ommited, it defaults to `buddycloud.org`.

Another optional advanced feature is to hard-code the `BUDDYCLOUD_API_ENDPOINT` they will use (this is optional because the default one used is the `BUDDYCLOUD_DOMAIN`'s one, automagically discovered by the SDK):

```java
public void onCreate() {
    BuddycloudAPIEndpoint apiEndpoint = new BuddycloudAPIEndpoint();
    apiEndpoint.add(BuddycloudAPIEndpoint.PROTOCOL, "https");
    apiEndpoint.add(BuddycloudAPIEndpoint.HOST, "your.own.bc.domain");
    apiEndpoint.add(BuddycloudAPIEndpoint.PORT, 443);
    apiEndpoint.add(BuddycloudAPIEndpoint.PATH, "/api");
    apiEndpoint.add(BuddycloudAPIEndpoint.VERSION, "1.0");
    BuddycloudConfiguration cfg = new BuddycloudConfiguration();
    cfg.add(BuddycloudConfiguration.BUDDYCLOUD_API_ENDPOINT, apiEndpoint.build());
    Buddycloud.initialize(this, cfg.build());
}
```

#Buddycloud SDK Design Thinking

##Setup

####Download & unzip the SDK
> *Notice:* SDK download link shall be here. It has not been released yet; please wait! :)

####Integrate SDK into your App
Import the zip file's contents into the existing Android project you wish to Buddycloud enable by extracting it into the project's `libs` folder. If your project does not already have a `libs` folder, create one at the root of the project by right-clicking the project and choosing `New` and then `Folder`.

####Manifest that your App is Buddycloud enabled
You will need to perform the following updates to your `AndroidManifest.xml`.

Add the following broadcast receiver definition to `AndroidManifest.xml` immediately before the closing `</application>` tag:

```xml
<receiver android:name="com.buddycloud.sdk.GcmBroadcastReceiver"
    android:permission="com.google.android.c2dm.permission.SEND">
  <intent-filter>
    <action android:name="com.google.android.c2dm.intent.RECEIVE" />
    <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
 
    <!--
      IMPORTANT: Change "com.example.app" to match your app's package name.
    -->
    <category android:name="com.example.app" />
  </intent-filter>
</receiver>
```
Make sure you change the `android:name` attribute of `<category>` element above to match your application's package name.

> *Notice:* The receiver's configuration is not completely determined, as I'll need to dive deeper into the HTTP API's relationship with the Pusher service and how to properly configure clients to receive the push notifications from that service. This code snippet above is very much likely going to change.

Then go ahead and add the permissions below, typically immediately before the opening `<application>` tag:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.VIBRATE" />
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
<uses-permission android:name="android.permission.GET_ACCOUNTS" />
<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
 
<!--
  IMPORTANT: Change "com.example.app.permission.C2D_MESSAGE" in the lines below
  to match your app's package name + ".permission.C2D_MESSAGE".
-->
<permission android:protectionLevel="signature"
    android:name="com.example.app.permission.C2D_MESSAGE" />
<uses-permission android:name="com.example.app.permission.C2D_MESSAGE" />
```

Finally, change the `android:name` attribute in the last two lines of the snippet above to match your application's package name.

If you are in a hurry to see this working, you can simply know you need no more configuration and are good to go in order to add messaging to your app! Perform the single step below and skip the whole Configuration section.

You can simply initialize the SDK using the `initialize()` call (it is recommended you place this call inside your main `Activity`'s `onCreate()` method):

```java
public void onCreate() {
    Buddycloud.initialize(this);
}
```

##Configuration

You already have the SDK installed integrated into your project.
Now you will configure it to fit your needs to the extent possible.
SDKs usually require API keys or Authentication tokens in this step, as well as a series of configuration options.
In Buddycloud's case, there's no need for API keys.
You may want to hard-code and talk to a particular Buddycloud domain but you don't really have to know which domain you're talking to in order to get started.

> What kinds of configuration values you absolutely require in order to use Buddycloud and add messaging into your app?
> What kinds of use case scenarios are out there?
> 
> Well, there are as many use cases as there are stars in the sky at night. But as it turns out, there's no single configuration value that is absolutely needed for a user to add messaging into their Buddycloud app, as we can always default communication to, say, `buddycloud.org`. Thus the SDK can use its API endpoint to pretty much do everything we need.
> 
> The SDK users are the app developers themselves.
> 
> * Bear in mind that they might not know exactly what Buddycloud is.
> * We're assuming their most basic need is to add messaging to their app. This has top priority.
> 
> With both points in mind, once the developer has properly integrated the SDK into their project, they MUST be good to go: no need to setup a domain through our hosting service or anything, or even a Buddycloud account prior to running their  Buddycloud-powered app for the first time, as it must be possible to create an account (registered in `buddycloud.org` on the fly) as they try it for the first time.

So without any further configuration, you can simply initialize the SDK using the `initialize()` call (it is recommended you place this call inside your main `Activity`'s `onCreate()` method):

```java
public void onCreate() {
    Buddycloud.initialize(this);
}
```

Optionally, you could also define `BUDDYCLOUD_DOMAIN`, the Buddycloud domain you want to use (you can use our [hosting service](https://hosting.buddycloud.com/login) to get a free Buddycloud domain, for example):

```java
public void onCreate() {
    BuddycloudConfiguration cfg = new BuddycloudConfiguration();
    cfg.set(BuddycloudConfiguration.BUDDYCLOUD_DOMAIN, "your.own.bc.domain");
    Buddycloud.initialize(this, cfg);
}
```

As stated before, if this is ommited, it defaults to `buddycloud.org`.

Another optional advanced feature is to hard-code the `BUDDYCLOUD_API_ENDPOINT` you will use (this is optional because the default one used is the `BUDDYCLOUD_DOMAIN`'s one, automagically discovered by the SDK):

```java
public void onCreate() {
    BuddycloudAPIEndpoint apiEndpoint = new BuddycloudAPIEndpoint();
    apiEndpoint.setProtocol("https");          //Default is: http
    apiEndpoint.setHost("your.own.bc.domain"); //Default is: buddycloud.org
    apiEndpoint.setPort(443);                  //Default is: 80
    apiEndpoint.setPath("/api");               //Default is: /api
    BuddycloudConfiguration cfg = new BuddycloudConfiguration();
    cfg.set(BuddycloudConfiguration.BUDDYCLOUD_API_ENDPOINT, apiEndpoint.build());
    Buddycloud.initialize(this, cfg);
}
```
The API Endpoint is the means through which the SDK will talk to Buddycloud so that you can add messaging to your apps.

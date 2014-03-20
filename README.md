Buddycloud Android SDK developed is the first SDK that allows developers to easily interact with the Buddycloud API.

## Features
 1. Discover the API endpoint
 2. Register user
 3. Fetch and create new posts
 4. Edit followers
 5. Manage channels
 6. Post media


## Set-up

 1. Create a Coinbase account and Register an App
 2. `git clone git@github.com:buddycloud/buddycloud-android-sdk.git`
 3.	Import the code into your Android Workspace: File > Import... > Android > Existing Code into Android Workspace
 4.	Add the Buddycloud project as a library project to the App that you wish to Buddycloud enable: Properties > Android > Library > Add
 5. Add the following two lines of code in your manifest file

```xml
<activity android:name="com.buddycloud.sdk......"
	android:theme="@android:style/Theme.NoTitleBar" />
```

## Usage

1. Initialize the SDK, when you initialize your app using the `initialize` API call
2. Set the buddycloud account using the `setBudd......` API call
...


## Testing

During testing you can use the ```buddycloud.org``` domain for testing account activities and check the retults with  [demo.buddycloud.com] (https://demo.buddycloud.com)


## Sample implementation:

```java

public class MainActivity extends Activity implements BuddycloudChannels {


```


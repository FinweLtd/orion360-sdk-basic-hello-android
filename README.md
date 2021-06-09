![alt tag](https://cloud.githubusercontent.com/assets/12032146/18481794/3fda62e0-79e6-11e6-9f00-15bb10c29dd3.png)

# Hello World with Orion360 SDK (Basic) for Android

This repository contains a minimal Hello World -style example of adding 360 video playback capability into an Android application project using Android Studio and Orion360 SDK for Android.

> Before using the SDK, read [Licence Agreement](https://github.com/FinweLtd/orion360-sdk-basic-hello-android/blob/master/Finwe_Orion360_SDK_Basic_Evaluation_Kit_License_en_US-20161212_1500.pdf)

> This application is available in [Google Play](https://play.google.com/store/apps/details?id=fi.finwe.orion360.sdk.basic.hello)

> IMPORTANT NOTE
>
> Starting May 1st, 2021, Bintray is sunsetting their repositories, including the popular jcenter and also Finwe's bintray repository.
>
> Finwe has moved all Orion360 SDK packages from our Bintray maven repositories to GitHub Packages maven repositories.
>
> You need to make a few changes to your build.gradle files as follows:
>
> 1. In your project level build.gradle file
> - Replace references to 'jcenter()' with 'mavenCentral()'
> - Remove this maven repository:
> ```
> maven {
>            url 'https://finwe.bintray.com/orion360-sdk-public' // For Orion360 SDK
>       }
> ```
> - Add this maven repository
> ```
> maven {
>            name = "FinweOrion360SDKPublicMaven"
>            url = uri("https://maven.pkg.github.com/finweltd/orion360-sdk-public-maven")
>            credentials {
>                username = "orion360sdk"
>                password = "\u0067hp_6zjSXtyiCnFn3r6XdlVXpeWmGIMovz2fHHqe"
>            }
>        }
> ```
> - Notice that given credentials are mandatory, as GitHub Packages does not support unauthenticated maven repos.
>
> 2. In your app level build.gradle file
> - Add '-public' to all artifactIds from Finwe repositories
> - For example, replace 
> ```
> implementation 'fi.finwe.orion360:orion360-sdk-basic:1.2.11
> ``` 
> with 
> ```
> implementation 'fi.finwe.orion360:orion360-sdk-basic-public:1.2.11
> ```
>
> That's it. Clean and rebuild your project.

> IMPORTANT NOTE
>
> Starting August 1st, 2019, your apps published on Google Play will need to support 64-bit architectures. 
> 
> You can create a single .apk that contains the usual 32-bit and 64-bit binaries (armeabi-v7a and arm64-v8a) by using Orion360 v. 1.2.11 or later in your gradle file: 
>
>```
>implementation 'fi.finwe.orion360:orion360-sdk-basic:1.2.11'
>```
>
> You can also create separate .apks for 32-bit and 64-bit builds or let Google Play handle delivery of the correct files by using Android App Bundle.
>
> If you still need to support *armeabi*, *mips*, or *x86* targets please use Orion360 v. 1.2.10 to create a separate .apk file for these targets. If you are not sure, then almost certainly you do not need it.
>
> The only difference between Orion360 v. 1.2.10 and v. 1.2.11 is different build targets. There are no API or feature changes.

Table of Contents
-----------------
1. [Prerequisities](#prerequisities)
2. [Cloning the project](#cloning-the-project)
3. [Creating an empty application project](#creating-an-empty-application-project)
4. [Acquiring Orion360 SDK binaries](#acquiring-orion360-sdk-binaries)
5. [Adding OrionVideoView to the XML layout](#adding-orionvideoview-to-the-xml-layout)
6. [Writing Java code](#writing-java-code)
7. [Adding Android permissions](#adding-android-permissions)
8. [Acquiring Orion360 SDK license file](#acquiring-orion360-sdk-license-file)
9. [Running the application](#running-the-application)
10. [What next?](#what-next)

Prerequisities
--------------

Install Android Studio IDE (recommended version is 2.2 or newer):
https://developer.android.com/studio/install.html

Then, using the SDK Manager tool, install one or more Android SDKs. Notice that for Orion360 SDK Basic, minimum API level is 14: Android 4.0 IceCreamSandwich.

For accessing GitHub repositories, check that you have Git (open console and type 'git') or install it and restart Android Studio:
https://git-scm.com

Cloning the project
-------------------

> You can either create the project from scratch by following the instructions below, or clone the ready project from GitHub as explained here.

To clone the project from GitHub, start Android Studio, select "Check out project from Version Control" and "Git" from the popup dialog.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18509522/bea74c6e-7a81-11e6-8235-03e809c49b68.png)

Set repository URL, parent directory, and project directory. 

Notice that the repository URL is easy to copy-paste from browser to Android Studio: click the green "Clone or download" button on the project's GitHub page, copy the URL from the dialog that appears, and paste it to Android Studio's dialog.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18509660/5ce52914-7a82-11e6-821d-43321ef169ee.png)

Cloning the project will take a moment. Android Studio then asks if you want to open the project. Answer "Yes".

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18509742/dc4a0b66-7a82-11e6-9775-392d31487363.png)

The project opens, and Android Studio performs Gradle sync that will take some time (please wait). After Gradle sync finishes, you can find the project files by opening the Project view on the left.

You can now proceed to connecting an Android device to your computer via a USB cable, and then run the app on device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18509763/00ad461c-7a83-11e6-98d9-e15d3b300725.png)


Creating an empty application project
-------------------------------------

Start Android Studio application. From the welcome screen, select 'Start a new Android Studio project'.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169552/4bd00ee2-7063-11e6-8dab-a522b5296b7f.png)

Fill in your application name, company domain, package name, and project location. Click Next button.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169775/5587bfce-7064-11e6-96d7-a36d0db27913.png)

Check that "Phone and Tablet" is selected, and the minimum SDK is at least "API 14: Android 4.0 (IceCreamSandwich)". Click Next.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169873/b96fda80-7064-11e6-8575-329da087c3e6.png)

Choose "Empty Activity". Click Next.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169938/ffe680fe-7064-11e6-9570-ef31edd1d9a1.png)

Accept the default settings for activity name and layout file. Click Finish. New application project will be created.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169985/368fba94-7065-11e6-856f-7a48441cb84a.png)

After a moment of processing, you should see Android Studio IDE with your newly created project files. 

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170077/92465f00-7065-11e6-9bd4-f6d6df12920a.png)

Connect an Android phone or tablet to your computer using a USB cable, and check that developer mode has been enabled: you should find "Developer options" under your device's Settings view. If not, navigate to Settings > About phone > Build number, and tap the section 7 times to become a developer.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170397/ddcf201e-7066-11e6-8de8-59cb7492b595.png)

From Android Studio menu, select Run > Run 'app', and when the 'Select Deployment Target' dialog appears, check that your device shows up in the "Connected Devices" list, and is selected. Click OK. The application will be built and deployed to your device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170461/1e6c8030-7067-11e6-8c17-8b3bce493e81.png)

After a moment of processing, the app should start on your Android device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170531/4d2277fe-7067-11e6-816b-97b1d4a15b60.png)

Acquiring Orion360 SDK binaries
-------------------------------

Now that the application project skeleton is working, let's add 360 video playback capability using Orion360 SDK.

First, we need to acquire Orion360 SDK binaries. To make this super easy for developers, we distribute them via our public repository at bintray.com. Let's add the repository to the project.

In Android Studio's Project view, expand Gradle Scripts and double click build.gradle file for the Project.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170765/35fe720c-7068-11e6-947d-364d53b1a043.png)

Find section 'allprojects' and add the following line inside 'repositories':

```gradle
maven { url 'https://finwe.bintray.com/orion360-sdk-public' } // For Orion360 SDK
```

After editing a gradle file, the IDE suggests to sync the project. Accept the suggestion, or click the Sync button from the toolbar.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171065/4e2430aa-7069-11e6-8811-fcbbec81e86f.png)

After gradle sync has finished, in Android Studio's Project view, double click build.gradle file for the app module. Find section 'dependencies', and add the following line inside it:

```gradle
compile 'fi.finwe.orion360:orion360-sdk-basic:1.2.00' // From Finwe maven repo at Bintray
```

After editing a gradle file, the IDE suggests to sync the project. Accept the suggestion, or click the Sync button from the toolbar.

Notice that here we will use version '1.2.00' of the SDK binaries. When new versions are released, you can simply type here the version number that you wish to use in your project. Upgrading to the latest Orion360 version requires nothing more than changing the version number, performing gradle sync, and rebuilding the app (unless there are API changes).

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171532/0f740f72-706b-11e6-8cce-ca475b58a332.png)

Now we can use Orion360 SDK in the project. 

Adding OrionVideoView to the XML layout
---------------------------------------

In Android Studio's Project view, expand res > layout and double click activity_main.xml. Select 'Text' pane to hide the designer and show the layout's XML code. Then, above TextView item, add the following lines:

```xml
<fi.finwe.orion360.OrionVideoView
  android:id="@+id/orion_video_view"
  android:layout_width="match_parent"
  android:layout_height="match_parent" />
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171902/39551fc4-706c-11e6-919d-8ab34323f89d.png)

If you now switch back to 'Design' tab, you can see that the video view will expand to fill the layout.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171955/68955dee-706c-11e6-8d00-690fea36c5ef.png)

Writing Java code
-----------------

In Android Studio's Project view, expand java > [package name] and double click MainActivity. 

Add a class member variable for the video view, and press ALT+ENTER when Android Studio suggests to import the missing class (fi.finwe.orion360.OrionVideoView).

```java
private OrionVideoView mOrionVideoView;
```

Then append to onCreate() method a line to retrieve the video view object that we defined in the activity's XML layout:

```java
mOrionVideoView = (OrionVideoView) findViewById(R.id.orion_video_view);
```

Preparing a video for playback always takes a moment, therefore we need to become a listener for a callback that tells when the video player is ready. When the callback comes, we can start the player.

```java
mOrionVideoView.setOnPreparedListener(new OrionVideoView.OnPreparedListener() {
  @Override
  public void onPrepared(OrionVideoView orionVideoView) {
    mOrionVideoView.start();
  }
});
```

You can play a 360 video file by calling the prepare() method. When called, Orion360 SDK will first check if a valid license file is available, and then proceed to preparing the video player. When done, onPrepared() will be called - and the playback begins, as we have requested above.

```java
try {
  mOrionVideoView.prepare("https://s3.amazonaws.com/orion360-us/Orion360_test_video_2d_equi_360x180deg_1920x960pix_30fps_30sec_x264.mp4");
} catch (OrionVideoView.LicenseVerificationException e) {
  Log.e("OrionVideoView", "Orion360 SDK license could not be verified!", e);
}
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18172784/8fd0f53c-706f-11e6-895f-f8e137e0c30a.png)

Finally, we need to let the video player to respond to the activity's life cycle events, so that it can automatically pause and resume along the activity, and clean up when the activity gets destroyed. Let's propagate them to the video view as follows:

```java
    @Override
    public void onStart() {
        super.onStart();

        mOrionVideoView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        mOrionVideoView.onResume();
    }

    @Override
    public void onPause() {
        mOrionVideoView.onPause();

        super.onPause();
    }

    @Override
    public void onStop() {
        mOrionVideoView.onStop();

        super.onStop();
    }

    @Override
    public void onDestroy() {
        mOrionVideoView.onDestroy();

        super.onDestroy();
    }
```

Now we have written all Java code that is required for a basic 360 video player.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18172876/f9ef3924-706f-11e6-9829-fc5e418486fe.png)

Adding Android permissions
--------------------------

Since we are going to stream a video file from the network, we must add INTERNET permission to the application project's manifest file, as usual. In Android Studio's Project view, expand app > manifests, and double click AndroidManifest.xml. Then add the following line above 'application' section:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173579/c98d8706-7072-11e6-8d7c-5c9aecf39abf.png)

Acquiring Orion360 SDK license file
-----------------------------------

As Orion360 SDK is a commercial product, it requires a license file to work. In order to get a license file for your own app, you need to buy the SDK. Your license file will be locked to the package name you have selected for your app. To apply the license file, in the Android Studio's Project view, create a directory 'assets' under the 'app' root, and download and copy the license file there.

However, to continue evaluating the SDK with the hello app, you can use the (watermarked) license file that is provided with this tutorial. Following the instructions above, download and copy this file under your project's /assets folder:

[Orion Hello License File](app/src/main/assets/fi.finwe.orion360.sdk.basic.hello.key.lic)

> **NEW: You can now get a watermarked evaluation license file also for your own package name by creating an account to https://store.make360app.com, starting a new SDK project, providing your own package name, and selecting FREE Trial.**

> **Notice that the license file is a simple text file, but since it is signed, any kind of editing makes it invalid. Especially, watch out line endings - file editors, version control software and copy-paste operation may silently convert between CR/LF and LF characters, and even though the file looks exactly the same, it isn't!**

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173330/e3fb482c-7071-11e6-9056-0d0cbba3c17a.png)

Running the application
-----------------------

Now we are ready to try the app on device. From Android Studio menu, select Run > Run 'app', and when the 'Select Deployment Target' dialog appears, check that your device shows up in the "Connected Devices" list, and is selected. Click OK. The application will be built and deployed to your device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173844/e18644f0-7073-11e6-84ea-82275531210e.png)

The application begins to stream the video file from network, and when the media player has buffered enough content, video starts to play on screen. Since this is a 360 video, you can look around: try out panning by rotating the device around you or by pulling the image with a finger. Use 2-finger pinch and rotate to zoom and rotate the image, respectively.

In just a few minutes, you have created your own 360 video player app that can play equirectangular MP4 video files from the network and supports gyro and touch panning, as well as pinch zooming and rotating. Pretty cool, ha?

What next?
----------

You have barely scratched the surface! To learn more about the Orion360 SDK, clone the Orion360 SDK example app from the following Github repository, and open the project in Android Studio. Go through the examples to learn how to play videos and images from different locations, apply VR mode, add interactive hotspots, and lots of other cool features.

https://github.com/FinweLtd/orion360-sdk-basic-examples-android

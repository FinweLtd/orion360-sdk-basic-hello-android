# Hello World with Orion360 SDK (Basic) for Android

This repository contains a minimal Hello World -style example of adding 360 video playback capability into an Android application project using Android Studio and Orion360 SDK for Android.

Prerequisities
--------------

Install Android Studio IDE (recommended version is 2.2 or newer):
https://developer.android.com/studio/install.html

Then, using the SDK Manager tool, install one or more Android SDKs. Notice that for Orion360 SDK Basic, minimum API level is 14: Android 4.0 IceCreamSandwitch.

Creating an empty application project
-------------------------------------

Start Android Studio application. From the welcome screen, select 'Start a new Android Studio project'.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169552/4bd00ee2-7063-11e6-8dab-a522b5296b7f.png)

Fill in your application name, company domain, package name, and project location. Click Next button.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18169775/5587bfce-7064-11e6-96d7-a36d0db27913.png)

Check that "Phone and Tablet" is selected, and the minimum SDK is at least "API 14: Android 4.0 (IceCreamSandwitch)". Click Next.

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

Adding 360 video playback capability
------------------------------------

Now that the application project skeleton is working, let's add 360 video playback capability using Orion360 SDK.

First, we need to acquire Orion360 SDK binaries. To make this super easy for developers, we distribute them via our public repository at bintray.com. Let's add the repository to the project.

In Android Studio's Project view, expand Gradle Scripts and double click build.gradle file for the Project.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18170765/35fe720c-7068-11e6-947d-364d53b1a043.png)

Find section 'allprojects' and add the following line inside 'repositories':

```
maven { url 'https://finwe.bintray.com/orion360-sdk-public' } // For Orion360 SDK
```

After editing a gradle file, the IDE suggests to sync the project. Accept the suggestion, or click the Sync button from the toolbar.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171065/4e2430aa-7069-11e6-8811-fcbbec81e86f.png)


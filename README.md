# SilentInstall
android 9.0 silent install apk (like app store) , without root, but need system signature.

###### Useful code(class):
1. InstallUtils
2. InstallResultReceiver
3. IoUtils

###### Call method:
```java
InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);
```

Permission:
```java
<uses-permission android:name="android.permission.INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
````


--------
This is the code for silent installation (upgrade) of APK for Android 9.0, similar to the app store that comes with the phone. Do not need root, but need the system signature, has been tested can be used, my side got mtk tablet test OK.

###### code from the following 2 articles.
(1) https://blog.csdn.net/Cailand/article/details/103870295
(2) https://www.jianshu.com/p/cd10d5278ebf


###### where the useful code is.
1. InstallUtils class
2. InstallResultReceiver class
3. IoUtils class

###### When used, it is called directly like this.
```java
InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);
```

Permissions added.
```java
<uses-permission android:name="android.permission.INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
````

###### For system signatures, please refer to this document.
https://www.jianshu.com/p/63d699cffa1a

Note that AndroidManifest.xml adds this declaration
```java
android:sharedUserId= "android.uid.system"
```

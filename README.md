# SilentInstall
android 9.0 silent install apk （like app store) , without root, but need system signature.

Useful code(class):
（1）InstallUtils 
（2）InstallResultReceiver
（3）IoUtils

Call method:
InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);

Permission:
<uses-permission android:name="android.permission.INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />


######
这是适用于安卓9.0版本静默安装（升级）APK的代码，类似于手机自带的应用商店。不需要root，但是需要系统签名，已实测可以用，我这边拿到的是mtk平板
代码源于以下2个文章，综合使用：
（1）https://blog.csdn.net/Cailand/article/details/103870295
（2）https://www.jianshu.com/p/cd10d5278ebf

其中有用的代码就是：
（1）InstallUtils类
（2）InstallResultReceiver类
（3）IoUtils类

用的时候直接这样调用：InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);

权限添加：
<uses-permission android:name="android.permission.INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

系统签名，请参考这篇文档：
https://www.jianshu.com/p/63d699cffa1a

注意 AndroidManifest.xml 增加这个申明
android:sharedUserId= "android.uid.system"

 

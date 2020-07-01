/*
这是适用于安卓9.0版本静默安装（升级）APK的代码，不需要root，但是需要系统签名，已实测可以用，我这边拿到的是mtk平板
代码源于以下2个文章，综合使用：
（1）https://blog.csdn.net/Cailand/article/details/103870295
（2）https://www.jianshu.com/p/cd10d5278ebf

其中有用的代码就是：
（1）InstallUtils类
（2）InstallResultReceiver类
（3）IoUtils类

使用：InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);

权限：
<uses-permission android:name="android.permission.INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

系统签名，请参考这篇文档：
https://www.jianshu.com/p/63d699cffa1a

注意 AndroidManifest.xml 申明
android:sharedUserId= "android.uid.system"

 */

package com.diuber.silentinstalldemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "测试安装APK", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //请替换为你的APK路径
                InstallUtils.install28(MainActivity.this,"/sdcard/xxx.apk",InstallResultReceiver.class);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
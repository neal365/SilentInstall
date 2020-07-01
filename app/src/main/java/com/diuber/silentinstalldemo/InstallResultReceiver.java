package com.diuber.silentinstalldemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.util.Log;

public class InstallResultReceiver extends BroadcastReceiver {
    private String TAG = InstallResultReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            final int status = intent.getIntExtra(PackageInstaller.EXTRA_STATUS,
                    PackageInstaller.STATUS_FAILURE);
            String packageName = null;
            try {
                packageName = intent.getData().getSchemeSpecificPart();
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.e(TAG, "action="+intent.getAction()+" ,status="+status);
            if (status == PackageInstaller.STATUS_SUCCESS) {
                // success
                Log.e(TAG, packageName + " install success, msg: "+intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE));
            } else {
                Log.e(TAG, packageName + " install filed, msg: "+intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE));
            }
        }
    }
}

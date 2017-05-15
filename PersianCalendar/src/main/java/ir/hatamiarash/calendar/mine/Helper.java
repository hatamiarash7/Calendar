/*
 * Copyright (c) 2017 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.calendar.mine;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import ir.hatamiarash.calendar.R;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static boolean CheckInternet(Context context) { // check network connection for run from possible exceptions
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        PackageManager PM = context.getPackageManager();
        if (PM.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
                return true;
        } else {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
                return true;
        }
        Helper.MakeToast(context, "اتصال به اینترنت را بررسی نمایید", TAGs.WARNING);
        return false;
    }

    public static void MakeToast(Context context, String Message, String TAG) {
        if (TAG.equals(TAGs.WARNING))
            CustomToast.custom(context, Message, R.drawable.ic_alert, ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.Amber), Toast.LENGTH_SHORT, true, true).show();
        if (TAG.equals(TAGs.SUCCESS))
            CustomToast.custom(context, Message, R.drawable.ic_success, ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.Green), Toast.LENGTH_SHORT, true, true).show();
        if (TAG.equals(TAGs.ERROR))
            CustomToast.custom(context, Message, R.drawable.ic_error, ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.Red), Toast.LENGTH_SHORT, true, true).show();
    }

    static public void GetPermissions(Activity activity, Context context) {
        final int REQUEST_ID_MULTIPLE_PERMISSIONS = 4611;

        int location2 = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        int location = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION);
        int network = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE);
        int bluetooth = ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);
        int internet = ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET);
        int vibration = ContextCompat.checkSelfPermission(context, Manifest.permission.VIBRATE);
        int call = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);
        int read_storage = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write_storage = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int contact = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (location != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        if (location2 != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        if (network != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.ACCESS_NETWORK_STATE);
        if (bluetooth != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.BLUETOOTH);
        if (internet != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.INTERNET);
        if (vibration != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.VIBRATE);
        if (call != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        if (read_storage != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        if (write_storage != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (contact != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.READ_CONTACTS);

        if (!listPermissionsNeeded.isEmpty())
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
    }
}
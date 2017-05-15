/*
 * Copyright (c) 2017 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.calendar.mine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import ir.hatamiarash.calendar.R;

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
}
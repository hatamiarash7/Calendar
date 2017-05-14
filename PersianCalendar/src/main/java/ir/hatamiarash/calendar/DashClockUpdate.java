package ir.hatamiarash.calendar;

import com.google.android.apps.dashclock.api.DashClockExtension;

import ir.hatamiarash.calendar.util.UpdateUtils;

public class DashClockUpdate extends DashClockExtension {

    @Override
    protected void onUpdateData(int reason) {
        setUpdateWhenScreenOn(true);
        UpdateUtils updateUtils = UpdateUtils.getInstance(getApplicationContext());
        updateUtils.update(false);
        publishUpdate(updateUtils.getExtensionData());
    }
}
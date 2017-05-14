package ir.hatamiarash.calendar;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import ir.hatamiarash.calendar.service.ApplicationService;
import ir.hatamiarash.calendar.util.UpdateUtils;
import ir.hatamiarash.calendar.util.Utils;

public class Widget1x1 extends AppWidgetProvider {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Utils.getInstance(context).isServiceRunning(ApplicationService.class))
            context.startService(new Intent(context, ApplicationService.class));
        UpdateUtils.getInstance(context).update(true);
    }
}
package ch.acra.acralyzercompanion;
/*
 Copyright 2013 Kevin Gaudin (kevin.gaudin@gmail.com)

 This file is part of AcralyzerCompanion.

 AcralyzerCompanion is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 AcralyzerCompanion is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with AcralyzerCompanion.  If not, see <http://www.gnu.org/licenses/>.
*/

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

import ch.acra.acralyzercompanion.service.AcralyzerPollingService;
import secret.Credentials;

@ReportsCrashes(formKey = "", httpMethod = HttpSender.Method.PUT,
        reportType = HttpSender.Type.JSON,
        formUri = "http://ovh.acralyzer.com/acra-acralyzer_companion/_design/acra-storage/_update/report",
        formUriBasicAuthLogin = Credentials.ACRALOGIN,
        formUriBasicAuthPassword = Credentials.ACRAPASSWORD,
        resToastText = R.string.acra_toast,
        sendReportsInDevMode = true,
        mode = ReportingInteractionMode.TOAST)
public class AcralyzerCompanionApplication extends Application {

    private static final String TAG = "AcralyzerCompanionApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
        scheduleServices(this);
    }

    public static void scheduleServices(Context context) {
        Log.w(TAG, "scheduling service...");
        Intent iStartService = new Intent(context, AcralyzerPollingService.class);
        PendingIntent piStartService = PendingIntent.getService(context, 0, iStartService, 0);
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +
                60 * 1000, AlarmManager.INTERVAL_HALF_HOUR / 60, piStartService);

    }
}

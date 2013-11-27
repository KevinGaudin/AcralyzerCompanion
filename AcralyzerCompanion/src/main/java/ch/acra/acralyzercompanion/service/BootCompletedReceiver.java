package ch.acra.acralyzercompanion.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ch.acra.acralyzercompanion.AcralyzerCompanionApplication;

public class BootCompletedReceiver extends BroadcastReceiver {

    final static String TAG = "BootCompletedReceiver";

    @Override
    public void onReceive(Context context, Intent arg1) {
        AcralyzerCompanionApplication.scheduleServices(context);
    }
}
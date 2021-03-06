package ch.acra.acralyzercompanion.service;/*
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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import ch.acra.acralyzercompanion.controller.ReportsController;

public class AcralyzerPollingService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        // No binding here.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ReportsController.testDbConnection();
        return super.onStartCommand(intent, flags, startId);
    }
}

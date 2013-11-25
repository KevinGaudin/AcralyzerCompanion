package com.example.acralyzercompanion;
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

import android.app.Application;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

@ReportsCrashes(formKey = "", httpMethod = HttpSender.Method.PUT,
        reportType = HttpSender.Type.JSON,
        formUri = "http://ovh.acralyzer.com/acra-acralyzer_companion/_design/acra-storage/_update/report",
        formUriBasicAuthLogin = "companionreporter",
        formUriBasicAuthPassword = "acralyzercompanion")
public class AcralyzerCompanionApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}

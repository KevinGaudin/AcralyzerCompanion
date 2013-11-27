package ch.acra.acralyzercompanion.controller;/*
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

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.DbAccessException;
import org.ektorp.UpdateConflictException;
import org.ektorp.android.http.AndroidHttpClient;
import org.ektorp.android.util.EktorpAsyncTask;
import org.ektorp.http.HttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;

import ch.acra.acralyzercompanion.model.ReportSummaryRepository;
import secret.Credentials;

public class ReportsController {

    public static void testDbConnection() {
        try {
            final HttpClient authenticatedHttpClient = new AndroidHttpClient.Builder()
                    .url("http://ovh.acralyzer.com:80")
                    .username(Credentials.TESTLOGIN)
                    .password(Credentials.TESTPASSWORD)
                    .build();

            final CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);
            final CouchDbConnector db = dbInstance.createConnector("acra-acralyzer_companion", false);
            EktorpAsyncTask createItemTask = new EktorpAsyncTask() {

                @Override
                protected void doInBackground() {
                    ReportSummaryRepository reportSummaryRepository = new ReportSummaryRepository(db);
                    System.out.println(reportSummaryRepository.getLatest().size() + " reports fetched.");
                }

                @Override
                protected void onSuccess() {
                    System.out.println("Documents fetched successfully");
                }

                @Override
                protected void onUpdateConflict(UpdateConflictException updateConflictException) {
                    System.out.println("Got an update conflict");
                }

                @Override
                protected void onDbAccessException(DbAccessException dbAccessException) {
                    System.out.println("DbAccessException in background");
                    dbAccessException.printStackTrace();
                }
            };
            createItemTask.execute();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

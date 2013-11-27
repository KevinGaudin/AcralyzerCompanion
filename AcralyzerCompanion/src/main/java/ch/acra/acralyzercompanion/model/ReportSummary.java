package ch.acra.acralyzercompanion.model;/*
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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.ektorp.support.*;

import java.util.Date;

public class ReportSummary extends CouchDbDocument {
    private Date userCrashDate;
    private String androidVersion;
    private String applicationVersionName;
    private String installationId;
    private String device;

    class Signature {
        String full;
        String digest;

        public String getRootCause() {
            return rootCause;
        }

        public void setRootCause(String rootCause) {
            this.rootCause = rootCause;
        }

        String rootCause;

        public Signature() {

        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }
    }

    private Signature signature;

    @JsonProperty("signature")
    public Signature getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    @JsonProperty("user_crash_date")
    public Date getUserCrashDate() {
        return userCrashDate;
    }

    @JsonProperty("user_crash_date")
    public void setUserCrashDate(Date userCrashDate) {
        this.userCrashDate = userCrashDate;
    }

    @JsonProperty("android_version")
    public String getAndroidVersion() {
        return androidVersion;
    }

    @JsonProperty("android_version")
    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    @JsonProperty("application_version_name")
    public String getApplicationVersionName() {
        return applicationVersionName;
    }

    @JsonProperty("application_version_name")
    public void setApplicationVersionName(String applicationVersionName) {
        this.applicationVersionName = applicationVersionName;
    }

    @JsonProperty("installation_id")
    public String getInstallationId() {
        return installationId;
    }

    @JsonProperty("installation_id")
    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }
}

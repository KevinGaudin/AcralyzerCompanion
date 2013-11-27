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

import org.ektorp.support.*;
import org.ektorp.*;

import java.util.List;

public class ReportSummaryRepository extends CouchDbRepositorySupport<ReportSummary> {

    public ReportSummaryRepository(CouchDbConnector db) {
        super(ReportSummary.class, db, "acra-storage");
        initStandardDesignDocument();
    }

    public List<ReportSummary> getLatest() {
        ViewQuery q = createQuery("recent-items").descending(true).limit(10);
        return db.queryView(q, ReportSummary.class);
    }
}

package com.chaupha.blacksocial;

import com.chaupha.blacksocial.managers.DatabaseHelper;

public class ApplicationHelper {

    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public static void initDatabaseHelper(android.app.Application application) {
        databaseHelper = DatabaseHelper.getInstance(application);
        databaseHelper.init();
    }

}

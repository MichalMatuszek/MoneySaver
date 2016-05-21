package pl.mmatuszek.moneysaver.contract.util.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Michal on 2016-05-21.
 */
public class DbContext extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Costs.db";
    public static final int DATABASE_VERSION = 1;

    public DbContext(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion)
        {

        }
    }
}

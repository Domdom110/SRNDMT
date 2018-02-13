package com.example.mortonthompsond2.srndmt;

/**
 * Created by mortonthompsond2 on 2/1/2018.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "srndmt.db";

    public DBHandler(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_User = "CREATE TABLE " + User.TABLE  + "("
                + User.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + User.KEY_name + " TEXT, "
                + User.KEY_age + " INTEGER, "
                + User.KEY_email + " TEXT )";

        db.execSQL(CREATE_TABLE_User);

        String CREATE_TABLE_Manager = "CREATE TABLE " + Manager.TABLE  + "("
                + Manager.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Manager.KEY_name + " TEXT, "
                + Manager.KEY_age + " INTEGER, "
                + Manager.KEY_email + " TEXT )";

        db.execSQL(CREATE_TABLE_Manager);

        String CREATE_TABLE_Workouts = "CREATE TABLE " + Workouts.TABLE  + "("
                + Workouts.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Workouts.KEY_name + " TEXT, "
                + Workouts.KEY_description + " TEXT, "
                + Workouts.KEY_type + " TEXT )";

        db.execSQL(CREATE_TABLE_Workouts);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Manager.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Workouts.TABLE);

        // Create tables again
        onCreate(db);

    }

}



/*
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.Contacts.SettingsColumns.KEY;
import static java.sql.Types.INTEGER;
import static org.xmlpull.v1.XmlPullParser.TEXT;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "srndmtDB";
    // Contacts table name
    private static final String TABLE_User = "Users";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USER_ADDR = "user_address";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_User + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
        + KEY_USER_ADDR + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL(" DROP TABLE IF EXISTS "  + TABLE_User);
// Creating tables again
        onCreate(db);
    }
}
*/
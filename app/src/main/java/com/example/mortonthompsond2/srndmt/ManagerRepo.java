package com.example.mortonthompsond2.srndmt;

/**
 * Created by mortonthompsond2 on 2/12/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerRepo {
    private DBHandler dbHelper;

    public ManagerRepo(Context context) {
        dbHelper = new DBHandler(context);
    }

    public int insert(Manager manager) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.KEY_age, manager.age);
        values.put(User.KEY_email, manager.email);
        values.put(User.KEY_name, manager.name);

        // Inserting Row
        long manager_Id = db.insert(Manager.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) manager_Id;
    }

    public void delete(int manager_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Manager.TABLE, Manager.KEY_ID + "= ?", new String[] { String.valueOf(manager_Id) });
        db.close(); // Closing database connection
    }

    public void update(Manager manager) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.KEY_age, manager.age);
        values.put(User.KEY_email,manager.email);
        values.put(User.KEY_name, manager.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Manager.TABLE, values, Manager.KEY_ID + "= ?", new String[] { String.valueOf(manager.manager_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getManagerList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Manager.KEY_ID + "," +
                Manager.KEY_name + "," +
                Manager.KEY_email + "," +
                Manager.KEY_age +
                " FROM " + Manager.TABLE;

        //User student = new User();
        ArrayList<HashMap<String, String>> managerList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> manager = new HashMap<String, String>();
                manager.put("id", cursor.getString(cursor.getColumnIndex(Manager.KEY_ID)));
                manager.put("name", cursor.getString(cursor.getColumnIndex(Manager.KEY_name)));
                managerList.add(manager);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return managerList;

    }

    public Manager getManagerById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Manager.KEY_ID + "," +
                Manager.KEY_name + "," +
                Manager.KEY_email + "," +
                Manager.KEY_age +
                " FROM " + Manager.TABLE
                + " WHERE " +
                Manager.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Manager manager = new Manager();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                manager.manager_ID =cursor.getInt(cursor.getColumnIndex(Manager.KEY_ID));
                manager.name =cursor.getString(cursor.getColumnIndex(Manager.KEY_name));
                manager.email  =cursor.getString(cursor.getColumnIndex(Manager.KEY_email));
                manager.age =cursor.getInt(cursor.getColumnIndex(Manager.KEY_age));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return manager;
    }

}

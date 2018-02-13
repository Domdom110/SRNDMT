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


public class WorkoutsRepo {

    private DBHandler dbHelper;

    public WorkoutsRepo(Context context) {
        dbHelper = new DBHandler(context);
    }

    public int insert(Workouts workouts) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Workouts.KEY_description, workouts.description);
        values.put(Workouts.KEY_type, workouts.type);
        values.put(Workouts.KEY_name, workouts.name);

        // Inserting Row
        long workouts_Id = db.insert(Workouts.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) workouts_Id;
    }

    public void delete(int workouts_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Workouts.TABLE, Workouts.KEY_ID + "= ?", new String[] { String.valueOf(workouts_Id) });
        db.close(); // Closing database connection
    }

    public void update(Workouts workouts) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Workouts.KEY_description, workouts.description);
        values.put(Workouts.KEY_type, workouts.type);
        values.put(Workouts.KEY_name, workouts.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Workouts.TABLE, values, Workouts.KEY_ID + "= ?", new String[] { String.valueOf(workouts.workouts_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getWorkoutsList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Workouts.KEY_ID + "," +
                Workouts.KEY_name + "," +
                Workouts.KEY_type + "," +
                Workouts.KEY_description +
                " FROM " + Workouts.TABLE;

        //User student = new User();
        ArrayList<HashMap<String, String>> workoutsList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> workouts = new HashMap<String, String>();
                workouts.put("id", cursor.getString(cursor.getColumnIndex(Workouts.KEY_ID)));
                workouts.put("name", cursor.getString(cursor.getColumnIndex(Workouts.KEY_name)));
                workoutsList.add(workouts);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return workoutsList;
    }

    public Workouts getWorkoutsById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Workouts.KEY_ID + "," +
                Workouts.KEY_name + "," +
                Workouts.KEY_type + "," +
               Workouts.KEY_description +
                " FROM " + Workouts.TABLE
                + " WHERE " +
                Workouts.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Workouts workouts = new Workouts();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                workouts.workouts_ID =cursor.getInt(cursor.getColumnIndex(Workouts.KEY_ID));
                workouts.name =cursor.getString(cursor.getColumnIndex(Workouts.KEY_name));
                workouts.type  =cursor.getString(cursor.getColumnIndex(Workouts.KEY_type));
                workouts.description =cursor.getString(cursor.getColumnIndex(Workouts.KEY_description));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return workouts;
    }

}

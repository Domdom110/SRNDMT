package com.example.mortonthompsond2.srndmt;

/**
 * Created by mortonthompsond2 on 2/6/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepo {
    private DBHandler dbHelper;

    public UserRepo(Context context) {
        dbHelper = new DBHandler(context);
    }

    public int insert(User user) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.KEY_age, user.age);
        values.put(User.KEY_email,user.email);
        values.put(User.KEY_name, user.name);

        // Inserting Row
        long user_Id = db.insert(User.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) user_Id;
    }

    public void delete(int user_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(User.TABLE, User.KEY_ID + "= ?", new String[] { String.valueOf(user_Id) });
        db.close(); // Closing database connection
    }

    public void update(User user) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.KEY_age, user.age);
        values.put(User.KEY_email,user.email);
        values.put(User.KEY_name, user.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(User.TABLE, values, User.KEY_ID + "= ?", new String[] { String.valueOf(user.user_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getUserList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                User.KEY_ID + "," +
                User.KEY_name + "," +
                User.KEY_email + "," +
                User.KEY_age +
                " FROM " + User.TABLE;

        //User student = new User();
        ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<String, String>();
                user.put("id", cursor.getString(cursor.getColumnIndex(User.KEY_ID)));
                user.put("name", cursor.getString(cursor.getColumnIndex(User.KEY_name)));
                userList.add(user);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;

    }

    public User getUserById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                User.KEY_ID + "," +
                User.KEY_name + "," +
                User.KEY_email + "," +
                User.KEY_age +
                " FROM " + User.TABLE
                + " WHERE " +
                User.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        User user = new User();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                user.user_ID =cursor.getInt(cursor.getColumnIndex(User.KEY_ID));
                user.name =cursor.getString(cursor.getColumnIndex(User.KEY_name));
                user.email  =cursor.getString(cursor.getColumnIndex(User.KEY_email));
                user.age =cursor.getInt(cursor.getColumnIndex(User.KEY_age));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return user;
    }

}
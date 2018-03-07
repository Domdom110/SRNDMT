package com.example.mortonthompsond2.srndmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class user extends SQLiteOpenHelper {
    SQLiteDatabase mdb;
    //  List<user> users;
    static  int id=0;
    static  String name=null;
    static  String contact=null;
    static ArrayList<String> data = new ArrayList<String>();


    public user(Context context) {
        super(context, "db", null, 1, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + "user" + "("
                + "id" + " INTEGER PRIMARY KEY," + "firstname" + " TEXT,"
                + "lastname" + " TEXT," + "username" +" TEXT," + "password" + " TEXT," + "email" + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void add(String firstname, String lastname,String username,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // values.put("id",123);
        values.put("firstname",firstname); // Contact Name
        values.put("lastname", lastname);
        values.put("username",username); // Contact Name
        values.put("password", password);
        values.put("email", email);// Contact Phone Number

        // Inserting Row
        db.insert("user", null, values);
        db.close();
    }
    public void getuser() {
        SQLiteDatabase db=this.getReadableDatabase();
        try {
            //we used rawQuery(sql, selectionargs) for fetching all the employees
            Cursor cursorEmployees = db.rawQuery("SELECT * FROM user", null);

            //if the cursor has some data
            if (cursorEmployees.moveToFirst()) {
                //looping through all the records
                do {

                    data.add(0,cursorEmployees.getString(4));
                    data.add(0,cursorEmployees.getString(3));
                    data.add(0,cursorEmployees.getString(3));
                    data.add(0,cursorEmployees.getString(2));
                    data.add(0,cursorEmployees.getString(1));
                    data.add(0,String.valueOf(cursorEmployees.getInt(0)));
                    //pushing each record in the employee list
                    id = cursorEmployees.getInt(0);
                    name = cursorEmployees.getString(1);
                    contact = cursorEmployees.getString(2);


                } while (cursorEmployees.moveToNext());
            }
            //closing the cursor
            cursorEmployees.close();
            db.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //creating the adapter object

    }
    public void delete(String id) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+"user"+" where id='"+id+"'");
        db.close();
    }
    public void update(String id,String name)
    {
        ContentValues cv = new ContentValues();
        cv.put("username",name);
        SQLiteDatabase db=this.getWritableDatabase();
        db.update("user",cv,"id="+id,null);
        db.close();
    }

}


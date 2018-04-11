package com.example.mortonthompsond2.srndmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mortonthompsond2 on 4/4/2018.
 */

public class statsDatabase extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "stats.db" ;
    public static final String TABLE_CONTACTS = "userStats" ;
    public static final String ADD_DATE = "addDate" ;
    public static final String ADD_REPETITIONS = "addRepetitions" ;
    public static final String ADD_AMOUNT = "amountOfWeight" ;
    public static final String ADD_NOTES = "addNotes" ;

    public statsDatabase(Context context)
    {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + ADD_DATE + " TEXT," + ADD_REPETITIONS + " TEXT," +
                ADD_AMOUNT + " TEXT," + ADD_NOTES + " TEXT " +  ");" ;

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    void addContact(contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(ADD_DATE,contact.getFirstName());
        values.put(ADD_REPETITIONS,contact.getLastName());
        values.put(ADD_AMOUNT,contact.getEmail());
        values.put(ADD_NOTES,contact.getUserName());

        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }

    contact getContact(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS,new String[] {ADD_DATE,ADD_REPETITIONS,ADD_AMOUNT,ADD_NOTES}, ADD_DATE
                + "=?" , new String[] {String.valueOf(id)},null,null,null,null);

        if(cursor!= null)
        {
            cursor.moveToFirst();
        }

        contact contact = new contact(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        return contact;
    }

    public List<contact> getAllContacts()
    {
        List<contact> contactList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst())
        {
            do{
                contact contact = new contact();

                contact.setFirstName(cursor.getString(0));
                contact.setLastName(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contact.setUserName(cursor.getString(3));

                contactList.add(contact);
            }while(cursor.moveToNext());

        }
        return contactList;
    }

    public int updateContact(String firstName, String lastName,String email,String userName)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ADD_DATE,firstName);
        values.put(ADD_REPETITIONS,lastName);
        values.put(ADD_AMOUNT,email);
        values.put(ADD_NOTES,userName);

        return db.update(TABLE_CONTACTS,values, ADD_DATE + "=?" ,
                new String[]{firstName});
    }

    public void deleteContact(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONTACTS, ADD_DATE + " = ?" ,
                new String[]{id});

        db.close();
    }

    public int getContactsCount()
    {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        cursor.close();
        return cursor.getCount();
    }

}

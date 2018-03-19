package com.example.mortonthompsond2.srndmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mortonthompsond2 on 3/18/2018.
 */

public class DatabaseHelperTabTwo extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "detailManagertab2.db" ;
    public static final String TABLE_CONTACTS = "detailstabtwo" ;
    public static final String KEY_FIRST_NAME = "firstname" ;
    public static final String KEY_LAST_NAME = "lastname" ;
    public static final String KEY_EMAIL = "email" ;
    public static final String KEY_USER_NAME = "username" ;
    public static final String KEY_PASSWORD = "password" ;

    public DatabaseHelperTabTwo(Context context)
    {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_FIRST_NAME + " TEXT," + KEY_LAST_NAME + " TEXT," +
                KEY_EMAIL + " TEXT," + KEY_USER_NAME + " TEXT," + KEY_PASSWORD + " TEXT" + ");" ;

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

        values.put(KEY_FIRST_NAME,contact.getFirstName());
        values.put(KEY_LAST_NAME,contact.getLastName());
        values.put(KEY_EMAIL,contact.getEmail());
        values.put(KEY_USER_NAME,contact.getUserName());
        values.put(KEY_PASSWORD,contact.getPassword());

        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }

    contact getContact(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS,new String[] {KEY_FIRST_NAME,KEY_LAST_NAME,KEY_EMAIL,KEY_USER_NAME,KEY_PASSWORD}, KEY_LAST_NAME
                + "=?" , new String[] {String.valueOf(id)},null,null,null,null);

        if(cursor!= null)
        {
            cursor.moveToFirst();
        }

        contact contact = new contact(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return contact;
    }

    public String searchPassword(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT username, password FROM " + TABLE_CONTACTS;

        Cursor cursor = db.rawQuery(query,null);

        String a, b;
        b = "not found" ;

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);

                if(a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;
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
                contact.setPassword(cursor.getString(4));

                contactList.add(contact);
            }while(cursor.moveToNext());

        }
        return contactList;
    }

    public int updateContact(String firstName, String lastName,String email,String userName,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME,firstName);
        values.put(KEY_LAST_NAME,lastName);
        values.put(KEY_EMAIL,email);
        values.put(KEY_USER_NAME,userName);
        values.put(KEY_PASSWORD,password);

        return db.update(TABLE_CONTACTS,values, KEY_FIRST_NAME + "=?" ,
                new String[]{firstName});
    }

    public void deleteContact(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONTACTS, KEY_FIRST_NAME + " = ?" ,
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
package com.example.doctorcatcher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "DoctorCatcher.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table login (fullname text, NRIC text, username text primary key, password text, DOB text, Phone text, Email text, Address text, PolicyName text, PolicyPhone text, PolicyRelation text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists login");
    }

    public boolean checkUsername(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM login where username=?", new String[] {username});

        if (cursor.getCount()>0)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public boolean logincheck (String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username=? and password =?", new String[]{username,password});

        if (cursor.getCount()>0)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    public Cursor sessions (String users)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username=?", new String[]{users});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor delete (String users)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("delete from login where username=?", new String[]{users});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor update (String users, String password, String fullname,String NRIC,String DOB,String PhoneNo,String Email,String Address, String PolicyName, String PolicyPhone, String PolicyRelation)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("update login set password=?, fullname=?, NRIC=?, DOB=?, Phone=?, Email=?, Address=?,  PolicyName=?, PolicyPhone=?, PolicyRelation=?  where username=?", new String[]{password,fullname,NRIC, DOB, PhoneNo,Email,Address,PolicyName,PolicyPhone,PolicyRelation,users});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean insert (String fullname, String NRIC, String username, String password, String DOB, String Phone, String Email, String Address, String PolicyName, String PolicyPhone, String PolicyRelation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("NRIC", NRIC);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("DOB", DOB);
        contentValues.put("Phone", Phone);
        contentValues.put("Email", Email);
        contentValues.put("Address", Address);
        contentValues.put("PolicyName", PolicyName);
        contentValues.put("PolicyPhone", PolicyPhone);
        contentValues.put("PolicyRelation", PolicyRelation);

        long ins = db.insert("login", null, contentValues);
        if (ins == 1) {
            return false;
        } else {
            return true;
        }
    }
}

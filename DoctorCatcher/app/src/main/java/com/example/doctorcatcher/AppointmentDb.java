package com.example.doctorcatcher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AppointmentDb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DoctorCatcher2.db";
    public static final String TABLE_NAME = "AppointmentList";
    public static final String TABLE_COL1 = "ID";   //ID
    public static final String TABLE_COL2 = "Doc_ID";   //Doc_ID
    public static final String TABLE_COL3 = "name";  //Doc name
    public static final String TABLE_COL4 = "Time";  //free time
    public static final String TABLE_COL5 = "Date";  //free day
    public static final String TABLE_COL6 = "Location";  //doc location

    public AppointmentDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Doc_ID TEXT, name TEXT, Time TEXT, Date TEXT, Location TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean savdData(String item1, String item2, String item3, String item4, String item5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_COL2, item1);
        contentValues.put(TABLE_COL3, item2);
        contentValues.put(TABLE_COL4, item3);
        contentValues.put(TABLE_COL5, item4);
        contentValues.put(TABLE_COL6, item5);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data =db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }

    public  Boolean delData(String item1, String item2, String item3, String item4, String item5){

        SQLiteDatabase db = this.getWritableDatabase();

        long result= db.delete(TABLE_NAME,TABLE_COL2+" LIKE '" +item1+"'",null);

        if (result == -1)
            return false;
        else
            return true;

    }


    public Boolean editData(String item1, String item2, String item3, String item4,String item5){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_COL2, item1);
        contentValues.put(TABLE_COL3, item2);
        contentValues.put(TABLE_COL4, item3);
        contentValues.put(TABLE_COL5, item4);
        contentValues.put(TABLE_COL6, item5);


        long result = db.update(TABLE_NAME,contentValues,TABLE_COL2+" = '" + item1+"'",null);

        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor searchData(String item1){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor search = db.rawQuery("SELECT * FROM "+TABLE_NAME+ "WHERE"+TABLE_COL2+"Like '%"+item1+"%' ", null);
        if (search != null) {
            search.moveToFirst();
        }
        return search;

    }


}


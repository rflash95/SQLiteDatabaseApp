package com.teknorial.belajardatabase;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


public class MainActivity extends Activity{
    RezaHelper rezaHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rezaHelper=new RezaHelper(this);
        SQLiteDatabase sqLiteDatabase = rezaHelper.getWritableDatabase();
    }



}

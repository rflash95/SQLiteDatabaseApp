package com.teknorial.belajardatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Teknorial on 22-Nov-15.
 */
public class RezaHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="teknorialdatabase";
    private static final String TABLE_NAME="teknorialtable";
    private static final String UID="_id";
    private static final String NAME="Nama";
    private static final int DATABASE_VERSION= 2;
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE  IF EXISTS "+TABLE_NAME;
    private Context context;
    public RezaHelper (Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Constructor dipanggil");
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Message.message(context,"onCreate dipanggil");
        } catch (SQLiteException e){
            Message.message(context,""+e);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
        try{
            Message.message(context,"onUpgrade dipanggil");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLiteException e){
            Message.message(context,""+e);
        }
    }
}
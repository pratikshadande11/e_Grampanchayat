package com.example.tax_module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 = "E_Grampanchayat3";
    public static final String TABLE_NAME2 = "complaints_table";
    public static final String COL2_1 = "AREA";
    public static final String COL2_2 = "COMPLAINT";


    public DataBaseHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME2 + "(" + COL2_1 + " TEXT, " + COL2_2 + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }


    public boolean insertData2(String area, String complaint){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(COL2_1, area);
        values.put(COL2_2, complaint);


        long res= db.insert(TABLE_NAME2, null, values);
        if(res== -1)
            return false;
        else
            return true;

    }

}
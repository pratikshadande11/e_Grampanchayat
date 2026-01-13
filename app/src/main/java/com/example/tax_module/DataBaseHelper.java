package com.example.tax_module;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "E_Grampanchayat2";
    public static final String TABLE_NAME = "tax_table2";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "AREA";
    public static final String COL_3 = "PLOT_NO";
    public static final String COL_4 = "AMOUNT";
    public static final String COL_5 = "CONTACT_NO";
    public static final String COL_6 = "STATUS";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " TEXT PRIMARY KEY, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String area, String plot_no, String amount, String contact_no, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(COL_1, name);
        values.put(COL_2, area);
        values.put(COL_3, plot_no);
        values.put(COL_4, amount);
        values.put(COL_5, contact_no);
        values.put(COL_6, status);

        long res= db.insert(TABLE_NAME, null, values);
        return res != -1;
    }

    public Cursor readData(String plot, String area){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, new String[]{COL_1, COL_4}, COL_3 + " = ? AND " + COL_2 + " = ?", new String[]{plot, area}, null, null, null, null);
    }

    public boolean setStatus() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_6, "Suceess");
        long res = db.insert(TABLE_NAME, null, values);
        return res != -1;
    }
}
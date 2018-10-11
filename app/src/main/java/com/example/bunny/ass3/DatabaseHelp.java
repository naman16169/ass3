package com.example.bunny.ass3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseHelp extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Questions";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+"ID"+" INTEGER PRIMARY KEY, "+"ques"+" VARCHAR(255) ,"+ "saved"+" VARCHAR(225));";


        public DatabaseHelp(Context context) {
            super(context, TABLE_NAME, null, 2);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        }

        public void addQues(Integer id,String ques,String save) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("ID", id);
            cv.put("ques", ques);
            cv.put("saved", save);

            Log.d("asdf", "addData: Adding " + id + " to " + TABLE_NAME);

            db.insert(TABLE_NAME, null, cv);
        }

    public void Update(int id , String option)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + "saved" +
                " = '" + option + "' WHERE " + "ID" + " = '" + id + "'";
        Log.d("asdf", "addData: Adding " + option + " to "+ id + TABLE_NAME);
        db.execSQL(query);
    }

    public void exportCSV(FileOutputStream out) throws IOException {

        SQLiteDatabase db = this.getReadableDatabase();
        for(int i=0;i<30;i++) {
            Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
            cursor.moveToPosition(i);
            String s1[]=new String[2];
            String question = cursor.getString(cursor.getColumnIndex("ques"));
            String torf = cursor.getString(cursor.getColumnIndex("saved"));
            String data = i+1+" ,"+question + " ," + torf + "\n";
            try {
                out.write(data.getBytes());
            } catch (IOException e) {
            }
        }
    }

}

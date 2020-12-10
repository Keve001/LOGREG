package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ABseged extends SQLiteOpenHelper {

    public static final int DB_VERSION=1;
    public static final String DB_NAME="felhasz";

    public static final String FELHASZNALO_TABLE= "felhasznalo";
    public static final String COL_ID = "id";
    public static final String COL_EMAIL= "email";
    public static final String COL_FELHNEV= "felhnev";
    public static final String COL_PASSWORD= "pass";
    public static final String COL_NEV= "teljesnev";
    private Connection conn;


    public ABseged(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE " +FELHASZNALO_TABLE+" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL +" VARCHAR(255) NOT NULL, " +
                COL_FELHNEV +" VARCHAR(255) NOT NULL, " +
                COL_PASSWORD +" VARCHAR(255) NOT NULL, " +
                COL_NEV +" VARCHAR(255) NOT NULL " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS"+FELHASZNALO_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean adatRogzités(String email,String user,String jelszo,String teljesnev ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COL_EMAIL,email);
        values.put(COL_FELHNEV,user);
        values.put(COL_PASSWORD,jelszo);
        values.put(COL_NEV,teljesnev);
        long result=db.insert(FELHASZNALO_TABLE,null,values);

        return  result != -1;
    }

    public boolean check(String user, String jelszo,String email) {
        boolean valasztas = false;
        try {

            String query = "SELECT * FROM felhasz WHERE felhnev LIKE '" + user + "' AND pass LIKE '" + jelszo+ "' AND pass LIKE '" + email ;
            PreparedStatement pst = conn.prepareStatement(query);

            if (pst.execute() == true) {

                valasztas = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return valasztas;
    }


}

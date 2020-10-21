package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetsDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";

    public PetsDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        final String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PetContract.PetEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                PetContract.PetEntry.COLUMN_BREED + " TEXT, " + PetContract.PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, "+
                PetContract.PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersiom){
        final String SQL_DELETE_PETS_TABLE = "DROP TABLE " + PetContract.PetEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_PETS_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db,int newVersion, int oldVersion){
        onUpgrade(db,newVersion,oldVersion);
    }
}

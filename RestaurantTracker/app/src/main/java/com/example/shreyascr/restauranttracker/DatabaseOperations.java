package com.example.shreyascr.restauranttracker;

import com.example.shreyascr.restauranttracker.RestaurantTableData.RestaurantTableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ShreyasCR on 7/21/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + RestaurantTableInfo.TABLE_NAME+"("+RestaurantTableInfo.RESTAURANT_ID + " TEXT," + RestaurantTableInfo.RESTAURANT_NAME + " TEXT," + RestaurantTableInfo.RESTAURANT_JSON+" TEXT);";

    public DatabaseOperations(Context context){
        super(context, RestaurantTableInfo.DATABASE_NAME, null, database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){

    }


    public void putRestaurant(DatabaseOperations dbo, String id, String name, String JSONInformation){
        SQLiteDatabase sqlDB = dbo.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RestaurantTableInfo.RESTAURANT_ID, id);
        cv.put(RestaurantTableInfo.RESTAURANT_NAME, name);
        cv.put(RestaurantTableInfo.RESTAURANT_JSON, JSONInformation);

        //val determines if insertion has been successful
        long val = sqlDB.insert(RestaurantTableInfo.TABLE_NAME, null, cv);

    }
}

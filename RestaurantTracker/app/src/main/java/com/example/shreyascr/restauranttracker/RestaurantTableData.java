package com.example.shreyascr.restauranttracker;

import android.provider.BaseColumns;

/**
 * Created by ShreyasCR on 7/21/16.
 */
public class RestaurantTableData {

    public RestaurantTableData(){
        //Default constructor
    }

    public static abstract class RestaurantTableInfo implements BaseColumns{

        //Table Colums/Keys
        public static final String RESTAURANT_ID = "restaurant_id";
        public static final String RESTAURANT_NAME = "restaurant_name";
        public static final String RESTAURANT_JSON = "restaurant_JSON";

        //Name of the Database
        public static final String DATABASE_NAME = "restaurant_info";

        //Variable for our table name
        public static final String TABLE_NAME = "saved_restaurant";
    }

}

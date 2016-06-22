package com.example.shreyascr.restauranttracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//import com.beust.jcommander.JCommander;
//import com.beust.jcommander.Parameter;
//import com.example.shreyascr.restauranttracker.YelpAPI;

public class MainScreen extends AppCompatActivity {

    //EditText input;
    //Button searchButton;

    private static final String CONSUMER_KEY = "Ou2qWmjM__B_HQi-WpZqgA";
    private static final String CONSUMER_SECRET = "bK55eGG8tDhdNNbCPFVzMSjKkUU";
    private static final String TOKEN = "7S8NzlsP8eBY_4q_Ex6LRvr9um28Xn4O";
    private static final String TOKEN_SECRET = "-oy50zIbNEyy_vUrtaETtti3V2E";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }

    public void buttonOnClick(View v){
        Button button = (Button) v;
        ((Button) v).setText("clicked");

        EditText locationInput = (EditText) findViewById(R.id.location_text);
        EditText termInput = (EditText) findViewById(R.id.term_text);

        String location = locationInput.getText().toString();
        String term = termInput.getText().toString();

        new MyTask(term, location).execute();

        /*YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String result = yelpApi.searchForBusinessesByLocation(term, location);*/

        //System.out.println(result);

    }

    private class MyTask extends AsyncTask<Void, Void, Void>{
        private String term;
        private String location;
        private String result;

        public MyTask(String term, String location){
            this.term = term;
            this.location = location;
        }

        @Override
        protected Void doInBackground(Void... params) {
            YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
            this.result = yelpApi.searchForBusinessesByLocation(term, location);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            postExecture(result);
        }
    }

    public void postExecture(String result){
        Log.i("This: ", result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

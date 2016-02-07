package com.example.shreyascr.restauranttracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
//import com.example.shreyascr.restauranttracker.YelpAPI;

public class MainScreen extends AppCompatActivity {

    EditText input;
    Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        input = (EditText) findViewById(R.id.input_text);
        searchButton = (Button) findViewById(R.id.button);
        final YelpAPI yelpapi = new YelpAPI();
        searchButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String searchQuery = input.getText().toString();
                String[] input = new String[1];
                input[0] = searchQuery;
                yelpapi.makeSearch(input);

            }
        });

        /*YelpAPICLI yelpApiCli = new YelpAPICLI();
        new JCommander(yelpApiCli, new String[5]);


        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        yelpApi.queryAPI(yelpApi, yelpApiCli);*/
        setContentView(R.layout.activity_main_screen);
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

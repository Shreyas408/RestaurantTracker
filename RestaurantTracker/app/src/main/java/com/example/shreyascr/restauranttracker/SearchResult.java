package com.example.shreyascr.restauranttracker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.util.Log;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by ShreyasCR on 6/21/16.
 */
public class SearchResult extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.search_result_screen);

        String JSONresult = getIntent().getStringExtra(MainScreen.MESSAGE);

        Log.i("JSON: ", JSONresult);

        JSONObject result = null;
        /*try {
            result = (JSONObject)(JSONresult);
            Log.i("JSON: ", result.toString(4));
        }catch(JSONException e){
            Log.e("JSONException" , "Error");
        }*/
        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(JSONresult);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(JSONresult);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);

        for(int i = 0; i < businesses.size(); i++) {
            JSONObject business = (JSONObject) businesses.get(i);
            String bus = business.get("name").toString();
            Log.i("Business", bus);
            listItems.add(bus);

        }
        adapter.notifyDataSetChanged();
        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Log.i("This: ", ""+arg2);
            }
        });
        //setContentView(R.layout.search_result_screen);


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

package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


public class FillRestaurantInfo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fill_restaurant_layout);

        //setContentView(R.layout.);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        */



    }

//    public void GotoProfile(View view) {
//        Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
//        //final int result = 1;
//        Intent activityThatCalled = getIntent();
//
//
//
//        String restaurant_name = ((EditText) findViewById(R.id.restaurant_name)).getText().toString();
//        Db.Drink test = new Db.Drink("test", 10.0);
//        HashMap<String, Db.Drink> menu = new HashMap<>();
//        menu.put("test", test);
//        Db.Restaurant curr_restaurant = new Db.Restaurant(restaurant_name, Lat, Lng, menu);
//        Db.restaurant_map.put(restaurant_name, curr_restaurant);
//
//
//        GotoProfileIntent.putExtra("logged_in", username);
//        GotoProfileIntent.putExtra("logged_in_email", email);
//        startActivity(GotoProfileIntent);
////        startActivityForResult if you want to retrieve data back with result id
//    }

    public void MakeMenu(View view) {
        Intent MakeMenuIntent = new Intent(this, MakeMenu.class);
        Intent activityThatCalled = getIntent();

        String username = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");
        Double Lat = Double.parseDouble(activityThatCalled.getExtras().getString("Lat"));
        Double Lng = Double.parseDouble(activityThatCalled.getExtras().getString("Lng"));
        String restaurant_name = ((EditText) findViewById(R.id.restaurant_name)).getText().toString();
//        Db.Drink test = new Db.Drink("test", 10.0);
        HashMap<String, Db.Drink> menu = new HashMap<>();
//        menu.put("test", test);
        Db.Restaurant curr_restaurant = new Db.Restaurant(restaurant_name, Lat, Lng, menu);
        Db.restaurant_map.put(restaurant_name, curr_restaurant);


        MakeMenuIntent.putExtra("logged_in", username);
        MakeMenuIntent.putExtra("logged_in_email", email);
        MakeMenuIntent.putExtra("restaurant_name", restaurant_name);
        startActivity(MakeMenuIntent);
    }
}

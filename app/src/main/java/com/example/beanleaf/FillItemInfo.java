package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class FillItemInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fill_item_layout);

    }

    public void MakeMenu(View view) {
        Intent MakeMenuIntent = new Intent(this, MakeMenu.class);
        Intent activityThatCalled = getIntent();

        String username = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");
        String restaurant_name = activityThatCalled.getExtras().getString("restaurant_name");
//        Double Lat = Double.parseDouble(activityThatCalled.getExtras().getString("Lat"));
//        Double Lng = Double.parseDouble(activityThatCalled.getExtras().getString("Lng"));
        String item_name = ((EditText) findViewById(R.id.item_name)).getText().toString();
        String item_price = ((EditText) findViewById(R.id.item_price)).getText().toString();
        String item_caffeine = ((EditText) findViewById(R.id.item_caffeine)).getText().toString();
        String item_nutrition = ((EditText) findViewById(R.id.item_nutrition)).getText().toString();

////        Db.Drink test = new Db.Drink("test", 10.0);
//        HashMap<String, Db.Drink> menu = new HashMap<>();
////        menu.put("test", test);
//        Db.Restaurant curr_restaurant = new Db.Restaurant(restaurant_name, Lat, Lng, menu);
//        Db.restaurant_map.put(restaurant_name, curr_restaurant);
        Db.Drink dr = new Db.Drink(item_name, Double.parseDouble(item_price), Double.parseDouble(item_caffeine), item_nutrition);
        Db.restaurant_map.get(restaurant_name).menu.put(item_name, dr);


        MakeMenuIntent.putExtra("logged_in", username);
        MakeMenuIntent.putExtra("logged_in_email", email);
        MakeMenuIntent.putExtra("restaurant_name", restaurant_name);
        startActivity(MakeMenuIntent);
    }


}

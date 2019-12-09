package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class MakeMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.make_menu_layout);


        Intent activityThatCalled = getIntent();
        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
        String logged_in_email = activityThatCalled.getExtras().getString("logged_in_email");
        String restaurant_name = activityThatCalled.getExtras().getString("restaurant_name");
        TextView tv = (TextView) findViewById(R.id.show_restaurant_name);
        tv.append(restaurant_name);

        HashMap<String, Db.Drink> drinks = Db.restaurant_map.get(restaurant_name).menu;

        String[] drinks_to_adaptor = new String[drinks.size()];
        /*for(int i = 0; i < drinks.size(); i++){
            drinks_to_adaptor[i] = drinks.get(i).name;
        }
        */

        int j = 0;
        for(String s: drinks.keySet()){
            drinks_to_adaptor[j] = s;
            j++;
        }

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                drinks_to_adaptor);

        ListView ItemListVIew = (ListView) findViewById(R.id.ItemListView);

        ItemListVIew.setAdapter(theAdapter);


    }


    public void FillItemInfo(View view) {
        Intent FillItemInfoIntent = new Intent(this, FillItemInfo.class);
        Intent activityThatCalled = getIntent();

        String username = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");
//        Double Lat = Double.parseDouble(activityThatCalled.getExtras().getString("Lat"));
//        Double Lng = Double.parseDouble(activityThatCalled.getExtras().getString("Lng"));
        String restaurant_name = activityThatCalled.getExtras().getString("restaurant_name");
////        Db.Drink test = new Db.Drink("test", 10.0);
//        HashMap<String, Db.Drink> menu = new HashMap<>();
////        menu.put("test", test);
//        Db.Restaurant curr_restaurant = new Db.Restaurant(restaurant_name, Lat, Lng, menu);
//        Db.restaurant_map.put(restaurant_name, curr_restaurant);


        FillItemInfoIntent.putExtra("logged_in", username);
        FillItemInfoIntent.putExtra("logged_in_email", email);
        FillItemInfoIntent.putExtra("restaurant_name", restaurant_name);
        startActivity(FillItemInfoIntent);
    }

    public void GotoProfile(View view){
        Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
        Intent activityThatCalled = getIntent();

        String username = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");
//        Double Lat = Double.parseDouble(activityThatCalled.getExtras().getString("Lat"));
//        Double Lng = Double.parseDouble(activityThatCalled.getExtras().getString("Lng"));
        String restaurant_name = activityThatCalled.getExtras().getString("restaurant_name");
////        Db.Drink test = new Db.Drink("test", 10.0);
//        HashMap<String, Db.Drink> menu = new HashMap<>();
////        menu.put("test", test);
//        Db.Restaurant curr_restaurant = new Db.Restaurant(restaurant_name, Lat, Lng, menu);
//        Db.restaurant_map.put(restaurant_name, curr_restaurant);
        Db.users.get(email).ownedRestaurant.add(restaurant_name);

        GotoProfileIntent.putExtra("logged_in", username);
        GotoProfileIntent.putExtra("logged_in_email", email);
        GotoProfileIntent.putExtra("restaurant_name", restaurant_name);
        startActivity(GotoProfileIntent);
    }
}

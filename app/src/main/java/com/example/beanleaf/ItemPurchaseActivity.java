package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class ItemPurchaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.purchase_layout);

        //setContentView(R.layout.);


        Intent activityThatCalled = getIntent();
        final String restaurant_name = activityThatCalled.getExtras().getString("restaurant");

        //get all strings
//        String[] drinks = {"Green tea", "Mocha"};
        //ArrayList<Db.Drink> drinks = Db.restaurant_map.get(restaurant_name).menu;
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

        ItemListVIew.setOnItemClickListener(new
                AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                        //String itemPicked = "You selected " + String.valueOf((adapterView.getItemAtPosition(position)));
                        String item = String.valueOf((adapterView.getItemAtPosition(position)));
                        String itemPicked = "Purchase of " + item + " added to history";

                        //Button purchaseButton = (Button) findViewById(R.id.PurchaseButton);
                        //purchaseButton.append(itemPicked);
                        Toast.makeText(ItemPurchaseActivity.this, itemPicked, Toast.LENGTH_SHORT).show();
                        Intent activityThatCalled = getIntent();
                        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
                        String email = activityThatCalled.getExtras().getString("logged_in_email");

                        Db.Drink dr = Db.restaurant_map.get(restaurant_name).menu.get(item);
                        Date currentTime = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                        String strDate = dateFormat.format(currentTime);
                        Db.users.get(email).orderHistory.add(new Db.Order(dr, strDate));

                        //Add to merchant's selling history
                        Db.restaurant_map.get(restaurant_name).selling_history.add(dr.name + " " + strDate + " by " + logged_in_person);
                    }
                });


    }

    public void GotoProfile(View view) {
        Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
        //final int result = 1;
        /*
        String username = ((EditText) findViewById(R.id.register_user_name)).getText().toString();
        String email = ((EditText) findViewById(R.id.register_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.register_password)).getText().toString();

         */

        Intent activityThatCalled = getIntent();
        String username = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");


        GotoProfileIntent.putExtra("logged_in", username);
        GotoProfileIntent.putExtra("logged_in_email", email);
        startActivity(GotoProfileIntent);
    }
}

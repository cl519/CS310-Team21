package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemPurchaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.purchase_layout);

        //setContentView(R.layout.);


        Intent activityThatCalled = getIntent();
        String restaurant_name = activityThatCalled.getExtras().getString("restaurant");


        //get all strings
//        String[] drinks = {"Green tea", "Mocha"};
        ArrayList<Db.Drink> drinks = Db.restaurant_map.get(restaurant_name).menu;

        String[] drinks_to_adaptor = new String[drinks.size()];
        for(int i = 0; i < drinks.size(); i++){
            drinks_to_adaptor[i] = drinks.get(i).name;
        }



        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                drinks_to_adaptor);

        ListView ItemListVIew = (ListView) findViewById(R.id.ItemListView);

        ItemListVIew.setAdapter(theAdapter);

        ItemListVIew.setOnItemClickListener(new
                AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                        String itemPicked = "You selected " + String.valueOf((adapterView.getItemAtPosition(position)));

                        Toast.makeText(ItemPurchaseActivity.this, itemPicked, Toast.LENGTH_SHORT).show();
                    }
                });


    }
}

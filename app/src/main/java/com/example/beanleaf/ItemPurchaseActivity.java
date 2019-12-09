package com.example.beanleaf;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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
import java.util.Objects;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class ItemPurchaseActivity extends Activity {


    @Override
    protected void onCreate(final Bundle savedInstanceState){
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

        ListView ItemListView = findViewById(R.id.ItemListView);

        ItemListView.setAdapter(theAdapter);

        ItemListView.setOnItemClickListener(new
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

                        Db.Drink db = Db.restaurant_map.get(restaurant_name).menu.get(item);
                        Date currentTime = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                        String strDate = dateFormat.format(currentTime);
                        Db.users.get(email).orderHistory.add(new Db.Order(db, strDate));

                        // Check if user is above their limit and send notification
                        Objects.requireNonNull(Db.users.get(email)).CaffeineReset();
                        Db.users.get(email).dailyCaffeine += db.caffeine;
                        if(Db.users.get(email).dailyCaffeine >= 400) {
                            showWarning();

                        }
                    }
                });
    }

    public void showWarning() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Warning: You have exceeded your daily caffeine limit");
        dialog.setTitle("Bean&Leaf");
        dialog.setPositiveButton("Dismiss",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
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

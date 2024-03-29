package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class GotoProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_layout);

        Intent activityThatCalled = getIntent();
        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
        String logged_in_email = activityThatCalled.getExtras().getString("logged_in_email");

        Log.d("email", logged_in_email);
        Log.d("username", logged_in_person);
        Log.d("in the map?", Db.users.get(logged_in_email).toString());

        TextView tv = (TextView) findViewById(R.id.welcome_user);
        tv.append(logged_in_person);

        TextView ev = (TextView) findViewById(R.id.purchase_history);

        ArrayList<Db.Order> hist = Db.users.get(logged_in_email).orderHistory;
        for(int i = 0; i < hist.size(); i++){
            ev.append(hist.get(i).drink.name + " " + hist.get(i).DateTime + "\n");
        }

        TextView evSelling = (TextView) findViewById(R.id.selling_history);
        if(Db.users.get(logged_in_email).isMerchant){
            ArrayList<String> ownedRestaurant = Db.users.get(logged_in_email).ownedRestaurant;
            for(int i = 0; i < ownedRestaurant.size(); i++){
                evSelling.append("Selling History of Shop " + ownedRestaurant.get(i) + " :\n");
                ArrayList<String> selling_history = Db.restaurant_map.get(ownedRestaurant.get(i)).selling_history;
                for(int j = 0; j < selling_history.size(); j++){
                    evSelling.append(selling_history.get(j) + "\n");
                }

            }
        }else{
            evSelling.setVisibility(View.GONE);
        }

        Button testButton=(Button)findViewById(R.id.create_business_button);
        if(Db.users.get(logged_in_email).isMerchant){
            testButton.setVisibility(View.VISIBLE);
        }else{
            testButton.setVisibility(View.GONE);
        }

        //setContentView(R.layout.);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        */


    }

    public void OpenMap(View view) {
        Intent MapsActivityIntent = new Intent(this, MapsActivity.class);
        //final int result = 1;

        //GotoProfileIntent.putExtra("callingActivity", "MainActivity");
        Intent activityThatCalled = getIntent();
        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");

        MapsActivityIntent.putExtra("logged_in", logged_in_person);
        MapsActivityIntent.putExtra("logged_in_email", email);
        startActivity(MapsActivityIntent);
//        startActivityForResult if you want to retrieve data back with result id
    }

    public void AddBusinessActivity(View view){
        Intent AddBusinessIntent = new Intent(this, AddBusinessActivity.class);

        Intent activityThatCalled = getIntent();
        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");


        AddBusinessIntent.putExtra("logged_in", logged_in_person);
        AddBusinessIntent.putExtra("logged_in_email", email);
        startActivity(AddBusinessIntent);
    }

    public void BackToLoginActivity(View view) {
        Intent BackToLoginIntent = new Intent(this, LocalLoginActivity.class);
        startActivity(BackToLoginIntent);
    }
}

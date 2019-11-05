package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterCustomer extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);

        //setContentView(R.layout.);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        */

    }

    public void GotoProfile(View view) {
        Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
        //final int result = 1;

        //GotoProfileIntent.putExtra("callingActivity", "MainActivity");
        startActivity(GotoProfileIntent);
//        startActivityForResult if you want to retrieve data back with result id
    }



}

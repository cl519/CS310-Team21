package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GotoProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_layout);

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
        startActivity(MapsActivityIntent);
//        startActivityForResult if you want to retrieve data back with result id
    }
}

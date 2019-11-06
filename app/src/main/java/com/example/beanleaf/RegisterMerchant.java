package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterMerchant extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.merchant_register_layout);

        //setContentView(R.layout.);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        */

    }

    public void GotoProfile(View view) {
        Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
        //final int result = 1;

        String username = ((EditText) findViewById(R.id.register_user_name)).getText().toString();
        String email = ((EditText) findViewById(R.id.register_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.register_password)).getText().toString();
        String business_code = ((EditText) findViewById(R.id.business_verification)).getText().toString();


        Db.users.put(email, new Db.User(username, password));


        GotoProfileIntent.putExtra("logged_in", username);
        GotoProfileIntent.putExtra("logged_in_email", email);
        GotoProfileIntent.putExtra("business", business_code);
        startActivity(GotoProfileIntent);
//        startActivityForResult if you want to retrieve data back with result id
    }
}

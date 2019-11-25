package com.example.beanleaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LocalLoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.local_login);

        //setContentView(R.layout.);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        */



    }

    public void GotoProfile(View view) {
        String email = ((EditText) findViewById(R.id.login_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.login_password)).getText().toString();

        if(Db.verifyUser(email, password)){
            Intent GotoProfileIntent = new Intent(this, GotoProfile.class);
            //final int result = 1;



            GotoProfileIntent.putExtra("logged_in", Db.users.get(email).username);
            GotoProfileIntent.putExtra("logged_in_email", email);
            startActivity(GotoProfileIntent);
        }else{
            EditText mPasswordView = ((EditText) findViewById(R.id.login_password));
            mPasswordView.setError(getString(R.string.error_invalid_password));
        }


//        startActivityForResult if you want to retrieve data back with result id
    }

    public void RegisterAsCustomer(View view) {
        Intent RegisterCustomerIntent = new Intent(this, RegisterCustomer.class);
        //final int result = 1;

        startActivity(RegisterCustomerIntent);
//        startActivityForResult if you want to retrieve data back with result id
    }

    public void RegisterAsMerchant(View view) {
        Intent RegisterMerchantIntent = new Intent(this, RegisterMerchant.class);
        //final int result = 1;

        startActivity(RegisterMerchantIntent);
    }
}

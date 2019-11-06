package com.example.beanleaf;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class AddBusinessActivity extends FragmentActivity implements GoogleMap.OnMarkerDragListener,GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng destLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_business);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerDragListener(this);

        //Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        LatLng UCLA = new LatLng(34.0668, -118.4454);
        Marker mk = mMap.addMarker(new MarkerOptions().position(UCLA).title("Restaurant Location"));
        mk.setDraggable(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UCLA));




    }

    @Override
    public void onInfoWindowClick(Marker marker) { //show the list
        /*Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();

         */
        /*
        Intent ItemPurchaseIntent = new Intent(this, ItemPurchaseActivity.class);
//        GotoProfileIntent.putExtra("logged_in", username);
        ItemPurchaseIntent.putExtra("restaurant", marker.getTitle());

        Intent activityThatCalled = getIntent();
        String logged_in_person = activityThatCalled.getExtras().getString("logged_in");
        String email = activityThatCalled.getExtras().getString("logged_in_email");

        ItemPurchaseIntent.putExtra("logged_in", logged_in_person);
        ItemPurchaseIntent.putExtra("logged_in_email", email);

        startActivity(ItemPurchaseIntent);
        */

    }


    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        destLatLng = marker.getPosition();
        System.out.print("latitude: " + destLatLng.latitude + " longitude: " + destLatLng.longitude);

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}

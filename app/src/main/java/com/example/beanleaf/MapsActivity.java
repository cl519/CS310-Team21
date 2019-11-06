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

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        //Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */

        Db.Drink dr = new Db.Drink("first_coffee", 0.5);
        ArrayList<Db.Drink> menu = new ArrayList<>();
        menu.add(dr);
        Db.Restaurant dbr = new Db.Restaurant("test", 34.0197, -118.2903, menu);
        dbr.getinfo();

        Db.restaurant_map.put("test", dbr);
        //Db.restaurant_list.add(dbr);

        Db.Drink dr2 = new Db.Drink("Mocha", 0.7);
        Db.Drink dr3 = new Db.Drink("Thai Tea", 0.7);
        Db.Drink dr4 = new Db.Drink("Latte", 0.7);
        ArrayList<Db.Drink> menu2 = new ArrayList<>();
        menu2.add(dr2);
        menu2.add(dr3);
        menu2.add(dr4);
        Db.Restaurant dbr2 = new Db.Restaurant("test2", 34.0256, -118.2859, menu2);
        //Db.restaurant_list.add(dbr2);
        Db.restaurant_map.put("test2", dbr2);



        //for(Db.Restaurant r: Db.restaurant_list){
        for(Db.Restaurant r: Db.restaurant_map.values()) {
            LatLng latest = new LatLng(r.lat, r.longitude);
            mMap.addMarker(new MarkerOptions()
                    .position(latest)
                    .title(r.name)
                    .snippet(r.info)
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latest));
        }


    }

    @Override
    public void onInfoWindowClick(Marker marker) { //show the list
        /*Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();

         */
        Intent ItemPurchaseIntent = new Intent(this, ItemPurchaseActivity.class);
//        GotoProfileIntent.putExtra("logged_in", username);
        ItemPurchaseIntent.putExtra("restaurant", marker.getTitle());
        startActivity(ItemPurchaseIntent);


    }


}

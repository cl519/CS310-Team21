package com.example.beanleaf;

import java.util.ArrayList;
import java.util.HashMap;

public class Db {
    public static HashMap<String, String> m_map;
    public static ArrayList<Restaurant> restaurant_list = new ArrayList<>();


    public static class Drink{
        Drink(String name, double calories){
            this.name = name;
            this.calories = calories;
        }
        String name;
        double calories;
    }
    public static class Restaurant{
        String name;
        double lat;
        double longitude;
        ArrayList<Drink> menu;
        String info = new String();

        public Restaurant(String name, double lat, double longitude, ArrayList<Drink> menu){
            this.name = name;
            this.lat = lat;
            this.longitude = longitude;
            this.menu = menu;
        }

        public void getinfo(){
            for(int i = 0; i < menu.size(); i++){
                info += (menu.get(i).name + "\n");
            }

        }
    }
}

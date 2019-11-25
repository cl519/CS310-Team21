package com.example.beanleaf;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class Db {
    public static HashMap<String, String> m_map;
    //public static ArrayList<Restaurant> restaurant_list = new ArrayList<>();
    public static HashMap<String, Restaurant> restaurant_map = new HashMap<>();

    public static HashMap<String, User> users = new HashMap<>();
    private static Db database;
    public static Db getDatabase() {
        if(database == null) {
            database = new Db();
        }
        return database;
    }

    public static boolean verifyUser(String email, String password) {
//        Log.d("email", email);
//        Log.d("password", password);
        if(users.containsKey(email)) {
            return users.get(email).password.equals(password);
        }
        return false;
    }

    public void addUser(String username, String password, String email) {
        users.put(email, new User(username,password));
    }

    public static class User {
        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        boolean isMerchant;
        String username, password;
        ArrayList<Order> orderHistory = new ArrayList<>();
    }

    public static class Order{
        Order(Drink drink, String DateTime){
            this.drink = drink;
            this.DateTime = DateTime;
        }
        Drink drink;
        String DateTime;
    }


    public static class Drink{
        Drink(String name, double calories){
            this.name = name;
            this.calories = calories;
        }
        String name;
        double calories;
    }

    public static class Snack{
        Snack(String name, double calories){
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
        //ArrayList<Drink> menu;
        HashMap<String, Drink> menu;
        String info = new String();

        public Restaurant(String name, double lat, double longitude, HashMap<String, Drink> menu){
            this.name = name;
            this.lat = lat;
            this.longitude = longitude;
            this.menu = menu;
        }

        public void getinfo(){
            /*
            for(int i = 0; i < menu.size(); i++){
                info += (menu.get(i).name + "\n");
            }
            */

            for(String s: menu.keySet()){
                info+= (s + "\n");
            }

        }
    }
}

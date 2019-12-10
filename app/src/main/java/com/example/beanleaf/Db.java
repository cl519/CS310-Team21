package com.example.beanleaf;

import android.annotation.SuppressLint;
import android.util.Log;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static String getDate() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getHash(String password) {
        return String.valueOf(password.hashCode());
    }

    public static boolean verifyEmail(String email) {
        if(email.length() < 3) {
            return false;
        } else if( !email.substring(1, email.length()-1).contains("@") ) {
            return false;
        }

        return true;
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
            dailyCaffeine = 0;
            dailyNotification = false;
        }
        void CaffeineReset() {
            if(orderHistory.size() < 2) return;

            String d1 = orderHistory.get(orderHistory.size()-1).DateTime;
            String d2 = orderHistory.get(orderHistory.size()-2).DateTime;
            String d1c = d1.split(" ")[0];
            String d2c = d2.split(" ")[0];

            if(!d1c.equals(d2c)) {
                dailyCaffeine = 0;
                dailyNotification = false;
            }
        }
        boolean dailyNotification;
        int dailyCaffeine;
        boolean isMerchant;
        String username, password;
        ArrayList<Order> orderHistory = new ArrayList<>();
        ArrayList<String> ownedRestaurant = new ArrayList<>();
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
        Drink(String name, double price, double caffeine, String nutrition){
            this.name = name;
            this.price = price;
            this.caffeine = caffeine;
            this.nutrition = nutrition;
        }
        String name;
        double caffeine;
        double price;
        double calories;
        String nutrition;
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
        ArrayList<String> selling_history = new ArrayList<>();

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

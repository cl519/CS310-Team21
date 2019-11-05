package com.example.beanleaf;

import java.util.ArrayList;
import java.util.HashMap;

public class Db {
    public static HashMap<String, String> m_map;
    public static ArrayList<Restaurant> restaurant_list = new ArrayList<>();
    public static HashMap<String, User> users;
    private static Db database;
    public static Db getDatabase() {
        if(database == null) {
            database = new Db();
        }
        return database;
    }

    public boolean verifyUser(String username, String password) {
        if(users.containsKey(username)) {
            return users.get(username).password.equals(password);
        }
        return false;
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username,password));
    }

    public static class User {
        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        String username, password;
        ArrayList<Drink> orderHistory;
    }
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

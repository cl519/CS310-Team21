package com.example.beanleaf;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Db database;

    @Before
    public void setUp() throws Exception {
    }

    // Test Db singleton initalize
    @Test
    public void initializeDB() {
        assertFalse(Db.getDatabase() == null);
    }

    // Ensure we retrive the same object
    @Test
    public void singletonDB() {
        assertEquals(Db.getDatabase(), Db.getDatabase());
    }

    // Test Db class constructors
    @Test
    public void userConstruct() {
        Db.User test = new Db.User("bob", "password");
        assertEquals(test.username, "bob");
        assertEquals(test.password, "password");
    }

    @Test
    public void drinkConstruct() {
        Db.Drink test = new Db.Drink("coffee", 50.0);
        assertEquals(test.calories, 50.0, 0.01);
        assertEquals(test.name, "coffee");
    }

    @Test
    public void snackConstruct() {
        Db.Snack test = new Db.Snack("fries", 250.0);
        assertEquals(test.calories, 250.0, 0.01);
        assertEquals(test.name, "fries");
    }

    @Test
    public void orderConstruct() {
        Db.Drink drink = new Db.Drink("coke", 100.0);
        Db.Order test = new Db.Order(drink, "feb24");
        assertEquals(drink.name, "coke");
        assertEquals(drink.calories, 100.0, 0.01);
        assertEquals(test.DateTime, "feb24");
    }

    @Test
    public void restaurantConstruct() {
        HashMap<String, Db.Drink> menu = new HashMap<String, Db.Drink>();
        Db.Restaurant test = new Db.Restaurant("starbucks", 24.0, 34.0, menu);
        assertEquals(test.name, "starbucks");
        assertEquals(test.lat, 24.0,0.001);
        assertEquals(test.longitude, 34.0,0.001);
        assertEquals(test.menu.size(), 0);
    }

    @Test
    public void databaseStress() {
        for(int i = 0; i < 100000; ++i) {
            String x = String.valueOf(i);
            Db.getDatabase().addUser(x,x,x);
        }
    }


}

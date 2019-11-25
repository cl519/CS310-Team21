package com.example.beanleaf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.example.beanleaf.Db.verifyUser;
import static org.junit.Assert.*;

public class DatabaseTest {
    private Db database = Db.getDatabase();

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

    @Test
    public void dbVerifyTrue() {
        database.addUser("test","pass","test@test.com");
        assertTrue(verifyUser("test@test.com","pass"));
    }

    @Test
    public void dbVerifyFalse() {
        database.addUser("test","pass","test@test.com");
        assertFalse(verifyUser("test@test.com","password"));
    }

    @Test
    public void emailVerifyTrue() {
        assertTrue(Db.verifyEmail("test@test.com"));
    }

    @Test
    public void emailVerifyFalse() {
        assertFalse(Db.verifyEmail("@bb"));
        assertFalse(Db.verifyEmail("bb@"));
        assertFalse(Db.verifyEmail("b"));

    }

    @Test
    public void dateTest() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        assertEquals(dateFormat.format(date),Db.getDate()); //2016/11/16 12:08:43
    }

    @Test
    public void hashTest() {
        String hash = "password";
        assertEquals(String.valueOf(hash.hashCode()), Db.getHash(hash));
    }

    @Test
    public void PurchaseSorted(){
        Db.Drink first_drink = new Db.Drink("Coke", 10.0);
        Db.Order first_order = new Db.Order(first_drink, "2019-06-22 12:02:21");
        Db.Drink second_drink = new Db.Drink("Sprite", 10.0);
        Db.Order second_order = new Db.Order(second_drink, "2019-08-22 08:02:21");
        Db.Drink third_drink = new Db.Drink("Lemonade", 10.0);
        Db.Order third_order = new Db.Order(third_drink, "2019-09-22 12:02:21");

        Db.User us = new Db.User("Dawg", "123");

        us.orderHistory.add(first_order);
        us.orderHistory.add(second_order);
        us.orderHistory.add(third_order);

        ArrayList<Db.Order> temp = new ArrayList(us.orderHistory);

        Collections.sort(us.orderHistory, new Comparator<Db.Order>() {

            @Override
            public int compare(Db.Order o1, Db.Order o2) {
                return o1.DateTime.compareTo(o2.DateTime);
            }
        });
        boolean sorted = temp.equals(us.orderHistory);

        assertTrue(sorted);


    }

}

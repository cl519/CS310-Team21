package com.example.beanleaf;

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
        Db.Drink test = new Db.Drink("coffee", 50);
        assertEquals(test.calories, 50);
        assertEquals(test.name, "coffee");
    }

    @Test
    public void orderConstruct() {
    }

    @Test
    public void restaurantConstruct() {

    }


}

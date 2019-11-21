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
        Db db1 = Db.getDatabase();
        Db db2 = Db.getDatabase();
        assertEquals(db1, db2);
    }

    // Test Db class constructors
    @Test
    public void userClass() {
        Db.User test = new Db.User("bob", "password");
        assertEquals(test.username, "bob");
        assertEquals(test.password, "password");
    }

    @Test
    public void orderClass() {

    }

    @Test
    public void restaurantClass() {

    }


}

package com.example.beanleaf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<LocalLoginActivity> mLoginActivityTestRule =
            new ActivityTestRule<>(LocalLoginActivity.class);

    @Test
    public void initializeTest() {
        // Ensures that our testing software is working and can access the app
        onView(withId(R.id.login_email))
                .perform(typeText("Blackbox"), closeSoftKeyboard());
    }

//    @Test
//    public void registerUserTest() {
//        onView(withId(R.id.registerUser))
//                .perform(click());
//    }
//
//    @Test
//    public void registerMerchantTest() {
//        onView(withId(R.id.registerMerchant))
//                .perform(click());
//    }
}

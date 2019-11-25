package com.example.beanleaf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

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
    public void InitializeTest() {
        // Ensures that our testing software is working and can access the app
        onView(withId(R.id.login_email))
                .perform(typeText("Blackbox"), closeSoftKeyboard());
    }

    @Test
    public void RegisterUserTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as User"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("testuser"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.welcome_user), withText("Welcome! testuser"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Welcome! testuser")));
    }

    @Test
    public void LogoutUserTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as User"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(replaceText("pass"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        editText4.check(matches(withText("")));
    }

    @Test
    public void SignInUserTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as User"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("fkdfi"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_user_name), withText("fkdfi"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText2.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_user_name), withText("fkdfi"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText3.perform(replaceText("testuser"));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.register_user_name), withText("testuser"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText4.perform(closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText5.perform(replaceText("tes@o"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText6.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.register_email), withText("tes@o"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText7.perform(replaceText("test@test.com"));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.register_email), withText("test@test.com"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText8.perform(closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText9.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText10.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.welcome_user), withText("Welcome! testuser"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Welcome! testuser")));
    }

    @Test
    public void RegisterMerchantTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as Merchant"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("testuser"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText4.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.business_verification),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                7),
                        isDisplayed()));
        editText5.perform(replaceText("1234567890"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.create_business_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.welcome_user), withText("Welcome! testuser"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Welcome! testuser")));
    }

    @Test
    public void SignInMerchant() {
        ViewInteraction button = onView(
                allOf(withText("Register as Merchant"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("testuser"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.business_verification),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                7),
                        isDisplayed()));
        editText4.perform(replaceText("1234567890"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText5.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText6.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.welcome_user), withText("Welcome! testuser"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Welcome! testuser")));
    }

    @Test
    public void goToMapsTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as User"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.button), withText("Look for shops"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button3.perform(click());

//        DataInteraction textView = onData(anything())
//                .inAdapterView(allOf(withId(R.id.ItemListView),
//                        childAtPosition(
//                                withClassName(is("android.widget.LinearLayout")),
//                                1)))
//                .atPosition(1);
//        textView.perform(click());
//
//        ViewInteraction button4 = onView(
//                allOf(withText("Back to Profile"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        button4.perform(click());
//
//        ViewInteraction textView2 = onView(
//                allOf(withId(R.id.purchase_history), withText("Purchase History: \nMocha"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                3),
//                        isDisplayed()));
//        textView2.check(matches(withText("Purchase History:  Mocha ")));
    }

    @Test
    public void InvalidEmailTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("pass"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button.perform(click());

    }

    @Test
    public void InvalidUserTest() {
        ViewInteraction button = onView(
                allOf(withText("Register as User"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.register_user_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("testuser"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText2.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText3.perform(replaceText("password123"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText4.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText5.perform(replaceText("password124"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button4.perform(click());
    }

    @Test
    public void shortPasswordTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText.perform(replaceText(""), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText2.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        editText3.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        editText4.perform(replaceText("x"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}

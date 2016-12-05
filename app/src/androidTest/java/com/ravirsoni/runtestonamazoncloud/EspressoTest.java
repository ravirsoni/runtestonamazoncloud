package com.ravirsoni.runtestonamazoncloud;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class EspressoTest extends ActivityInstrumentationTestCase2 {

    public EspressoTest() {super(SimpleDemoActivity.class);}

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testEspresso(){
        Log.i("TESTESPRESSO", "Starting the Espresso Test");
        onView(withId(R.id.editText)).perform(typeText("Testing with AWS Device Farm"));
        onView(withId(R.id.buttonUpdate)).perform(click());
        onView(withId(R.id.updatedText)).check(matches(withText("Testing with AWS Device Farm")));

        // Take the screenshot
        ScreenShot.take(getActivity(),"Homepage");
    }
}
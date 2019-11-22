package com.example.wiprotest;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by jbathula on 22,November,2019
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final int ITEM_BELOW_THE_FOLD = 3;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void scrollTothridpostion_checkingText() {
        onView(ViewMatchers.withId(R.id.recycle_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));

        String itemElementText = activityRule.getActivity().getResources().getString(
                R.string.item_element_text) + String.valueOf(ITEM_BELOW_THE_FOLD);
        onView(withText(itemElementText)).check(matches(isDisplayed()));
    }

}


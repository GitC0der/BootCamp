package com.github.GitC0der.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void clickingIsDisplayed() {
        onView(withId(R.id.mainName))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    @Test
    public void clickingButtonShowsCorrectUnmodifiedGreeting() {
        Intents.init();
        onView(withId(R.id.mainGoButton))
                .perform(click());
        intended(allOf(
                hasExtra(MainActivity.USERNAME, MainActivity.greetingEditText.getText().toString()),
                hasComponent(GreetingActivity.class.getName())
        ));
        Intents.release();
    }

    @Test
    public void typingANameAndClickingButtonDisplaysCorrectName() {
        Intents.init();
        final String randomName = "Alfred Royce";
        onView(withId(R.id.mainName)).perform(clearText()).perform(typeText(randomName));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainGoButton))
                .perform(click());
        intended(allOf(
                hasExtra(MainActivity.USERNAME, randomName),
                hasComponent(GreetingActivity.class.getName())
        ));
        Intents.release();
    }


}

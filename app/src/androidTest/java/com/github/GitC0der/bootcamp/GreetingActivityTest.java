package com.github.GitC0der.bootcamp;

import static android.content.Intent.getIntent;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void enteredTextIsCorrect() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = new Intent(context, GreetingActivity.class);
        final String randomName = "John Beef";
        intent.putExtra(MainActivity.USERNAME, randomName);

        ActivityScenario activityScenario = ActivityScenario.launch(intent);
        onView(withId(R.id.greetingMessage))
                .check(matches(withText("Welcome " + randomName)));
        activityScenario.close();
    }
}

package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import dalvik.annotation.TestTargetClass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricTest {
    @Test
    public void testFirst() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        TextView results = (TextView) activity.findViewById(R.id.textView);
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Hello world!"));
    }
    @Test
    public void testSecond()
    {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        TextView results = (TextView) activity.findViewById(R.id.textView);
        Button but = (Button) activity.findViewById(R.id.button);
        but.performClick();
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("bye world!"));
    }

    @Test
    public void testActivityStart(){
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button2).performClick();
        Intent expectedIntent = new Intent(activity, Main2Activity.class);
        assertThat(shadowOf(activity).getNextStartedActivity(), equalTo(expectedIntent));
    }




}

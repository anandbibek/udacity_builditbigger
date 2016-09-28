package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class GetJokeAsyncTaskTest extends AndroidTestCase {

    public void testJokeDownload() {

        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.execute();
            String joke = task.get(10, TimeUnit.SECONDS);
            Log.d("HHH",joke);
            assertFalse(joke.contains("ERROR! NOT A JOKE."));

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
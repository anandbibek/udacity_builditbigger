package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.anand.joke.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    //private Context context;


    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //.setRootUrl("http://192.168.1.101:8080/_ah/api/")
                    .setRootUrl("https://udacity-builditbigger-b14e7.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(false);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        //context = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return "ERROR! NOT A JOKE." + e.getMessage();
        }
    }

//    @Override
//    protected void onPostExecute(String result) {
//        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        context.startActivity(new Intent(context, JokeActivity.class)
//                .putExtra(JokeActivity.INTENT_ID, result));
//    }
}
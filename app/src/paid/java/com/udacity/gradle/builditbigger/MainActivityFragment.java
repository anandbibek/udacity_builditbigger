package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button button;
    ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        button = (Button) root.findViewById(R.id.button);
        progressBar = (ProgressBar)root.findViewById(R.id.circularProgressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(){
                    @Override
                    protected void onPostExecute(String joke) {
                        progressBar.setVisibility(View.GONE);
                        ((OnJokeReceivedListener)getActivity()).onReceived(joke);
                    }
                }.execute();
            }
        });
        return root;
    }

    public interface OnJokeReceivedListener{
        void onReceived(String joke);
    }
}

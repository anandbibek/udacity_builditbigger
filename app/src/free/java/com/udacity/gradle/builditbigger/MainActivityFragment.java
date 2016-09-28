package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    InterstitialAd mInterstitialAd;
    Button button;
    String joke = "";
    ProgressBar progressBar;
    boolean adLoaded = false, dataLoading = false;

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
                //if ad is loaded move to next screen when ad is cancelled
                //if ad is not loaded, move to next screen immediately
                progressBar.setVisibility(View.VISIBLE);
                if (adLoaded = mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
                dataLoading = true;
                new EndpointsAsyncTask(){
                    @Override
                    protected void onPostExecute(String result) {
                        progressBar.setVisibility(View.GONE);
                        joke = result;
                        dataLoading = false;
                        if(!adLoaded)
                            ((OnJokeReceivedListener)getActivity()).onReceived(joke);
                    }
                }.execute();
            }
        });
        mInterstitialAd = new InterstitialAd(root.getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                //don't move to next page if nothing is loaded when ad is dismissed
                if(!dataLoading) {
                    ((OnJokeReceivedListener) getActivity()).onReceived(joke);
                    //If we did not move to next page if data was not loaded
                    //we have to make sure we move when data is loaded
                    adLoaded = false;
                }
            }
        });
        requestNewInterstitial();
        MobileAds.initialize(root.getContext().getApplicationContext(), getString(R.string.app_ad_id));
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();
        mInterstitialAd.loadAd(adRequest);
    }


    public interface OnJokeReceivedListener{
        void onReceived(String joke);
    }
}

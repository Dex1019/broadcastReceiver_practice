package com.example.dex.broadcastreceiverexample;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class MyApp extends Application {

    private static final String WIFI_STATE_CHANGE_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    private static void registerForNetworkChangeEvents(Context context) {


        ConnectionReceiver connectionReceiver = new ConnectionReceiver();

        context.registerReceiver(connectionReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        context.registerReceiver(connectionReceiver, new IntentFilter(WIFI_STATE_CHANGE_ACTION));
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Overriding onCreate and calling registerForNetworkChangeEvents method
        registerForNetworkChangeEvents(this);
    }
}

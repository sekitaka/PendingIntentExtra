package me.sekitaka.pendingintentextra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ResourceBundle;

/**
 * Created by Takashi Seki on 2017/05/15.
 */

public class Receiver extends BroadcastReceiver {
    public static final String TAG = Receiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onReceive");
        Helper.logIntentExtra(intent);
    }
}

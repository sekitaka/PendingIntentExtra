package me.sekitaka.pendingintentextra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ResourceBundle;

/**
 * Created by Takashi Seki on 2017/05/15.
 */

public class Receiver extends BroadcastReceiver {
    public static final String TAG = Receiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        switch (intent.getIntExtra("result_function_id", Integer.MAX_VALUE)) {
            case 1:
                showResult1(intent);
                break;
            case 2:
                showResult2(intent);
                break;
            case 3:
                showResult3(intent);
                break;
            default:
                Log.d(TAG, "No result method.");
        }
    }

    void showResult1(Intent intent) {
        Log.d(TAG, "showResult1");
        Log.d(TAG, "serializable_player:" + intent.getSerializableExtra("serializable_player"));
    }

    void showResult2(Intent intent) {
        Log.d(TAG, "showResult2");
        Log.d(TAG, "serializable_player:" + intent.getSerializableExtra("serializable_player"));
        Log.d(TAG, "extra_string:" + intent.getStringExtra("extra_string"));
        Log.d(TAG, "extra_int:" + intent.getIntExtra("extra_int", Integer.MAX_VALUE));
    }

    void showResult3(Intent intent) {
        Log.d(TAG, "showResult3");
        Log.d(TAG, "byte_serializable_player:" + SerializationUtils.deserialize(intent.getByteArrayExtra("byte_serializable_player")));
        Log.d(TAG, "extra_string:" + intent.getStringExtra("extra_string"));
        Log.d(TAG, "extra_int:" + intent.getIntExtra("extra_int", Integer.MAX_VALUE));
    }
}

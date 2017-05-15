package me.sekitaka.pendingintentextra;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Takashi Seki on 2017/05/15.
 */

public class Helper {
    public static final String TAG = Helper.class.getSimpleName();

    public static void logIntentExtra(Intent intent) {
        Log.d(TAG, "intent is instance of " + intent.getClass().getName());

        Log.d(TAG, "key_string=" + intent.getStringExtra("key_string"));
        Log.d(TAG, "key_int=" + intent.getIntExtra("key_int", 42));

        SerializablePlayer serializablePlayer = (SerializablePlayer) intent.getSerializableExtra("key_serializable");
        if (serializablePlayer == null) {
            Log.e(TAG, "key_serializable=" + serializablePlayer);
        } else {
            Log.d(TAG, "key_serializable=" + serializablePlayer);
        }

        ParcelablePlayer parcelablePlayer = (ParcelablePlayer) intent.getParcelableExtra("key_parcelable");
        if (serializablePlayer == null) {
            Log.e(TAG, "key_parcelable=" + parcelablePlayer);
        } else {
            Log.d(TAG, "key_parcelable=" + parcelablePlayer);
        }

//        for ( String s : intent.getExtras().keySet()){
//            Log.d(TAG,"key:" + s);
//        }
//        Log.d(TAG,"key contains:" + intent.getExtras().keySet().contains("bundled_parcelable"));
//        ParcelablePlayer bundledParcelablePlayer = (ParcelablePlayer)intent.getExtras().getParcelable("bundled_parcelable");
//        if (bundledParcelablePlayer == null) {
//            Log.e(TAG, "bundled_parcelable2=" + bundledParcelablePlayer);
//        } else {
//            Log.d(TAG, "bundled_parcelable2=" + bundledParcelablePlayer);
//        }
    }

    public static void putIntentExtra(Intent intent) {
        intent.putExtra("key_string", "bar");

        intent.putExtra("key_int", 23);
        SerializablePlayer serializablePlayer = new SerializablePlayer(1, "Seki");
        ParcelablePlayer parcelablePlayer = new ParcelablePlayer(2, "Yamada");
        intent.putExtra("key_serializable", serializablePlayer);
        intent.putExtra("key_parcelable", parcelablePlayer);

//        Bundle bundle = new Bundle();
//        bundle.putString("b","B");
//        bundle.putParcelable("bundled_parcelable",parcelablePlayer);
//        intent.putExtras(bundle);
    }
}

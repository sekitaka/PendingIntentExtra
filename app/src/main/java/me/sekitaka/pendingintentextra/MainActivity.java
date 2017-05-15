package me.sekitaka.pendingintentextra;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void onClick() {
        Log.d(TAG, "onClick");
        Intent intent = new Intent(this, Receiver.class);
        Helper.putIntentExtra(intent);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        }
    }

    @OnClick(R.id.sub)
    public void onClickSub(){
        Intent intent = new Intent(this, SubActivity.class);
        Helper.putIntentExtra(intent);
        startActivity(intent);
    }
}

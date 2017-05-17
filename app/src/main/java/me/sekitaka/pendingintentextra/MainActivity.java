package me.sekitaka.pendingintentextra;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.commons.lang3.SerializationUtils;

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


    @OnClick(R.id.serializable)
    public void onClick1() {
        Intent intent = new Intent(this, Receiver.class);
        SerializablePlayer serializablePlayer = new SerializablePlayer(1, "Seki");
        intent.putExtra("serializable_player", serializablePlayer); // nullになる
        intent.putExtra("result_function_id", 1); // 結果表示関数用
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
        // 1秒後にbroadcastする
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 1, pendingIntent);
    }

    @OnClick(R.id.serializable_with_other)
    public void onClick2() {
        Intent intent = new Intent(this, Receiver.class);
        SerializablePlayer serializablePlayer = new SerializablePlayer(1, "Seki");
        intent.putExtra("serializable_player", serializablePlayer);
        intent.putExtra("result_function_id", 2); // 結果表示関数用
        intent.putExtra("extra_string", "foo"); // nullになる
        intent.putExtra("extra_int", 23); // 値は渡される
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
// 1秒後にbroadcastする
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 1, pendingIntent);
    }

    @OnClick(R.id.byte_serializable_with_other)
    public void onClick3() {
        Intent intent = new Intent(this, Receiver.class);
        SerializablePlayer serializablePlayer = new SerializablePlayer(1, "Seki");
        // byte[]化する
        byte[] byteSerializablePlayer = SerializationUtils.serialize(serializablePlayer);
        intent.putExtra("byte_serializable_player", byteSerializablePlayer); // 値は渡される
        intent.putExtra("result_function_id", 3); // 結果表示関数用
        intent.putExtra("extra_string", "foo"); // 値は渡される
        intent.putExtra("extra_int", 23); // 値は渡される
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
// 1秒後にbroadcastする
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 1, pendingIntent);
    }
}

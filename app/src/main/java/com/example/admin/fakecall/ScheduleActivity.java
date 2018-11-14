package com.example.admin.fakecall;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class ScheduleActivity extends AppCompatActivity {
    private PendingIntent alarmIntent;
    private AlarmManager alarmMgr;
//    private AdView mAdView;
    AdRequest adRequestint;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0224C93FFD644350DCD7F3D7557C6A5C").build();
        alarmMgr = (AlarmManager) getSystemService("alarm");
        alarmIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmReceiver.class), 0);
    }

    public void onButtonClick(View view) {
        int timer = 0;
        String time = "0";
        switch (view.getId()) {
            case R.id._now:
                time = "3 giây";
                timer = 0;
                break;
            case R.id._10s:
                timer = 10;
                time = "10 giây";
                break;
            case R.id._30s:
                time = "30 giây";
                timer = 30;
                break;
            case R.id._01m:
                time = "1 phút";
                timer = 60;
                break;
            case R.id._5m:
                time = "5 phút";
                timer = 300;
                break;
            case R.id._15m:
                time = "15 phút";
                timer = 900;
                break;
            case R.id._30m:
                time = "30 phút";
                break;
        }
        alarmMgr.set(2, SystemClock.elapsedRealtime() + ((long) (timer * 1000)), alarmIntent);
        Toast.makeText(this, "Cuộc gọi sẽ được thực hiện sau " + time, Toast.LENGTH_LONG).show();
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void btback(View view) {
        Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

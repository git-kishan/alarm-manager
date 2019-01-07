package com.notebook.cvxt001122.alarmmanager1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    public static final String TAG="tag";
    Intent intent;
    PendingIntent alarmIntent;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        intent=new Intent(this,Receiver.class);
        alarmIntent=PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSpecifiedTimeAlarm();
            }
        });
    }
    private void setSpecifiedTimeAlarm(){
        int i=Integer.parseInt(editText.getText().toString());
        if(i==0)
            i=5;

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), alarmIntent);
        Toast.makeText(this, "alarm schedule", Toast.LENGTH_SHORT).show();

    }
    private void setInexactRepeatingAlarm(){
        int i=Integer.parseInt(editText.getText().toString());
        if(i==0)
            i=5;

        alarmManager.setInexactRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime()+5*1000,
                62*1000,alarmIntent );
        Toast.makeText(this, "alarm setted ",Toast.LENGTH_SHORT ).show();
        Log.i(TAG, "alarm set");
    }

    private void setExactNonRepeatingAlarm(){

        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 5*1000, alarmIntent);
        Toast.makeText(this, "alarm set",Toast.LENGTH_SHORT ).show();
        Log.i(TAG, "alarm set in setExactNonRepeatingAlarm");

    }
    private void setSpecifiedAlarmDaily(){
        int i=Integer.parseInt(editText.getText().toString());
        if(i==0)
            i=5;
        Intent intent=new Intent(this,Receiver.class);
        PendingIntent alarmIntent=PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,11 );
        calendar.set(Calendar.MINUTE,12);
        calendar.set(Calendar.SECOND, 2);
        manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        Log.i("TAG","set specified alarm daily invoked" );


    }
}

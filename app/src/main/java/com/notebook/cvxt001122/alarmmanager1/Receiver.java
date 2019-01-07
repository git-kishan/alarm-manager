package com.notebook.cvxt001122.alarmmanager1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"alarm ..." ,Toast.LENGTH_LONG ).show();
        Log.i(MainActivity.TAG, "receiver invoked");
    }
}

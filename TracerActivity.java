package com.example.churdlab1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Iterator;
import java.util.Set;


public class TracerActivity extends AppCompatActivity{
final String CHANNEL_ID = "NOT SURE";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            notify("onCreate With State");
            Set<String> keys = savedInstanceState.keySet();
            Iterator iter = keys.iterator();
            while(iter.hasNext()){
                notify("Key: " + (String)iter.next());
            }
        }else{
            notify("onCreate NO State");
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        notify("On Pause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        notify("On Restart");
    }
    @Override
    protected void onStart() {
        super.onStart();
        notify("On Start");
    }
    @Override
    protected void onStop() {
        super.onStop();
        notify("On Stop");
    }
    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        notify("On Save Instance");
    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        notify("On Activity Result");
    }

    private void notify(String msg) {
        String strClass = this.getClass().getName() ;
        String[] strings = strClass.split("\\.") ;

        NotificationCompat.Builder notibuild = new NotificationCompat.Builder(this, CHANNEL_ID) ;
        notibuild.setContentTitle(msg+" "+strings[strings.length-1]) ;
        notibuild.setAutoCancel(true) ;
        notibuild.setSmallIcon(R.mipmap.ic_launcher) ;
        notibuild.setContentText(strings[strings.length-1]) ;
        Notification noti = notibuild.build() ;
        NotificationManager notificationManager = (NotificationManager)
        getSystemService(NOTIFICATION_SERVICE) ;
        notificationManager.notify(msg.hashCode(), noti) ;
    }
}

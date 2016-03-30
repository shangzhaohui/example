package com.example.picassotest.app;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by shangzhaohui on 16/3/23.
 */
public class MainBaseActivity extends AppCompatActivity {
    // This method will be called when a MessageEvent is posted
    @Subscribe
    public void onMessageEvent(MessageEvent event){
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }
}

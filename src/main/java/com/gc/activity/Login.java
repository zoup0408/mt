package com.gc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Login extends Activity {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ConstUtil.UP /*0*/:
                    Animation remove = new AlphaAnimation(1.0f, 0.0f);
                    remove.setDuration((long) 3000);
                    remove.setFillAfter(true);
                    Login.this.welcome.startAnimation(remove);
                    new Timer().schedule(new Jump(), (long) 3000);
                    return;
                default:
                    return;
            }
        }
    };
    private ImageView welcome;

    class Jump extends TimerTask {
        Jump() {
        }

        public void run() {
            Intent intent = new Intent();
            intent.setClass(Login.this, Haha.class);
            Login.this.startActivity(intent);
            Login.this.finish();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.welcome = (ImageView) findViewById(R.id.view);
        Display display = getWindowManager().getDefaultDisplay();
        ConstUtil.setLength(display.getHeight());
        Menu.initMenu((float) display.getWidth(), (float) display.getHeight(), getResources());
        if (Hero.left == -1.0f && Hero.top == -1.0f) {
            Hero.left = ((float) display.getWidth()) - (8.0f * ConstUtil.MAPITEMWIDTH);
            Hero.top = 6.0f * ConstUtil.MAPITEMWIDTH;
            Hero.direction = 3;
        }
        DBProvider.getDBProvider(this).save(0);
        Message msg = new Message();
        msg.what = 0;
        this.handler.sendMessage(msg);
    }
}

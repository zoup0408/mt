package com.gc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.Display;
import android.view.KeyEvent;

public class Haha extends Activity {
    private DBProvider dbp;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Process.killProcess(Process.myPid());
                    return;
                case 1:
                    Haha.this.dbp.save(1);
                    return;
                case 2:
                    Haha.this.dbp.load(1);
                    return;
                case 3:
                    Haha.this.dbp.load(0);
                    return;
                default:
                    return;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dbp = DBProvider.getDBProvider(this);
        Display display = getWindowManager().getDefaultDisplay();
        setContentView(new MySurfaceView(this, display.getWidth(), display.getHeight(), this.handler));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || event.getRepeatCount() != 0) {
            return super.onKeyDown(keyCode, event);
        }
        if (!MySurfaceView.isWin) {
            if (!MySurfaceView.isStart) {
                Process.killProcess(Process.myPid());
            } else if (Hero.isChoiceFloor) {
                Hero.isChoiceFloor = false;
                MySurfaceView.isDraw = false;
            } else if (Hero.isDialog || Hero.isEnemyInfo) {
                Hero.isDialog = false;
            } else if (Hero.isExp) {
                Hero.isExp = false;
            } else if (Menu.isLoad || Menu.isSave) {
                Menu.isLoad = false;
                Menu.isSave = false;
            } else {
                Menu.isMenu = !Menu.isMenu;
            }
        }
        return true;
    }
}

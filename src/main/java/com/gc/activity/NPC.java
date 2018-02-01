package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class NPC extends Element {
    public NPC(int j, int i, Bitmap[] NPCFrame, int type, int floor) {
        this.i = i;
        this.j = j;
        this.type = type;
        this.NPCFrame = NPCFrame;
        this.floor = floor;
    }

    @Override
    public void draw(Canvas c, int screenWidth) {
        this.times++;
        if (this.times == 5) {
            this.index++;
            this.times = 0;
            if (this.index == 4) {
                this.index = 0;
            }
        }
        c.drawBitmap(this.NPCFrame[this.index], null, new RectF(((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * ((float) this.i), (((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH)) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) this.i)) + ConstUtil.MAPITEMWIDTH), this.p);
    }

    @Override
    public void over() {
        this.isDead = true;
        Map.setMap(this.floor, this.i, 11 - this.j);
        tempNpcs.add(this);
    }
}

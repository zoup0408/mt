package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Item extends Element {
    private Bitmap image;

    public Item(int j, int i, Bitmap image, int type, int floor) {
        this.i = i;
        this.j = j;
        this.type = type;
        this.floor = floor;
        this.image = image;
    }

    public void draw(Canvas c, int screenWidth) {
        if (!this.isDead) {
            c.drawBitmap(this.image, null, new RectF(((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * ((float) this.i), (((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH)) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) this.i)) + ConstUtil.MAPITEMWIDTH), this.p);
        }
    }

    public void over() {
        this.isDead = true;
        Map.setMap(this.floor, this.i, 11 - this.j);
        tempNpcs.add(this);
    }
}

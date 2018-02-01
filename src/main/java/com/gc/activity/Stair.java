package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Stair extends Element {
    private Bitmap image;

    public Stair(int j, int i, Bitmap image, int type, int floor) {
        this.i = i;
        this.j = j;
        this.type = type;
        this.floor = floor;
        this.image = image;
    }

    @Override
    public void draw(Canvas c, int screenWidth) {
        c.drawBitmap(this.image, null, new RectF(((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * ((float) this.i), (((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH)) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) this.i)) + ConstUtil.MAPITEMWIDTH), this.p);
    }
}

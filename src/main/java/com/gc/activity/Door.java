package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Door extends Element {
    public Door(int j, int i, Bitmap[] NPCFrame, int type, int floor) {
        this.i = i;
        this.j = j;
        this.type = type;
        this.NPCFrame = NPCFrame;
        this.floor = floor;
        System.out.println("Door :  i = " + i + " j = " + j);
    }

    public void draw(Canvas c, int screenWidth) {
        if (this.isDead && !this.isOver) {
            this.times++;
            if (this.times == 3) {
                this.index++;
                this.times = 0;
                if (this.index == 4) {
                    this.isOver = true;
                    System.out.println(" num = " + Element.npcs.size());
                    System.out.println(" num = " + Element.npcs.size());
                    Map.setMap(this.floor, this.i, 11 - this.j);
                    Element.tempNpcs.add(this);
                    return;
                }
            }
            c.drawBitmap(this.NPCFrame[this.index], null, new RectF(((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * ((float) this.i), (((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH)) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) this.i)) + ConstUtil.MAPITEMWIDTH), this.p);
        } else if (!this.isOver) {
            c.drawBitmap(this.NPCFrame[this.index], null, new RectF(((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * ((float) this.i), (((float) screenWidth) - (((float) this.j) * ConstUtil.MAPITEMWIDTH)) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) this.i)) + ConstUtil.MAPITEMWIDTH), this.p);
        }
    }
}

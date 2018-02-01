package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    public static List<Element> npcs = new ArrayList();
    public static List<Element> tempNpcs = new ArrayList();
    public Bitmap[] NPCFrame = new Bitmap[4];
    public int floor = 0;
    public int i;
    public int index = 0;
    public boolean isDead = false;
    public boolean isOver = false;
    public int j;
    public Paint p = new Paint();
    public int times = 0;
    public int type;

    public abstract void draw(Canvas canvas, int i);

    public Element() {
        this.p.setAntiAlias(true);
        npcs.add(this);
    }

    public static Object getElementByType(int type) {
        for (int i = 0; i < npcs.size(); i++) {
            if (((Element) npcs.get(i)).type == type) {
                return npcs.get(i);
            }
        }
        return null;
    }

    public void over() {
    }
}

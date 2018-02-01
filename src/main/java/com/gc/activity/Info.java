package com.gc.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Info {
    private static Bitmap bg;
    private static RectF bgRectF;
    public static RectF[] infoButton;
    private static Bitmap[] infos;
    private static Paint p;

    public static void init(Resources res, float SW, float SH) {
        p = new Paint();
        p.setTextSize((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f);
        p.setColor(-1);
        p.setAntiAlias(true);
        infos = Image.getInfoBitmap(res);
        bg = Image.getBgBitmap(res);
        initItemInfo(SW, SH);
    }

    public static void initItemInfo(float SW, float SH) {
        float width = SW - (11.0f * ConstUtil.MAPITEMWIDTH);
        float space = (width - (ConstUtil.MAPITEMWIDTH * 3.0f)) / 4.0f;
        bgRectF = new RectF(0.0f, 0.0f, width, SH);
        infoButton = new RectF[3];
        infoButton[0] = new RectF(space, ConstUtil.MAPITEMWIDTH / 2.0f, ConstUtil.MAPITEMWIDTH + space, (ConstUtil.MAPITEMWIDTH / 2.0f) + ConstUtil.MAPITEMWIDTH);
        infoButton[1] = new RectF((space * 2.0f) + ConstUtil.MAPITEMWIDTH, ConstUtil.MAPITEMWIDTH / 2.0f, (space * 2.0f) + (ConstUtil.MAPITEMWIDTH * 2.0f), (ConstUtil.MAPITEMWIDTH / 2.0f) + ConstUtil.MAPITEMWIDTH);
        infoButton[2] = new RectF((space * 3.0f) + (ConstUtil.MAPITEMWIDTH * 2.0f), ConstUtil.MAPITEMWIDTH / 2.0f, (space * 3.0f) + (ConstUtil.MAPITEMWIDTH * 3.0f), (ConstUtil.MAPITEMWIDTH / 2.0f) + ConstUtil.MAPITEMWIDTH);
    }

    public static void draw(Canvas c, Hero hero, int floor, int SW) {
        float sw = (((float) SW) - (11.0f * ConstUtil.MAPITEMWIDTH)) / 2.0f;
        c.drawBitmap(bg, null, bgRectF, p);
        c.drawBitmap(hero.heroFrame[1][0], null, infoButton[0], p);
        if (Hero.isSearch) {
            c.drawBitmap(infos[4], null, infoButton[1], p);
        }
        if (Hero.isFly) {
            c.drawBitmap(infos[6], null, infoButton[2], p);
        }
        c.drawText("第" + floor + "层", sw - ((ConstUtil.MAPITEMWIDTH * 4.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 7.0f) / 3.0f, p);
        c.drawText("生命", sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 9.0f) / 3.0f, p);
        c.drawText(new StringBuilder(String.valueOf(Hero.hp)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 9.0f) / 3.0f, p);
        c.drawText("攻击", sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 11.0f) / 3.0f, p);
        c.drawText(new StringBuilder(String.valueOf(Hero.attack)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 11.0f) / 3.0f, p);
        c.drawText("防御", sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 13.0f) / 3.0f, p);
        c.drawText(new StringBuilder(String.valueOf(Hero.defence)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 13.0f) / 3.0f, p);
        c.drawText("金币", sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 15.0f) / 3.0f, p);
        c.drawText(new StringBuilder(String.valueOf(Hero.gold)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 15.0f) / 3.0f, p);
        c.drawText("经验", sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 17.0f) / 3.0f, p);
        c.drawText(new StringBuilder(String.valueOf(Hero.exp)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 17.0f) / 3.0f, p);
        c.drawBitmap(infos[0], null, new RectF(sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 19.0f) / 3.0f, (sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f)) + ConstUtil.MAPITEMWIDTH, ((ConstUtil.MAPITEMWIDTH * 19.0f) / 3.0f) + ConstUtil.MAPITEMWIDTH), p);
        c.drawText(new StringBuilder(String.valueOf(Hero.yellowKey)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 21.0f) / 3.0f, p);
        c.drawBitmap(infos[1], null, new RectF(sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 22.0f) / 3.0f, (sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f)) + ConstUtil.MAPITEMWIDTH, ((ConstUtil.MAPITEMWIDTH * 22.0f) / 3.0f) + ConstUtil.MAPITEMWIDTH), p);
        c.drawText(new StringBuilder(String.valueOf(Hero.blueKey)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 24.0f) / 3.0f, p);
        c.drawBitmap(infos[2], null, new RectF(sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f), (ConstUtil.MAPITEMWIDTH * 25.0f) / 3.0f, (sw - ((ConstUtil.MAPITEMWIDTH * 8.0f) / 5.0f)) + ConstUtil.MAPITEMWIDTH, ((ConstUtil.MAPITEMWIDTH * 25.0f) / 3.0f) + ConstUtil.MAPITEMWIDTH), p);
        c.drawText(new StringBuilder(String.valueOf(Hero.redKey)).toString(), ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f) + sw, (ConstUtil.MAPITEMWIDTH * 27.0f) / 3.0f, p);
    }
}

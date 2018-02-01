package com.gc.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Dialog {
    private static float SH = 0.0f;
    private static float SW = 0.0f;
    private static Paint alphaP;
    private static int col = 0;
    private static Bitmap dialogImage;
    public static RectF[] floorChoice;
    private static Paint floorP;
    private static String[] highMsg = new String[]{"生命加4000", "攻击增加25", "防御增加25", "  离     开"};
    private static int imageSize;
    private static String[] lowMsg = new String[]{"生命加800", "攻击增加5", "防御增加5", "  离     开"};
    private static Paint msgP;
    private static Paint p;
    public static int point = -1;
    public static RectF[] rectF;
    public static int tempAttack = 0;
    public static int tempDefence = 0;
    public static int tempExp = 0;
    public static int tempGold = 0;
    public static int tempHp = 0;
    private static Bitmap unuseButton;
    private static Bitmap useButton;
    private static float x;
    private static float y;

    public static void setDialog(int sw, int sh, Resources res) {
        SW = sw*1.0f;
        SH = sh*1.0f;
        dialogImage = Image.getDialogBitmap(res);
        useButton = Image.getButton(res);
        unuseButton = Image.getGrayFloorButton(res);
        x = ((float) SW) - (10.0f * ConstUtil.MAPITEMWIDTH);
        y = 6.0f * ConstUtil.MAPITEMWIDTH;
        floorP = new Paint();
        floorP.setColor(-16777216);
        floorP.setAntiAlias(true);
        floorP.setTextSize(ConstUtil.MAPITEMWIDTH / 2.0f);
        msgP = new Paint();
        msgP.setColor(-1);
        msgP.setAntiAlias(true);
        msgP.setTextSize((ConstUtil.MAPITEMWIDTH * 2.0f) / 3.0f);
        alphaP = new Paint();
        alphaP.setColor(-16777216);
        alphaP.setAlpha(80);
        p = new Paint();
        p.setColor(-16777216);
        p.setAntiAlias(true);
        p.setTextSize(ConstUtil.MAPITEMWIDTH / 2.0f);
        col = 20;
        initRectF();
    }

    public static void initRectF() {
        int i;
        float hight = ConstUtil.MAPITEMWIDTH;
        floorChoice = new RectF[16];
        rectF = new RectF[4];
        for (i = 0; i < 15; i++) {
            floorChoice[i] = new RectF((x + ((((float) (i % 3)) * ConstUtil.MAPITEMWIDTH) * 3.0f)) + ((ConstUtil.MAPITEMWIDTH * 2.0f) / 4.0f), ((((((float) (i / 3)) * ConstUtil.MAPITEMWIDTH) * 7.0f) / 5.0f) + hight) + (ConstUtil.MAPITEMWIDTH / 4.0f), ((x + ((((float) (i % 3)) * ConstUtil.MAPITEMWIDTH) * 3.0f)) + (ConstUtil.MAPITEMWIDTH * 2.0f)) + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f), ((((((float) (i / 3)) * ConstUtil.MAPITEMWIDTH) * 7.0f) / 5.0f) + hight) + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f));
        }
        for (i = 0; i < 4; i++) {
            rectF[i] = new RectF(SW - (8.0f * ConstUtil.MAPITEMWIDTH), ((((float) i) * ConstUtil.MAPITEMWIDTH) * 2.0f) + (2.5f * ConstUtil.MAPITEMWIDTH), SW - (ConstUtil.MAPITEMWIDTH * 3.0f), ((((float) i) * ConstUtil.MAPITEMWIDTH) * 2.0f) + (3.5f * ConstUtil.MAPITEMWIDTH));
        }
    }

    public static void drawFloorDialog(Canvas c) {
        float hight = ConstUtil.MAPITEMWIDTH;
        c.drawRect(SW - (11.0f * ConstUtil.MAPITEMWIDTH), 0.0f, SW, SH, alphaP);
        for (int i = 0; i < 15; i++) {
            if (Hero.maxFloor > i) {
                c.drawBitmap(useButton, null, floorChoice[i], p);
            } else {
                c.drawBitmap(unuseButton, null, floorChoice[i], p);
            }
            c.drawText(new StringBuilder(String.valueOf(i + 1)).toString(), (((x + ((((float) (i % 3)) * ConstUtil.MAPITEMWIDTH) * 3.0f)) + ((ConstUtil.MAPITEMWIDTH * 2.0f) / 4.0f)) + ConstUtil.MAPITEMWIDTH) - ((((float) ((i + 1) / 10)) * ConstUtil.MAPITEMWIDTH) / 4.0f), ((((((float) (i / 3)) * ConstUtil.MAPITEMWIDTH) * 7.0f) / 5.0f) + hight) + ConstUtil.MAPITEMWIDTH, floorP);
        }
    }

    public static void drawExp(Canvas c) {
        float hight = ConstUtil.MAPITEMWIDTH;
        alphaP.setAlpha(225);
        c.drawRect(SW - (11.0f * ConstUtil.MAPITEMWIDTH), 0.0f, SW, SH, alphaP);
        String msg = "";
        String[] msgs = new String[0];
        if (MySurfaceView.floor == 3) {
            msg = "你可以用30金币换取";
            if (Hero.isExp) {
                msg = "你可以用30经验换取";
            }
            tempHp = 800;
            tempAttack = 5;
            tempDefence = 5;
            tempExp = 30;
            tempGold = 30;
            msgs = lowMsg;
        } else if (MySurfaceView.floor == 8) {
            msg = "你可以用100金币换取";
            tempHp = 4000;
            tempAttack = 25;
            tempDefence = 25;
            tempGold = 100;
            msgs = highMsg;
        } else if (MySurfaceView.floor == 7) {
            msg = "你可以用100经验换取";
            tempHp = 4000;
            tempAttack = 25;
            tempDefence = 25;
            tempExp = 100;
            msgs = highMsg;
        }
        c.drawText(msg, SW - (8.5f * ConstUtil.MAPITEMWIDTH), 1.5f * hight, msgP);
        int i = 0;
        while (i < 4) {
            if (point == i) {
                p.setColor(Color.parseColor("#ffff00"));
            }
            if ((!Hero.isExp || Hero.exp < tempExp) && ((!Hero.isStore || Hero.gold < tempGold) && i != 3)) {
                c.drawBitmap(unuseButton, null, rectF[i], p);
            } else {
                c.drawBitmap(useButton, null, rectF[i], p);
            }
            c.drawText(msgs[i], SW - (6.75f * ConstUtil.MAPITEMWIDTH), (((((float) i) * ConstUtil.MAPITEMWIDTH) * 2.0f) + (3.0f * ConstUtil.MAPITEMWIDTH)) + (ConstUtil.MAPITEMWIDTH / 4.0f), p);
            p.setColor(-16777216);
            i++;
        }
    }

    public static void drawEnemyInfo(Canvas c, Enemy e, String lostHp) {
        c.drawBitmap(dialogImage, null, new RectF(x - (ConstUtil.MAPITEMWIDTH / 4.0f), y - (ConstUtil.MAPITEMWIDTH / 4.0f), (x + (ConstUtil.MAPITEMWIDTH * 9.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f), (y + (ConstUtil.MAPITEMWIDTH * 3.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f)), p);
        c.drawBitmap(e.NPCFrame[0], null, new RectF(x + (ConstUtil.MAPITEMWIDTH / 4.0f), y + (ConstUtil.MAPITEMWIDTH / 4.0f), x + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f), y + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f)), p);
        c.drawText("攻击 : " + e.attack, x + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 2.0f), y + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f), p);
        c.drawText("防御 : " + e.defence, x + (ConstUtil.MAPITEMWIDTH * 5.0f), y + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f), p);
        c.drawText("经验 : " + e.exp, x + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 2.0f), (y + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f)) + (ConstUtil.MAPITEMWIDTH / 5.0f), p);
        c.drawText("金币 : " + e.gold, x + (ConstUtil.MAPITEMWIDTH * 5.0f), (y + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f)) + (ConstUtil.MAPITEMWIDTH / 5.0f), p);
        c.drawText("生命 : " + e.hp, x + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 2.0f), (y + ((ConstUtil.MAPITEMWIDTH * 7.0f) / 4.0f)) + ((ConstUtil.MAPITEMWIDTH * 2.0f) / 5.0f), p);
        c.drawText("战损 : " + lostHp, x + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 2.0f), (y + ((ConstUtil.MAPITEMWIDTH * 9.0f) / 4.0f)) + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 5.0f), p);
        c.drawText("确定...", ((x + (ConstUtil.MAPITEMWIDTH * 9.0f)) + ((ConstUtil.MAPITEMWIDTH * 2.0f) / 4.0f)) - (ConstUtil.MAPITEMWIDTH * 2.0f), (y + (2.5f * ConstUtil.MAPITEMWIDTH)) + (ConstUtil.MAPITEMWIDTH / 4.0f), p);
    }

    public static void draw(Canvas c, String value, Bitmap image) {
        c.drawBitmap(dialogImage, null, new RectF(x - (ConstUtil.MAPITEMWIDTH / 4.0f), y - (ConstUtil.MAPITEMWIDTH / 4.0f), (x + (ConstUtil.MAPITEMWIDTH * 9.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f), (y + (ConstUtil.MAPITEMWIDTH * 3.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f)), p);
        if (Hero.isItem) {
            imageSize = 2;
        } else {
            c.drawBitmap(image, null, new RectF(x + (ConstUtil.MAPITEMWIDTH / 4.0f), y + (ConstUtil.MAPITEMWIDTH / 4.0f), x + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f), y + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f)), p);
            imageSize = 4;
        }
        if (value.length() - (col - imageSize) <= 0) {
            c.drawText(value, x + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f), y + ConstUtil.MAPITEMWIDTH, p);
        } else {
            c.drawText(value.substring(0, col - imageSize), x + ((ConstUtil.MAPITEMWIDTH * 5.0f) / 4.0f), y + ConstUtil.MAPITEMWIDTH, p);
            value = value.substring(col - imageSize, value.length());
            int row = value.length() / col;
            for (int i = 0; i < row; i++) {
                c.drawText(value.substring(0, col), x + (ConstUtil.MAPITEMWIDTH / 2.0f), y + (((float) (i + 2)) * ConstUtil.MAPITEMWIDTH), p);
                value = value.substring(col + 1, value.length());
            }
            c.drawText(value, x + (ConstUtil.MAPITEMWIDTH / 2.0f), (((float) (row + 2)) * ConstUtil.MAPITEMWIDTH) + y, p);
        }
        c.drawText("确定...", ((x + (ConstUtil.MAPITEMWIDTH * 9.0f)) + ((2.0f * ConstUtil.MAPITEMWIDTH) / 4.0f)) - (2.0f * ConstUtil.MAPITEMWIDTH), (y + (2.5f * ConstUtil.MAPITEMWIDTH)) + (ConstUtil.MAPITEMWIDTH / 4.0f), p);
    }
}

package com.gc.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class Menu {
    private static float SH;
    private static float SW;
    private static Paint alphaP;
    public static RectF back;
    private static Bitmap button;
    public static RectF[] buttons;
    public static RectF cancel;
    private static Bitmap dialogImage;
    public static RectF enter;
    public static boolean isLoad = false;
    public static boolean isMain = false;
    public static boolean isMenu = false;
    public static boolean isSave = false;
    public static RectF[] mainButtons;
    private static String[] mainMsg = new String[]{" 新 游 戏", "读 取 进 度", "退 出 游 戏"};
    private static Bitmap menuBg;
    private static Bitmap menuButton;
    private static Paint menuP;
    private static String[] msg = new String[]{"  主 菜 单", "保 存 进 度", "读 取 进 度", "返 回 游 戏"};
    private static Paint p;
    public static int point = -1;
    public static int saveOrLoad = 0;
    private static Bitmap title;

    public static void initMenu(float SW, float SH, Resources res) {
        int i;
        SW = SW;
        SH = SH;
        p = new Paint();
        p.setColor(-16777216);
        p.setAntiAlias(true);
        p.setTextSize(ConstUtil.MAPITEMWIDTH / 2.0f);
        menuP = new Paint();
        menuP.setColor(-16777216);
        menuP.setAntiAlias(true);
        menuP.setTextSize((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f);
        menuP.setTypeface(Typeface.MONOSPACE);
        menuP.setFakeBoldText(true);
        alphaP = new Paint();
        alphaP.setColor(-16777216);
        alphaP.setAlpha(220);
        alphaP.setAntiAlias(true);
        button = Image.getButton(res);
        menuButton = Image.getMenuButton(res);
        dialogImage = Image.getDialogBitmap(res);
        menuBg = Image.getMenuBgBitmap(res);
        title = Image.getTitle(res);
        buttons = new RectF[4];
        for (i = 0; i < buttons.length; i++) {
            buttons[i] = new RectF((SW / 2.0f) - (ConstUtil.MAPITEMWIDTH * 3.0f), (((((float) i) * 1.2f) * ConstUtil.MAPITEMWIDTH) + (ConstUtil.MAPITEMWIDTH * 1.2f)) + (((float) i) * ConstUtil.MAPITEMWIDTH), (SW / 2.0f) + (ConstUtil.MAPITEMWIDTH * 3.0f), ((((((float) i) * 1.2f) * ConstUtil.MAPITEMWIDTH) + (ConstUtil.MAPITEMWIDTH * 1.2f)) + ConstUtil.MAPITEMWIDTH) + (((float) i) * ConstUtil.MAPITEMWIDTH));
        }
        mainButtons = new RectF[3];
        for (i = 0; i < mainButtons.length; i++) {
            mainButtons[i] = new RectF((SW / 2.0f) - (ConstUtil.MAPITEMWIDTH * 3.0f), (((((float) (i + 1)) * 1.4f) * ConstUtil.MAPITEMWIDTH) + (ConstUtil.MAPITEMWIDTH * 1.4f)) + (((float) (i + 1)) * ConstUtil.MAPITEMWIDTH), (SW / 2.0f) + (ConstUtil.MAPITEMWIDTH * 3.0f), ((((((float) (i + 1)) * 1.4f) * ConstUtil.MAPITEMWIDTH) + (ConstUtil.MAPITEMWIDTH * 1.4f)) + ConstUtil.MAPITEMWIDTH) + (((float) (i + 1)) * ConstUtil.MAPITEMWIDTH));
        }
        enter = new RectF((SW / 2.0f) - (4.0f * ConstUtil.MAPITEMWIDTH), (ConstUtil.MAPITEMWIDTH * 3.0f) + (2.5f * ConstUtil.MAPITEMWIDTH), (SW / 2.0f) - (1.0f * ConstUtil.MAPITEMWIDTH), (ConstUtil.MAPITEMWIDTH * 3.0f) + (3.5f * ConstUtil.MAPITEMWIDTH));
        cancel = new RectF((SW / 2.0f) + (1.0f * ConstUtil.MAPITEMWIDTH), (ConstUtil.MAPITEMWIDTH * 3.0f) + (2.5f * ConstUtil.MAPITEMWIDTH), (SW / 2.0f) + (4.0f * ConstUtil.MAPITEMWIDTH), (ConstUtil.MAPITEMWIDTH * 3.0f) + (3.5f * ConstUtil.MAPITEMWIDTH));
        back = new RectF(SW - (5.0f * ConstUtil.MAPITEMWIDTH), SH - (2.5f * ConstUtil.MAPITEMWIDTH), SW - (ConstUtil.MAPITEMWIDTH * 2.0f), SH - (1.0f * ConstUtil.MAPITEMWIDTH));
    }

    public static void draw(Canvas c) {
        if (MySurfaceView.isStart) {
            c.drawRect(0.0f, 0.0f, SW, SH, alphaP);
            if (isLoad || isSave || isMain) {
                drawSaveOrLoad(c);
            } else {
                drawMenu(c);
            }
        } else if (MySurfaceView.isWin) {
            c.drawBitmap(menuBg, null, new RectF(0.0f, 0.0f, SW, SH), p);
            drawWinInfo(c);
        } else {
            c.drawBitmap(menuBg, null, new RectF(0.0f, 0.0f, SW, SH), p);
            c.drawBitmap(title, null, new RectF((SW / 2.0f) - (ConstUtil.MAPITEMWIDTH * 4.0f), ConstUtil.MAPITEMWIDTH, (SW / 2.0f) + (ConstUtil.MAPITEMWIDTH * 4.0f), 2.5f * ConstUtil.MAPITEMWIDTH), p);
            drawMainMenu(c);
        }
    }

    public static void drawWinInfo(Canvas c) {
        int sum = ((int) (SW / menuP.getTextSize())) - 2;
        String info = "勇士战胜了大魔王，取得了最终的胜利，感谢您对本游戏的支持，敬请期待魔塔圣诞节版!";
        c.drawText(info.substring(0, sum - 2), 2.5f * menuP.getTextSize(), ConstUtil.MAPITEMWIDTH * 2.0f, menuP);
        info = info.substring(sum - 2, info.length());
        for (int i = 0; i < info.length() / sum; i++) {
            c.drawText(info.substring(i * sum, (i + 1) * sum), menuP.getTextSize() * 0.5f, (ConstUtil.MAPITEMWIDTH * 2.0f) + ((((float) (i + 1)) * 2.0f) * menuP.getTextSize()), menuP);
        }
        c.drawText(info.substring((info.length() / sum) * sum, info.length()), menuP.getTextSize() * 0.5f, (ConstUtil.MAPITEMWIDTH * 2.0f) + ((((float) ((info.length() / sum) + 1)) * 2.0f) * menuP.getTextSize()), menuP);
        c.drawText("QQ:1019678117", menuP.getTextSize() * 0.5f, (ConstUtil.MAPITEMWIDTH * 2.0f) + ((((float) ((info.length() / sum) + 2)) * 2.0f) * menuP.getTextSize()), menuP);
        c.drawBitmap(menuButton, null, back, p);
        if (point > 0) {
            menuP.setColor(Color.parseColor("#FFFF00"));
        }
        c.drawText("返 回", SW - (4.5f * ConstUtil.MAPITEMWIDTH), SH - (1.5f * ConstUtil.MAPITEMWIDTH), menuP);
        menuP.setColor(-16777216);
    }

    public static void drawMainMenu(Canvas c) {
        p.setTextSize(ConstUtil.MAPITEMWIDTH / 2.0f);
        for (int i = 0; i < buttons.length; i++) {
            c.drawBitmap(menuButton, null, mainButtons[i], p);
            if (i == point) {
                menuP.setColor(Color.parseColor("#FFFF00"));
            } else {
                menuP.setColor(-16777216);
            }
            c.drawText(mainMsg[i], (SW / 2.0f) - (2.3f * ConstUtil.MAPITEMWIDTH), ((((((float) (i + 1)) * 1.4f) * ConstUtil.MAPITEMWIDTH) + (1.5f * ConstUtil.MAPITEMWIDTH)) + (((float) (i + 1)) * ConstUtil.MAPITEMWIDTH)) + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f), menuP);
        }
    }

    public static void drawMenu(Canvas c) {
        p.setTextSize(ConstUtil.MAPITEMWIDTH / 2.0f);
        for (int i = 0; i < buttons.length; i++) {
            c.drawBitmap(button, null, buttons[i], p);
            if (i == point) {
                p.setColor(Color.parseColor("#FFFF00"));
            } else {
                p.setColor(-16777216);
            }
            c.drawText(msg[i], (SW / 2.0f) - (ConstUtil.MAPITEMWIDTH * 1.2f), ((((((float) i) * 1.2f) * ConstUtil.MAPITEMWIDTH) + (ConstUtil.MAPITEMWIDTH * 1.2f)) + (((float) i) * ConstUtil.MAPITEMWIDTH)) + ((ConstUtil.MAPITEMWIDTH * 3.0f) / 4.0f), p);
        }
    }

    public static void drawSaveOrLoad(Canvas c) {
        String message = "是 否 要 保 存 进 度 ?";
        if (isLoad) {
            message = "是 否 要 读 取 进 度 ?";
        } else if (isMain) {
            message = "是 否 要 返 回 主 菜 单 ?";
        }
        c.drawBitmap(dialogImage, null, new RectF((SW / 2.0f) - (5.0f * ConstUtil.MAPITEMWIDTH), ConstUtil.MAPITEMWIDTH * 3.0f, (SW / 2.0f) + (5.0f * ConstUtil.MAPITEMWIDTH), (ConstUtil.MAPITEMWIDTH * 3.0f) + (ConstUtil.MAPITEMWIDTH * 4.0f)), p);
        p.setColor(-16777216);
        c.drawText(message, (SW / 2.0f) - (ConstUtil.MAPITEMWIDTH * 4.0f), 4.25f * ConstUtil.MAPITEMWIDTH, p);
        c.drawBitmap(button, null, enter, p);
        if (point == 1) {
            p.setColor(Color.parseColor("#ffff00"));
        }
        c.drawText("是", (SW / 2.0f) - (2.75f * ConstUtil.MAPITEMWIDTH), 6.25f * ConstUtil.MAPITEMWIDTH, p);
        p.setColor(-16777216);
        c.drawBitmap(button, null, cancel, p);
        if (point == 2) {
            p.setColor(Color.parseColor("#ffff00"));
        }
        c.drawText("否", (SW / 2.0f) + (2.25f * ConstUtil.MAPITEMWIDTH), 6.25f * ConstUtil.MAPITEMWIDTH, p);
        p.setColor(-16777216);
    }
}

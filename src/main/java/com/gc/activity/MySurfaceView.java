package com.gc.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Iterator;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Paint alphaP;
    private Canvas canvas;
    private Control ctrl;
    private boolean flag;
    public static int floor;
    private Handler handler;
    private Hero hero;
    public static boolean isDraw;
    public static boolean isExit;
    public static boolean isStart;
    public static boolean isWin;
    private Bitmap loading;
    private Map map;
    private Paint paint;
    private int screenH;
    private int screenW;
    private SurfaceHolder sfh;
    public static int status;
    private Thread th;

    static {
        MySurfaceView.isStart = false;
        MySurfaceView.isWin = false;
        MySurfaceView.isExit = false;
        MySurfaceView.floor = 1;
        MySurfaceView.isDraw = false;
        MySurfaceView.status = 0;
    }

    public MySurfaceView(Context arg4, int arg5, int arg6, Handler arg7) {
        super(arg4);
        this.handler = arg7;
        this.sfh = this.getHolder();
        this.sfh.addCallback(((SurfaceHolder.Callback)this));
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.alphaP = new Paint();
        this.alphaP.setAlpha(90);
        this.alphaP.setAntiAlias(true);
        this.setFocusable(true);
        this.map = ItemFactory.getMap(this.getResources());
        this.hero = ItemFactory.getHero(this.getResources());
        this.loading = Image.getLoadingBitmap(this.getResources());
        ItemFactory.setElement(this.getResources(), Map.getMap(MySurfaceView.floor), MySurfaceView.floor);
    }

    public void drawInfo() {
        try {
            this.canvas = this.sfh.lockCanvas();
            if(this.canvas != null) {
                this.hero.draw(this.canvas);
            }
        }
//        catch(Throwable v0) {
//            if(this.canvas != null) {
//                this.sfh.unlockCanvasAndPost(this.canvas);
//            }
//
//            throw v0;
//        }
        catch(Exception v0_1) {
            if(this.canvas != null) {
                this.sfh.unlockCanvasAndPost(this.canvas);
            }
            else {
            }

            return;
        }

        if(this.canvas != null) {
            this.sfh.unlockCanvasAndPost(this.canvas);
        }
    }

    public void drawProcess() {
        try {
            this.canvas = this.sfh.lockCanvas();
            if(this.canvas != null) {
                this.canvas.drawRect(0f, 0f, ((float)this.screenW), ((float)this.screenH), this.paint);
                this.alphaP.setColor(-1);
                this.alphaP.setStyle(Paint.Style.FILL);
                this.alphaP.setTextSize(ConstUtil.MAPITEMWIDTH);
                this.canvas.drawBitmap(this.loading, null, new RectF(0f, 0f, ((float)this.screenW), ((float)this.screenH)), this.paint);
                String v6 = "加载中 . . . ";
                if(Menu.saveOrLoad == 1) {
                    v6 = "保存中. . . ";
                }

                this.canvas.drawText(v6, (((float)(this.screenW / 2))) - 2f * ConstUtil.MAPITEMWIDTH, 6f * ConstUtil.MAPITEMWIDTH, this.alphaP);
            }
        }
//        catch(Throwable v0) {
//            if(this.canvas != null) {
//                this.sfh.unlockCanvasAndPost(this.canvas);
//            }
//
//            throw v0;
//        }
        catch(Exception v0_1) {
            if(this.canvas == null) {
                return;
            }

            this.sfh.unlockCanvasAndPost(this.canvas);
            return;
        }

        if(this.canvas != null) {
            this.sfh.unlockCanvasAndPost(this.canvas);
        }
    }

    public void execGame() throws InterruptedException {
        long v6 = 500;
        if(MySurfaceView.status == 0) {
            this.logic();
            if(!MySurfaceView.isDraw) {
                this.myDraw();
            }
        }
        else {
            this.drawProcess();
            long v0 = System.currentTimeMillis();
            this.setFloor();
            long v2 = System.currentTimeMillis();
            if(v2 - v0 < v6) {
                Thread.sleep(v6 - (v2 - v0));
            }
        }
    }

    public void execMenu() {
        try {
            this.canvas = this.sfh.lockCanvas();
            if(this.canvas != null) {
                Menu.draw(this.canvas);
            }
        }
//        catch(Throwable v0) {
//            if(this.canvas != null) {
//                this.sfh.unlockCanvasAndPost(this.canvas);
//            }
//
//            throw v0;
//        }
        catch(Exception v0_1) {
            if(this.canvas != null) {
                this.sfh.unlockCanvasAndPost(this.canvas);
            }
            else {
            }

            return;
        }

        if(this.canvas != null) {
            this.sfh.unlockCanvasAndPost(this.canvas);
        }
    }

    public void execWin() {
        try {
            this.canvas = this.sfh.lockCanvas();
            if(this.canvas != null) {
                Menu.draw(this.canvas);
            }
        }
//        catch(Throwable v0) {
//            if(this.canvas != null) {
//                this.sfh.unlockCanvasAndPost(this.canvas);
//            }
//
//            throw v0;
//        }
        catch(Exception v0_1) {
            if(this.canvas != null) {
                this.sfh.unlockCanvasAndPost(this.canvas);
            }
            else {
            }

            return;
        }

        if(this.canvas != null) {
            this.sfh.unlockCanvasAndPost(this.canvas);
        }
    }

    private void logic() {
        this.hero.logic(this.ctrl.isSelected(), this.ctrl.getDirection(), Map.getMap(MySurfaceView.floor));
    }

    public void myDraw() {
        try {
            this.canvas = this.sfh.lockCanvas();
            if(this.canvas != null) {
                this.paint.setColor(-16777216);
                this.paint.setStyle(Paint.Style.FILL);
                this.canvas.drawRect((((float)this.screenW)) - 11f * ConstUtil.MAPITEMWIDTH, 0f, ((float)this.screenW), ((float)this.screenH), this.paint);
                Info.draw(this.canvas, this.hero, MySurfaceView.floor, this.screenW);
                this.map.draw(this.canvas, this.screenW, MySurfaceView.floor);
                Iterator v0_2 = Element.npcs.iterator();
                while(v0_2.hasNext()) {
                    ((Element)v0_2.next()).draw(this.canvas, this.screenW);
                }

                Element.npcs.removeAll(Element.tempNpcs);
                Element.tempNpcs.clear();
                this.ctrl.draw(this.canvas);
                this.hero.draw(this.canvas);
                if(Menu.isMenu) {
                    Menu.draw(this.canvas);


                }
            }
        }
//        catch(Throwable v0) {
//            if(this.canvas != null) {
//                this.sfh.unlockCanvasAndPost(this.canvas);
//            }
//
//            throw v0;
//        }
        catch(Exception v0_1) {
            if(this.canvas != null) {
                this.sfh.unlockCanvasAndPost(this.canvas);
            }
            else {
            }

            return;
        }

        if(this.canvas != null) {
            this.sfh.unlockCanvasAndPost(this.canvas);
        }
    }

    @Override
    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        return super.onKeyDown(arg2, arg3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg7) {
        int v4 = 2;
        if(arg7.getAction() == 0) {
            this.ctrl.onTouch(arg7.getX(), arg7.getY(), 1, this.hero);
        }
        else if(arg7.getAction() == v4) {
            this.ctrl.onTouch(arg7.getX(), arg7.getY(), v4, this.hero);
        }
        else if(arg7.getAction() == 1) {
            this.ctrl.onTouch(arg7.getX(), arg7.getY(), 3, this.hero);
        }
        return true;
    }

    @Override
    public void run() {
        Message v3;
        long v8 = 50;
        while(this.flag) {
            try {
                long v4 = System.currentTimeMillis();
                if(MySurfaceView.isStart) {
                    this.execGame();
                }
                else if(MySurfaceView.isWin) {
                    Menu.isMenu = false;
                    this.execWin();
                }
                else {
                    Menu.isMenu = false;
                    this.execMenu();
                }

                if(Menu.saveOrLoad > 0) {
                    this.drawProcess();
                    v3 = new Message();
                    v3.what = Menu.saveOrLoad;
                    this.handler.sendMessage(v3);
                    Thread.sleep(500);
                    if(Menu.saveOrLoad >= 2) {
                        this.setLoadFloor();
                        MySurfaceView.isStart = true;
                    }

                    Menu.saveOrLoad = -1;
                    Menu.isMenu = false;
                }

                if(MySurfaceView.isExit) {
                    v3 = new Message();
                    v3.what = 0;
                    this.handler.sendMessage(v3);
                }

                long v1 = System.currentTimeMillis();
                if(v1 - v4 >= v8) {
                    continue;
                }

                Thread.sleep(v8 - (v1 - v4));
            }
            catch(InterruptedException v6) {
                v6.printStackTrace();
            }
        }
    }

    public void setFloor() {
        MySurfaceView.floor += MySurfaceView.status;
        ItemFactory.setElement(this.getResources(), Map.getMap(MySurfaceView.floor), MySurfaceView.floor);
        this.hero.setPosition(this.screenW, MySurfaceView.floor);
        System.out.println("Direction ---> " + Hero.direction);
        MySurfaceView.status = 0;
        this.ctrl.init();
    }

    public void setLoadFloor() {
        ItemFactory.setElement(this.getResources(), Map.getMap(MySurfaceView.floor), MySurfaceView.floor);
        MySurfaceView.status = 0;
        this.ctrl.init();
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg1, int arg2, int arg3, int arg4) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg5) {
        this.screenW = this.getWidth();
        this.screenH = this.getHeight();
        this.flag = true;
        ConstUtil.setLength(this.screenH);
        this.ctrl = new Control(((float)this.screenW), ((float)this.screenH), this.getResources());
        this.hero.initPosition(this.screenW, MySurfaceView.floor);
        this.hero.initFloorHero();
        Dialog.setDialog(this.screenW, this.screenH, this.getResources());
        Info.init(this.getResources(), ((float)this.screenW), ((float)this.screenH));
        this.th = new Thread(((Runnable)this));
        this.th.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg2) {
        this.flag = false;
    }
}


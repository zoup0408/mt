package com.gc.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Control {
    private float X;
    private float Y;
    private Paint bigP;
    private Bitmap[] ctrl;
    float dialogX;
    float dialogY;
    private int direction;
    private int index = 0;
    private boolean isSelected = false;
    private RectF rect;
    private float screenHeight;
    private float screenWidth;
    private int sum = 0;

    public Control(float screenWidth, float screenHeight, Resources res) {
        this.dialogX = screenWidth - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.dialogY = 6.0f * ConstUtil.MAPITEMWIDTH;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.X = (screenWidth - (11.0f * ConstUtil.MAPITEMWIDTH)) / 2.0f;
        this.Y = ((ConstUtil.MAPITEMWIDTH * 22.0f) / 3.0f) + (ConstUtil.MAPITEMWIDTH / 2.0f);
        System.out.println(screenHeight);
        this.bigP = new Paint();
        this.bigP.setAntiAlias(true);
        this.ctrl = Image.getCtrlBitmap(res);
        this.rect = new RectF(this.X - (ConstUtil.MAPITEMWIDTH * 2.0f), this.Y - (ConstUtil.MAPITEMWIDTH * 2.0f), this.X + (ConstUtil.MAPITEMWIDTH * 2.0f), this.Y + (ConstUtil.MAPITEMWIDTH * 2.0f));
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.ctrl[this.index], null, this.rect, this.bigP);
    }

    public void dialogOrEnemyInfo(float x, float y, int isMove) {
        if (isMove == 3 && this.isSelected) {
            this.isSelected = false;
            this.index = 0;
        } else if (x >= this.dialogX - (ConstUtil.MAPITEMWIDTH / 4.0f) && x <= (this.dialogX + (ConstUtil.MAPITEMWIDTH * 9.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f) && y >= this.dialogY - (ConstUtil.MAPITEMWIDTH / 4.0f) && y <= (this.dialogY + (ConstUtil.MAPITEMWIDTH * 3.0f)) + (ConstUtil.MAPITEMWIDTH / 4.0f) && isMove == 3) {
            Hero.isDialog = false;
            Hero.isEnemyInfo = false;
            MySurfaceView.isDraw = false;
            if (Map.getMap(15)[2][5] == 0) {
                MySurfaceView.isWin = true;
                MySurfaceView.isStart = false;
            }
        }
    }

    public void choiceFlyFloor(float x, float y, int isMove) {
        this.isSelected = false;
        this.index = 0;
        if (isMove == 3) {
            int i = 0;
            while (i < 15) {
                if (!Dialog.floorChoice[i].contains(x, y)) {
                    i++;
                } else if (i + 1 <= Hero.maxFloor) {
                    MySurfaceView.status = (i + 1) - MySurfaceView.floor;
                    Hero.isChoiceFloor = false;
                    MySurfaceView.isDraw = false;
                }
            }
        }
        if (x > this.screenWidth - 50.0f && y > this.screenHeight - 50.0f) {
            Hero.isChoiceFloor = false;
            MySurfaceView.isDraw = false;
        }
    }

    public void storeOrExp(float x, float y, int isMove) {
        this.isSelected = false;
        this.index = 0;
        for (int i = 0; i < Dialog.rectF.length; i++) {
            if (Dialog.rectF[i].contains(x, y)) {
                this.sum = 0;
                if (Hero.isExp) {
                    if (Hero.exp >= Dialog.tempExp && isMove != 3) {
                        Dialog.point = i;
                    } else if (i == Dialog.rectF.length - 1) {
                        Dialog.point = i;
                    }
                    if (i == Dialog.rectF.length - 1 && isMove == 3) {
                        Hero.isExp = false;
                    } else if (Hero.exp >= Dialog.tempExp && isMove == 3) {
                        if (i == 0) {
                            Hero.hp += Dialog.tempHp;
                        } else if (i == 1) {
                            Hero.attack += Dialog.tempAttack;
                        } else {
                            Hero.defence += Dialog.tempDefence;
                        }
                        Hero.exp -= Dialog.tempExp;
                    }
                } else if (Hero.isStore) {
                    if (Hero.gold >= Dialog.tempGold && isMove != 1) {
                        Dialog.point = i;
                    } else if (i == Dialog.rectF.length - 1) {
                        Dialog.point = i;
                    }
                    if (i == Dialog.rectF.length - 1 && isMove == 3) {
                        Hero.isStore = false;
                    } else if (Hero.gold >= Dialog.tempGold && isMove == 3) {
                        if (i == 0) {
                            Hero.hp += Dialog.tempHp;
                        } else if (i == 1) {
                            Hero.attack += Dialog.tempAttack;
                        } else {
                            Hero.defence += Dialog.tempDefence;
                        }
                        Hero.gold -= Dialog.tempGold;
                    }
                }
                if (this.sum == 4) {
                    this.sum = 0;
                    Dialog.point = -1;
                }
                if (isMove == 3) {
                    Dialog.point = -1;
                }
            }
            this.sum++;
        }
        if (this.sum == 4) {
            this.sum = 0;
            Dialog.point = -1;
        }
        if (isMove == 3) {
            Dialog.point = -1;
        }
    }

    public void menu(float x, float y, int isMove) {
        this.isSelected = false;
        this.index = 0;
        for (int i = 0; i < Menu.buttons.length; i++) {
            if (Menu.buttons[i].contains(x, y)) {
                this.sum = 0;
                Menu.point = i;
                if (isMove == 3) {
                    Menu.point = -1;
                    if (i == 0) {
                        Menu.isMain = true;
                    } else if (i == 1) {
                        Menu.isSave = true;
                    } else if (i == 2) {
                        Menu.isLoad = true;
                    } else if (i == 3) {
                        Menu.isMenu = false;
                    }
                }
                if (this.sum == Menu.buttons.length) {
                    this.sum = 0;
                    Menu.point = -1;
                }
                if (isMove == 3) {
                    Menu.point = -1;
                }
            }
            this.sum++;
        }
        if (this.sum == Menu.buttons.length) {
            this.sum = 0;
            Menu.point = -1;
        }
        if (isMove == 3) {
            Menu.point = -1;
        }
    }

    public void saveOrLoad(float x, float y, int isMove) {
        if (Menu.enter.contains(x, y)) {
            Menu.point = 1;
            if (isMove == 3) {
                Menu.point = -1;
                if (Menu.isSave) {
                    Menu.saveOrLoad = 1;
                    Menu.isMenu = false;
                } else if (Menu.isLoad) {
                    Menu.saveOrLoad = 2;
                    Menu.isMenu = false;
                } else if (Menu.isMain) {
                    MySurfaceView.isStart = false;
                }
                Menu.isSave = false;
                Menu.isMain = false;
                Menu.isLoad = false;
            }
        } else if (Menu.cancel.contains(x, y)) {
            Menu.point = 2;
            if (isMove == 3) {
                Menu.point = -1;
                Menu.isLoad = false;
                Menu.isSave = false;
                Menu.isMain = false;
            }
        } else {
            Menu.point = -1;
        }
        if (isMove == 3) {
            Menu.point = -1;
        }
    }

    public void choiceItem(float x, float y, int isMove) {
        this.isSelected = false;
        this.index = 0;
        for (int i = 0; i < Menu.mainButtons.length; i++) {
            if (Menu.mainButtons[i].contains(x, y)) {
                this.sum = 0;
                Menu.point = i;
                if (isMove == 3) {
                    Menu.point = -1;
                    if (i == 0) {
                        Menu.saveOrLoad = 3;
                    } else if (i == 1) {
                        Menu.saveOrLoad = 2;
                    } else if (i == 2) {
                        MySurfaceView.isExit = true;
                    }
                }
                if (this.sum == Menu.mainButtons.length) {
                    this.sum = 0;
                    Menu.point = -1;
                }
                if (isMove == 3) {
                    Menu.point = -1;
                }
            }
            this.sum++;
        }
        if (this.sum == Menu.mainButtons.length) {
            this.sum = 0;
            Menu.point = -1;
        }
        if (isMove == 3) {
            Menu.point = -1;
        }
    }

    public void win(float x, float y, int isMove) {
        if (Menu.back.contains(x, y)) {
            Menu.point = 1;
            if (isMove == 3) {
                MySurfaceView.isWin = false;
                Menu.point = -1;
                return;
            }
            return;
        }
        Menu.point = -1;
    }

    public void onTouch(float x, float y, int isMove, Hero hero) {
        if (MySurfaceView.isWin) {
            win(x, y, isMove);
        } else if (!MySurfaceView.isStart) {
            choiceItem(x, y, isMove);
        } else if (Hero.isDialog || Hero.isEnemyInfo) {
            dialogOrEnemyInfo(x, y, isMove);
        } else if (Hero.isChoiceFloor) {
            choiceFlyFloor(x, y, isMove);
        } else if (Hero.isExp || Hero.isStore) {
            storeOrExp(x, y, isMove);
        } else if (Menu.isSave || Menu.isLoad || Menu.isMain) {
            saveOrLoad(x, y, isMove);
        } else if (Menu.isMenu) {
            menu(x, y, isMove);
        } else if (Info.infoButton[2].contains(x, y) && isMove == 3) {
            if (Hero.isFly) {
                Hero.isChoiceFloor = true;
            }
        } else if (Info.infoButton[0].contains(x, y) && isMove == 3) {
            Hero.isHero = true;
        } else if (Info.infoButton[1].contains(x, y) && isMove == 3) {
            Hero.isInfo = true;
        } else if ((isMove == 1 || isMove == 2) && this.rect.contains(x, y)) {
            this.isSelected = true;
            if (Math.abs(y - this.Y) > Math.abs(x - this.X)) {
                if (y < this.Y) {
                    this.direction = 0;
                    this.index = 1;
                    return;
                }
                this.direction = 1;
                this.index = 2;
            } else if (x < this.X) {
                this.direction = 2;
                this.index = 3;
            } else {
                this.direction = 3;
                this.index = 4;
            }
        } else {
            if (Hero.isSearch && isMove == 3 && !this.rect.contains(x, y)) {
                int i = (int) (y / ConstUtil.MAPITEMWIDTH);
                int j = (int) ((x - (this.screenWidth - (11.0f * ConstUtil.MAPITEMWIDTH))) / ConstUtil.MAPITEMWIDTH);
                if (i >= 0 && j >= 0 && i < 10 && j < 11) {
                    Hero.displayInfo(i, j);
                }
            }
            if (isMove == 3) {
                this.isSelected = false;
                this.index = 0;
            }
        }
    }

    public int getDirection() {
        return this.direction;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void init() {
        this.isSelected = false;
        this.index = 0;
    }
}

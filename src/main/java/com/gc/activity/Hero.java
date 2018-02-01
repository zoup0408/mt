package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.lang.reflect.Array;

public class Hero {
    public static int attack = 15;
    public static int blueKey = 0;
    public static int defence = 10;
    public static int direction = 1;
    private static Enemy e;
    public static int exp = 0;
    public static int gold = 0;
    public static int hp = 1000;
    private static String infoStr = "";
    public static boolean isChoiceFloor = false;
    public static boolean isDialog = false;
    public static boolean isEnemyInfo = false;
    public static boolean isExp = false;
    public static boolean isFly = false;
    public static boolean isHero = false;
    public static boolean isInfo = false;
    public static boolean isItem = false;
    public static boolean isSearch = false;
    public static boolean isStore = false;
    public static float left = -1.0f;
    private static String lostMsg;
    public static int maxFloor = 0;
    public static int redKey = 0;
    private static Bitmap tempImage = null;
    public static float top = -1.0f;
    public static int yellowKey = 0;
    private float distance = 0.0f;
    private float distanceSum;
    public Bitmap[][] heroFrame = ((Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{4, 4}));
    private int index = 0;
    private float[][] infoDown;
    private float[][] infoUP;
    private boolean isInit = false;
    private boolean isMove = false;
    private String[] message = new String[]{"相同颜色的钥匙开相同颜色的门", "第一层的武器到底该怎么得到呢?", "及时购买攻击和防御 可以减少不必要的损失", "第七层的经验商人很划算", "第八层的商店很划算", "怪物图鉴是个好东西,可以查看怪物的属性,获得后会在我右边显示!", "有楼层飞行器就不用爬楼梯了!", "通关有一定难度,要小心", "通关后有惊喜", "当你没有钥匙开门,打不过怪物的时候,就该考虑重新开始了"};
    private Paint p;
    private int screenWidth;
    private float speed = 6.0f;

    public Hero(Bitmap[][] heroFrame) {
        this.heroFrame = heroFrame;
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.infoUP = (float[][]) Array.newInstance(Float.TYPE, new int[]{15, 3});
        this.infoDown = (float[][]) Array.newInstance(Float.TYPE, new int[]{15, 3});
    }

    public void logic(boolean isSelect, int direction, int[][] floor) {
        if (!isDialog) {
            if (MySurfaceView.floor == 15 && Element.npcs.size() == 3) {
                ((Door) Element.getElementByType(ConstUtil.DOOR4)).isDead = true;
            }
            float x = ((float) this.screenWidth) - (11.0f * ConstUtil.MAPITEMWIDTH);
            int position_i = (int) (top / ConstUtil.MAPITEMWIDTH);
            int position_j = (int) ((left - x) / ConstUtil.MAPITEMWIDTH);
            switch (direction) {
                case 0:
                    position_i--;
                    break;
                case 1:
                    position_i++;
                    break;
                case 2:
                    position_j--;
                    break;
                case 3:
                    position_j++;
                    break;
                default:
                    break;
            }
            if (position_i < 0 || position_j < 0 || position_i >= floor.length || position_j >= floor[0].length) {
                if (this.distance == 0.0f) {
                    this.index = 0;
                } else {
                    moveOver();
                }
            } else if (floor[position_i][position_j] != 0 && (left - x) % ConstUtil.MAPITEMWIDTH == 0.0f && top % ConstUtil.MAPITEMWIDTH == 0.0f) {
                if (isSelect) {
                    direction = direction;
                    execEvent(position_i, position_j);
                }
            } else if (isSelect) {
                move(direction);
            } else {
                moveOver();
            }
        }
    }

    public void execEvent(int i, int j) {
        for (Element e : Element.npcs) {
            if (e.i == i && e.j == 11 - j) {
                if (e.type >= 100 && e.type <= ConstUtil.DOOR4) {
                    openDoor(e);
                    return;
                } else if (e.type >= 150 && e.type <= ConstUtil.ITEMEND) {
                    getItem(e);
                    return;
                } else if (e.type == 999) {
                    MySurfaceView.status = 1;
                    return;
                } else if (e.type == 1000) {
                    MySurfaceView.status = -1;
                    return;
                } else if (e.type >= 10 && e.type <= 37) {
                    System.out.println("敌人");
                    battle(e);
                    return;
                } else if (e.type >= 50 && e.type <= 53) {
                    NPC(e);
                    return;
                }
            }
        }
        if (Map.getMap(MySurfaceView.floor)[i][j] == 6) {
            isStore = true;
        }
    }

    public void openDoor(Element e) {
        switch (e.type) {
            case ConstUtil.DOOR1 /*100*/:
                if (yellowKey <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!e.isDead) {
                    yellowKey--;
                }
                e.isDead = true;
                return;
            case ConstUtil.DOOR2 /*101*/:
                if (blueKey <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!e.isDead) {
                    blueKey--;
                }
                e.isDead = true;
                return;
            case ConstUtil.DOOR3 /*102*/:
                if (redKey <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!e.isDead) {
                    redKey--;
                }
                e.isDead = true;
                return;
            case ConstUtil.DOOR4 /*103*/:
                infoStr = "该门无法开启!";
                break;
            default:
                break;
        }
        if (!e.isDead) {
            isItem = true;
            isDialog = true;
        }
    }

    public void getItem(Element e) {
        switch (e.type) {
            case 150:
                yellowKey++;
                e.over();
                infoStr = "获得黄钥匙";
                break;
            case ConstUtil.BLUEKEY /*151*/:
                blueKey++;
                e.over();
                infoStr = "获得蓝钥匙";
                break;
            case ConstUtil.REDKEY /*152*/:
                redKey++;
                e.over();
                infoStr = "获得红钥匙";
                break;
            case ConstUtil.ATTACT /*153*/:
                attack += 3;
                e.over();
                infoStr = "获得攻击之石:攻击力+3";
                break;
            case ConstUtil.DEFENCE /*154*/:
                defence += 3;
                e.over();
                infoStr = "获得防御之石:防御力+3";
                break;
            case ConstUtil.HP200 /*155*/:
                hp += 200;
                e.over();
                infoStr = "获得小血瓶:生命值增加200";
                break;
            case ConstUtil.HP500 /*156*/:
                hp += 500;
                e.over();
                infoStr = "获得大血瓶:生命值增加500";
                break;
            case ConstUtil.HP1000 /*157*/:
                hp += 1000;
                e.over();
                infoStr = "获得神之药水:生命值增加1000";
                break;
            case ConstUtil.HP2000 /*158*/:
                hp += 2000;
                e.over();
                infoStr = "获得圣之药水:生命值增加2000";
                break;
            case ConstUtil.SWORD15 /*159*/:
                attack += 15;
                e.over();
                infoStr = "获得铁剑,攻击力增加15";
                break;
            case ConstUtil.SWORD30 /*160*/:
                attack += 30;
                e.over();
                infoStr = "获得刚剑,攻击力增加30";
                break;
            case ConstUtil.SWORD45 /*161*/:
                attack += 45;
                e.over();
                infoStr = "获得青铜剑,攻击力增加45";
                break;
            case ConstUtil.SWORD60 /*162*/:
                attack += 60;
                e.over();
                infoStr = "获得玉石剑,攻击力增加60";
                break;
            case ConstUtil.SWORD120 /*163*/:
                attack += 120;
                e.over();
                infoStr = "获得玄铁剑,攻击力增加120";
                break;
            case ConstUtil.SHIELD15 /*164*/:
                defence += 15;
                e.over();
                infoStr = "获得铁盾,防御力增加15";
                break;
            case ConstUtil.SHIELD30 /*165*/:
                defence += 30;
                e.over();
                infoStr = "获得刚盾,防御力增加30";
                break;
            case ConstUtil.SHIELD45 /*166*/:
                defence += 45;
                e.over();
                infoStr = "获得青铜盾,防御力增加45";
                break;
            case ConstUtil.SHIELD60 /*167*/:
                defence += 60;
                e.over();
                infoStr = "获得玉石盾,防御力增加60";
                break;
            case ConstUtil.SHIELD120 /*168*/:
                defence += 120;
                e.over();
                infoStr = "获得玄铁盾,防御力增加120";
                break;
            case ConstUtil.INFO /*169*/:
                isSearch = true;
                e.over();
                infoStr = "获得怪物图鉴";
                break;
            case ConstUtil.FLY /*170*/:
                isFly = true;
                e.over();
                infoStr = "获得楼层飞行器";
                break;
            case ConstUtil.GOLD200 /*171*/:
                gold += 200;
                e.over();
                infoStr = "获得200金币";
                break;
        }
        isItem = true;
        isDialog = true;
    }

    public void battle(Element e) {
        int heroDamage = attack - ((Enemy) e).defence;
        int enemyDamage = ((Enemy) e).attack - defence;
        if (heroDamage <= 0) {
            infoStr = "你攻击太低，拒绝战斗!";
            isDialog = true;
            isItem = false;
            tempImage = e.NPCFrame[0];
        } else if (enemyDamage <= 0) {
            exp = ((Enemy) e).exp + exp;
            gold = ((Enemy) e).gold + gold;
            infoStr = "   战斗胜利            经验值 + " + ((Enemy) e).exp + ", 金币 + " + ((Enemy) e).gold;
            isDialog = true;
            isItem = false;
            tempImage = this.heroFrame[1][0];
            e.over();
        } else {
            int heroTimes;
            if (((Enemy) e).hp % heroDamage == 0) {
                heroTimes = ((Enemy) e).hp / heroDamage;
            } else {
                heroTimes = (((Enemy) e).hp / heroDamage) + 1;
            }
            if (heroTimes * enemyDamage >= hp) {
                infoStr = "你打不过我的，回去吧!";
                isDialog = true;
                isItem = false;
                tempImage = e.NPCFrame[0];
                return;
            }
            hp -= heroTimes * enemyDamage;
            exp = ((Enemy) e).exp + exp;
            gold = ((Enemy) e).gold + gold;
            infoStr = "   战斗胜利            经验值 + " + ((Enemy) e).exp + ", 金币 + " + ((Enemy) e).gold;
            isDialog = true;
            isItem = false;
            tempImage = this.heroFrame[1][0];
            e.over();
        }
    }

    public static void displayInfo(int i, int j) {
        int type = Map.getMap(MySurfaceView.floor)[i][j];
        if (type >= 10 && type <= 37) {
            Enemy e = (Enemy) Element.getElementByType(type);
            isEnemyInfo = true;
            e = e;
            if (e == null) {
                isEnemyInfo = false;
            } else if (attack <= e.defence) {
                lostMsg = "打不过!";
            } else if (e.attack <= defence) {
                lostMsg = "无损失!";
            } else {
                lostMsg = "生命损失 " + ((e.attack - defence) * (e.hp % (attack - e.defence) == 0 ? e.hp / (attack - e.defence) : (e.hp / (attack - e.defence)) + 1));
            }
        }
    }

    public void NPC(Element e) {
        if (e.type == 53) {
            infoStr = " 你来的正是时候,这几把钥匙你收好,去塔顶消灭大魔王吧!!!";
            isDialog = true;
            isItem = false;
            tempImage = e.NPCFrame[0];
            yellowKey += 2;
            blueKey += 2;
            redKey += 2;
            e.over();
        } else if (e.type == 50) {
            isExp = true;
        } else if (e.type == 6) {
            isStore = true;
        } else if (e.type == 52) {
            infoStr = "多谢勇士相救,我去帮你打开第一层的门!";
            tempImage = e.NPCFrame[0];
            isItem = false;
            isDialog = true;
            Map.setMap(1, 4, 3);
            Map.setMap(1, 4, 7);
            e.over();
        } else if (e.type == 51) {
            infoStr = "你好年轻人,送你红黄蓝钥匙各一把!祝你早日通关!";
            tempImage = e.NPCFrame[0];
            isItem = false;
            isDialog = true;
            yellowKey++;
            blueKey++;
            redKey++;
            e.over();
        }
        System.out.println("type -0----> " + e.type);
    }

    public void initPosition(int screenWidth, int floor) {
        if (!this.isInit) {
            this.isInit = true;
            this.distanceSum = ConstUtil.MAPITEMWIDTH;
            this.speed = this.distanceSum / 4.0f;
            this.screenWidth = screenWidth;
        }
    }

    public void initFloorHero() {
        this.infoUP[0][0] = ((float) this.screenWidth) - (8.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[0][1] = 6.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[0][2] = 3.0f;
        this.infoDown[0][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[0][1] = 4.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[0][2] = 1.0f;
        this.infoUP[1][0] = ((float) this.screenWidth) - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[1][1] = 9.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[1][2] = 3.0f;
        this.infoDown[1][0] = ((float) this.screenWidth) - (7.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[1][1] = 4.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[1][2] = 2.0f;
        this.infoUP[2][0] = ((float) this.screenWidth) - (7.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[2][1] = ConstUtil.MAPITEMWIDTH * 1.0f;
        this.infoUP[2][2] = 1.0f;
        this.infoDown[2][0] = ((float) this.screenWidth) - (4.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[2][1] = 8.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[2][2] = 0.0f;
        this.infoUP[3][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[3][1] = 8.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[3][2] = 0.0f;
        this.infoDown[3][0] = ((float) this.screenWidth) - (7.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[3][1] = 0.0f;
        this.infoDown[3][2] = 1.0f;
        this.infoUP[4][0] = ((float) this.screenWidth) - (2.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[4][1] = 0.0f;
        this.infoUP[4][2] = 2.0f;
        this.infoDown[4][0] = ((float) this.screenWidth) - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[4][1] = 0.0f;
        this.infoDown[4][2] = 3.0f;
        this.infoUP[5][0] = ((float) this.screenWidth) - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[5][1] = 0.0f;
        this.infoUP[5][2] = 3.0f;
        this.infoDown[5][0] = ((float) this.screenWidth) - (11.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[5][1] = 8.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[5][2] = 0.0f;
        this.infoUP[6][0] = ((float) this.screenWidth) - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[6][1] = 4.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[6][2] = 3.0f;
        this.infoDown[6][0] = ((float) this.screenWidth) - (2.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[6][1] = 3.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[6][2] = 2.0f;
        this.infoUP[7][0] = ((float) this.screenWidth) - (ConstUtil.MAPITEMWIDTH * 1.0f);
        this.infoUP[7][1] = ConstUtil.MAPITEMWIDTH * 1.0f;
        this.infoUP[7][2] = 1.0f;
        this.infoDown[7][0] = ((float) this.screenWidth) - (11.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[7][1] = ConstUtil.MAPITEMWIDTH * 1.0f;
        this.infoDown[7][2] = 1.0f;
        this.infoUP[8][0] = ((float) this.screenWidth) - (11.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[8][1] = 3.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[8][2] = 1.0f;
        this.infoDown[8][0] = ((float) this.screenWidth) - (2.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[8][1] = 9.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[8][2] = 2.0f;
        this.infoUP[9][0] = ((float) this.screenWidth) - (10.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[9][1] = 9.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[9][2] = 3.0f;
        this.infoDown[9][0] = ((float) this.screenWidth) - (2.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[9][1] = 9.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[9][2] = 2.0f;
        this.infoUP[10][0] = ((float) this.screenWidth) - (11.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[10][1] = 8.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[10][2] = 0.0f;
        this.infoDown[10][0] = ((float) this.screenWidth) - (ConstUtil.MAPITEMWIDTH * 1.0f);
        this.infoDown[10][1] = ConstUtil.MAPITEMWIDTH;
        this.infoDown[10][2] = 1.0f;
        this.infoUP[11][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[11][1] = 6.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[11][2] = 0.0f;
        this.infoDown[11][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[11][1] = 3.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[11][2] = 1.0f;
        this.infoUP[12][0] = ((float) this.screenWidth) - (ConstUtil.MAPITEMWIDTH * 1.0f);
        this.infoUP[12][1] = ConstUtil.MAPITEMWIDTH * 1.0f;
        this.infoUP[12][2] = 1.0f;
        this.infoDown[12][0] = ((float) this.screenWidth) - (7.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[12][1] = 5.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[12][2] = 1.0f;
        this.infoUP[13][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[13][1] = 7.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[13][2] = 0.0f;
        this.infoDown[13][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoDown[13][1] = 2.0f * ConstUtil.MAPITEMWIDTH;
        this.infoDown[13][2] = 1.0f;
        this.infoUP[14][0] = ((float) this.screenWidth) - (6.0f * ConstUtil.MAPITEMWIDTH);
        this.infoUP[14][1] = 6.0f * ConstUtil.MAPITEMWIDTH;
        this.infoUP[14][2] = 0.0f;
    }

    public void setPosition(int screenWidth, int floor) {
        if (maxFloor < floor) {
            maxFloor = floor;
        }
        if (MySurfaceView.status < 0) {
            direction = (int) this.infoDown[floor - 1][2];
            left = this.infoDown[floor - 1][0];
            top = this.infoDown[floor - 1][1];
        } else {
            direction = (int) this.infoUP[floor - 1][2];
            left = this.infoUP[floor - 1][0];
            top = this.infoUP[floor - 1][1];
        }
        this.screenWidth = screenWidth;
    }

    public void moveOver() {
        if (this.distance != 0.0f) {
            int i;
            if (this.index == 3) {
                i = 0;
            } else {
                i = this.index + 1;
                this.index = i;
            }
            this.index = i;
            this.distance += this.speed;
            if (this.distance == this.distanceSum) {
                this.distance = 0.0f;
            }
            if (direction == 0) {
                top -= this.speed;
            }
            if (direction == 1) {
                top += this.speed;
            }
            if (direction == 2) {
                left -= this.speed;
            }
            if (direction == 3) {
                left += this.speed;
                return;
            }
            return;
        }
        this.index = 0;
    }

    public void move(int direction) {
        if (!isDialog) {
            this.isMove = false;
            if (direction != direction) {
                if (this.distance == 0.0f) {
                    this.index = 0;
                    direction = direction;
                    this.isMove = false;
                } else {
                    this.isMove = true;
                    moveOver();
                }
            }
            if (!this.isMove) {
                int i;
                if (direction == 0) {
                    top -= this.speed;
                }
                if (direction == 1) {
                    top += this.speed;
                }
                if (direction == 2) {
                    left -= this.speed;
                }
                if (direction == 3) {
                    left += this.speed;
                }
                this.distance += this.speed;
                if (this.distance == this.distanceSum) {
                    this.distance = 0.0f;
                }
                if (this.index == 3) {
                    i = 0;
                } else {
                    i = this.index + 1;
                    this.index = i;
                }
                this.index = i;
            }
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.heroFrame[direction][this.index], null, new RectF(left, top, left + ConstUtil.MAPITEMWIDTH, top + ConstUtil.MAPITEMWIDTH), this.p);
        if (isHero) {
            infoStr = this.message[(int) (Math.random() * ((double) this.message.length))];
            tempImage = this.heroFrame[1][0];
            isDialog = true;
            isHero = false;
            isItem = false;
        } else if (isInfo) {
            infoStr = "请直接点击怪物进行信息查看!";
            isDialog = true;
            isInfo = false;
            isItem = true;
        }
        if (isDialog) {
            Dialog.draw(canvas, infoStr, tempImage);
        } else if (isChoiceFloor) {
            Dialog.drawFloorDialog(canvas);
            MySurfaceView.isDraw = true;
        } else if (isExp || isStore) {
            Dialog.drawExp(canvas);
        } else if (isEnemyInfo) {
            Dialog.drawEnemyInfo(canvas, e, lostMsg);
        }
    }
}

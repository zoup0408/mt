package com.gc.activity;

import android.content.res.Resources;

public class ItemFactory {
    public static Hero getHero(Resources res) {
        return new Hero(Image.getHeroBitmap(res));
    }

    public static Map getMap(Resources res) {
        return new Map(Image.getMapBitmap(res), Image.getStoreBitmap(res));
    }

    public static void setElement(Resources res, int[][] map, int floor) {
        Element.npcs.removeAll(Element.npcs);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Enemy enemy;
                NPC npc;
                Door door;
                Item item;
                Stair stair;
                switch (map[i][j]) {
                    case ConstUtil.ENEMY1 /*10*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 10), 10, floor);
                        break;
                    case 11:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 11), 11, floor);
                        break;
                    case ConstUtil.ENEMY3 /*12*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 12), 12, floor);
                        break;
                    case ConstUtil.ENEMY4 /*13*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 13), 13, floor);
                        break;
                    case ConstUtil.ENEMY5 /*14*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 14), 14, floor);
                        break;
                    case 15:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 15), 15, floor);
                        break;
                    case ConstUtil.ENEMY7 /*16*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 16), 16, floor);
                        break;
                    case ConstUtil.ENEMY8 /*17*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 17), 17, floor);
                        break;
                    case ConstUtil.ENEMY9 /*18*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 18), 18, floor);
                        break;
                    case ConstUtil.ENEMY10 /*19*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 19), 19, floor);
                        break;
                    case ConstUtil.ENEMY11 /*20*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 20), 20, floor);
                        break;
                    case ConstUtil.ENEMY12 /*21*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 21), 21, floor);
                        break;
                    case ConstUtil.ENEMY13 /*22*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 22), 22, floor);
                        break;
                    case ConstUtil.ENEMY14 /*23*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 23), 23, floor);
                        break;
                    case ConstUtil.ENEMY15 /*24*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 24), 24, floor);
                        break;
                    case ConstUtil.ENEMY16 /*25*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 25), 25, floor);
                        break;
                    case ConstUtil.ENEMY17 /*26*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 26), 26, floor);
                        break;
                    case ConstUtil.ENEMY18 /*27*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 27), 27, floor);
                        break;
                    case ConstUtil.ENEMY19 /*28*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 28), 28, floor);
                        break;
                    case ConstUtil.ENEMY20 /*29*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 29), 29, floor);
                        break;
                    case ConstUtil.ENEMY21 /*30*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 30), 30, floor);
                        break;
                    case ConstUtil.ENEMY22 /*31*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 31), 31, floor);
                        break;
                    case ConstUtil.ENEMY23 /*32*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 32), 32, floor);
                        break;
                    case ConstUtil.ENEMY24 /*33*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 33), 33, floor);
                        break;
                    case ConstUtil.ENEMY25 /*34*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 34), 34, floor);
                        break;
                    case ConstUtil.ENEMY26 /*35*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 35), 35, floor);
                        break;
                    case ConstUtil.ENEMY27 /*36*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 36), 36, floor);
                        break;
                    case ConstUtil.ENEMY28 /*37*/:
                        enemy = new Enemy(map[0].length - j, i, Image.getEnemyBitmap(res, 37), 37, floor);
                        break;
                    case ConstUtil.NPC1 /*50*/:
                        npc = new NPC(map[0].length - j, i, Image.getNPCBitmap(res, 50), 50, floor);
                        break;
                    case ConstUtil.NPC2 /*51*/:
                        npc = new NPC(map[0].length - j, i, Image.getNPCBitmap(res, 51), 51, floor);
                        break;
                    case ConstUtil.NPC3 /*52*/:
                        npc = new NPC(map[0].length - j, i, Image.getNPCBitmap(res, 52), 52, floor);
                        break;
                    case ConstUtil.NPC4 /*53*/:
                        npc = new NPC(map[0].length - j, i, Image.getNPCBitmap(res, 53), 53, floor);
                        break;
                    case ConstUtil.DOOR1 /*100*/:
                        door = new Door(map[0].length - j, i, Image.getDoorBitmap(res, 100), 100, floor);
                        break;
                    case ConstUtil.DOOR2 /*101*/:
                        door = new Door(map[0].length - j, i, Image.getDoorBitmap(res, ConstUtil.DOOR2), ConstUtil.DOOR2, floor);
                        break;
                    case ConstUtil.DOOR3 /*102*/:
                        door = new Door(map[0].length - j, i, Image.getDoorBitmap(res, ConstUtil.DOOR3), ConstUtil.DOOR3, floor);
                        break;
                    case ConstUtil.DOOR4 /*103*/:
                        door = new Door(map[0].length - j, i, Image.getDoorBitmap(res, ConstUtil.DOOR4), ConstUtil.DOOR4, floor);
                        break;
                    case 150:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, 150), 150, floor);
                        break;
                    case ConstUtil.BLUEKEY /*151*/:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, ConstUtil.BLUEKEY), ConstUtil.BLUEKEY, floor);
                        break;
                    case ConstUtil.REDKEY /*152*/:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, ConstUtil.REDKEY), ConstUtil.REDKEY, floor);
                        break;
                    case ConstUtil.ATTACT /*153*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.ATTACT), ConstUtil.ATTACT, floor);
                        break;
                    case ConstUtil.DEFENCE /*154*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.DEFENCE), ConstUtil.DEFENCE, floor);
                        break;
                    case ConstUtil.HP200 /*155*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.HP200), ConstUtil.HP200, floor);
                        break;
                    case ConstUtil.HP500 /*156*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.HP500), ConstUtil.HP500, floor);
                        break;
                    case ConstUtil.HP1000 /*157*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.HP1000), ConstUtil.HP1000, floor);
                        break;
                    case ConstUtil.HP2000 /*158*/:
                        item = new Item(map[0].length - j, i, Image.getStoneAndHPBitmap(res, ConstUtil.HP2000), ConstUtil.HP2000, floor);
                        break;
                    case ConstUtil.SWORD15 /*159*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SWORD15), ConstUtil.SWORD15, floor);
                        break;
                    case ConstUtil.SWORD30 /*160*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SWORD30), ConstUtil.SWORD30, floor);
                        break;
                    case ConstUtil.SWORD45 /*161*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SWORD45), ConstUtil.SWORD45, floor);
                        break;
                    case ConstUtil.SWORD60 /*162*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SWORD60), ConstUtil.SWORD60, floor);
                        break;
                    case ConstUtil.SWORD120 /*163*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SWORD120), ConstUtil.SWORD120, floor);
                        break;
                    case ConstUtil.SHIELD15 /*164*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SHIELD15), ConstUtil.SHIELD15, floor);
                        break;
                    case ConstUtil.SHIELD30 /*165*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SHIELD30), ConstUtil.SHIELD30, floor);
                        break;
                    case ConstUtil.SHIELD45 /*166*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SHIELD45), ConstUtil.SHIELD45, floor);
                        break;
                    case ConstUtil.SHIELD60 /*167*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SHIELD60), ConstUtil.SHIELD60, floor);
                        break;
                    case ConstUtil.SHIELD120 /*168*/:
                        item = new Item(map[0].length - j, i, Image.getSwordAndShieldBitmap(res, ConstUtil.SHIELD120), ConstUtil.SHIELD120, floor);
                        break;
                    case ConstUtil.INFO /*169*/:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, ConstUtil.INFO), ConstUtil.INFO, floor);
                        break;
                    case ConstUtil.FLY /*170*/:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, ConstUtil.FLY), ConstUtil.FLY, floor);
                        break;
                    case ConstUtil.GOLD200 /*171*/:
                        item = new Item(map[0].length - j, i, Image.getKeyFlyGoldBitmap(res, ConstUtil.GOLD200), ConstUtil.GOLD200, floor);
                        break;
                    case 999:
                        stair = new Stair(map[0].length - j, i, Image.getStairBitmap(res, 999)[0], 999, floor);
                        break;
                    case 1000:
                        stair = new Stair(map[0].length - j, i, Image.getStairBitmap(res, 1000)[0], 1000, floor);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

package com.gc.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

public class Image {
    public Image() {
        super();
    }

    public static Bitmap getBgBitmap(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("bg.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap getButton(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("button.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap[] getCtrlBitmap(Resources arg6) {
        Bitmap[] v2 = new Bitmap[5];
        String[] v3 = new String[]{"default.png", "default_up.png", "default_down.png", "default_left.png", "default_right.png"};
        int v1 = 0;
        try {
            while (v1 < v2.length) {
                v2[v1] = BitmapFactory.decodeStream(arg6.getAssets().open(v3[v1]));
                ++v1;
            }

            Bitmap[] v4_1 = v2;
            return v4_1;
        } catch (IOException v4) {
            v4.printStackTrace();
            return null;
        }
    }

    public static Bitmap getDialogBitmap(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("dialog.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap[] getDoorBitmap(Resources arg9, int arg10) {
        int v8 = 4;
        Bitmap[] v3 = new Bitmap[v8];
        try {
            Bitmap v1 = BitmapFactory.decodeStream(arg9.getAssets().open("door.png"));
            int v2;
            for (v2 = 0; v2 < v8; ++v2) {
                v3[v2] = Bitmap.createBitmap(v1, Image.logic(arg10) * v1.getHeight() / 4, v1.getHeight() * v2 / 4, v1.getWidth() / 4, v1.getHeight() / 4);
            }

            return v3;
        } catch (IOException v4) {
            v4.printStackTrace();
            return v3;
        }
    }

    public static Bitmap[] getEnemyBitmap(Resources arg9, int arg10) {
        int v8 = 4;
        Bitmap[] v3 = new Bitmap[v8];
        Bitmap v1 = null;
        switch (arg10) {
            case 10:
            case 11:
            case 12:
            case 13: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy01.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 14:
            case 15:
            case 16:
            case 17: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy02.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 18:
            case 19:
            case 20:
            case 21: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy03.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 22:
            case 23:
            case 24:
            case 25: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy04.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 26:
            case 27:
            case 28:
            case 29: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy05.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 30:
            case 31:
            case 32:
            case 33: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy06.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 34:
            case 35:
            case 36:
            case 37: {
                try {
                    v1 = BitmapFactory.decodeStream(arg9.getAssets().open("enemy07.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        int v2 = 0;
        while (v2 < v8) {
            try {
                v3[v2] = Bitmap.createBitmap(v1, v1.getHeight() * v2 / 4, Image.logic(arg10) * v1.getHeight() / 4, v1.getWidth() / 4, v1.getHeight() / 4);
                ++v2;
                continue;
            } catch (Exception v4) {
                label_59:
                v4.printStackTrace();
                return v3;
            }
        }

        return v3;
    }

    public static Bitmap getGrayFloorButton(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("graybutton.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap[][] getHeroBitmap(Resources arg11) {
        int v10 = 4;
        Bitmap[][] v1 = new Bitmap[v10][v10];
        try {
            Bitmap v2 = BitmapFactory.decodeStream(arg11.getAssets().open("hero.png"));
            int v3;
            for (v3 = 0; v3 < v10; ++v3) {
                int v4;
                for (v4 = 0; v4 < v10; ++v4) {
                    v1[v3][v4] = Bitmap.createBitmap(v2, v2.getWidth() * v4 / 4, v2.getHeight() * v3 / 4, v2.getWidth() / 4, v2.getHeight() / 4);
                }
            }
        } catch (IOException v5) {
            v5.printStackTrace();
        }

        return ((Bitmap[][]) v1);
    }

    public static Bitmap[] getInfoBitmap(Resources arg9) {
        int v8 = 8;
        Bitmap[] v3 = new Bitmap[v8];
        try {
            Bitmap v2 = BitmapFactory.decodeStream(arg9.getAssets().open("info.png"));
            int v1;
            for (v1 = 0; v1 < v8; ++v1) {
                v3[v1] = Bitmap.createBitmap(v2, v1 % 4 * v2.getWidth() / 4, v1 / 4 * v2.getHeight() / 2, v2.getWidth() / 4, v2.getHeight() / 2);
            }

            return v3;
        } catch (IOException v4) {
            v4.printStackTrace();
            return v3;
        }
    }

    public static Bitmap getKeyFlyGoldBitmap(Resources arg7, int arg8) {
        Bitmap v3_1;
        try {
            Bitmap v1 = BitmapFactory.decodeStream(arg7.getAssets().open("info.png"));
            v3_1 = Bitmap.createBitmap(v1, Image.logic(arg8) % 4 * v1.getWidth() / 4, Image.logic(arg8) / 4 * v1.getHeight() / 2, v1.getWidth() / 4, v1.getHeight() / 2);
        } catch (IOException v3) {
            v3.printStackTrace();
            v3_1 = null;
        }

        return v3_1;
    }

    public static Bitmap getLoadingBitmap(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("loading.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap[][] getMapBitmap(Resources arg12) {
        int v11 = 3;
        int v10 = 2;
        Bitmap[][] v3 = new Bitmap[v10][v11];
        try {
            Bitmap v4 = BitmapFactory.decodeStream(arg12.getAssets().open("map.png"));
            int v1;
            for (v1 = 0; v1 < v10; ++v1) {
                int v2;
                for (v2 = 0; v2 < v11; ++v2) {
                    v3[v1][v2] = Bitmap.createBitmap(v4, v4.getWidth() * v2 / 3, v4.getHeight() * v1 / 2, v4.getWidth() / 3, v4.getHeight() / 2);
                }
            }
        } catch (IOException v5) {
            v5.printStackTrace();
        }

        return ((Bitmap[][]) v3);
    }

    public static Bitmap getMenuBgBitmap(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("mainbg.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap getMenuButton(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("buttonwall.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static Bitmap[] getNPCBitmap(Resources arg9, int arg10) {
        int v8 = 4;
        Bitmap[] v3 = new Bitmap[v8];
        try {
            Bitmap v1 = BitmapFactory.decodeStream(arg9.getAssets().open("npc.png"));
            int v2;
            for (v2 = 0; v2 < v8; ++v2) {
                v3[v2] = Bitmap.createBitmap(v1, v1.getHeight() * v2 / 4, Image.logic(arg10) * v1.getHeight() / 4, v1.getWidth() / 4, v1.getHeight() / 4);
            }

            return v3;
        } catch (Exception v4) {
            v4.printStackTrace();
            return v3;
        }
    }

    public static Bitmap[] getStairBitmap(Resources res, int type) {
        Bitmap[] mapBitmap = new Bitmap[4];
        if (type == 999) {
            try {
                mapBitmap[0] = BitmapFactory.decodeStream(res.getAssets().open("up.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == 1000) {
            try {
                mapBitmap[0] = BitmapFactory.decodeStream(res.getAssets().open("down.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapBitmap;
    }


    public static Bitmap getStoneAndHPBitmap(Resources arg7, int arg8) {
        Bitmap v3_1;
        try {
            Bitmap v1 = BitmapFactory.decodeStream(arg7.getAssets().open("item1.png"));
            v3_1 = Bitmap.createBitmap(v1, Image.logic(arg8) % 2 * v1.getWidth() / 2, Image.logic(arg8) / 2 * v1.getHeight() / 3, v1.getWidth() / 2, v1.getHeight() / 3);
        } catch (IOException v3) {
            v3.printStackTrace();
            v3_1 = null;
        }

        return v3_1;
    }

    public static Bitmap[] getStoreBitmap(Resources arg9) {
        int v8 = 4;
        Bitmap[] v3 = new Bitmap[v8];
        try {
            Bitmap v2 = BitmapFactory.decodeStream(arg9.getAssets().open("store.png"));
            int v1;
            for (v1 = 0; v1 < v8; ++v1) {
                v3[v1] = Bitmap.createBitmap(v2, v2.getWidth() * v1 / 4, 0, v2.getWidth() / 4, v2.getHeight());
            }

            return v3;
        } catch (IOException v4) {
            v4.printStackTrace();
            return v3;
        }
    }

    public static Bitmap getSwordAndShieldBitmap(Resources arg7, int arg8) {
        Bitmap v3_1;
        try {
            Bitmap v1 = BitmapFactory.decodeStream(arg7.getAssets().open("item2.png"));
            v3_1 = Bitmap.createBitmap(v1, Image.logic(arg8) % 4 * v1.getWidth() / 4, Image.logic(arg8) / 4 * v1.getHeight() / 4, v1.getWidth() / 4, v1.getHeight() / 4);
        } catch (IOException v3) {
            v3.printStackTrace();
            v3_1 = null;
        }

        return v3_1;
    }

    public static Bitmap getTitle(Resources arg4) {
        Bitmap v2_1;
        try {
            v2_1 = BitmapFactory.decodeStream(arg4.getAssets().open("title.png"));
        } catch (IOException v2) {
            v2.printStackTrace();
            v2_1 = null;
        }

        return v2_1;
    }

    public static int logic(int arg5) {
        int v4 = 4;
        int v3 = 3;
        int v2 = 2;
        int v0 = 0;
        switch (arg5) {
            case 11:
            case 15:
            case 19:
            case 23:
            case 27:
            case 31:
            case 35: {
                v0 = 1;
                break;
            }
            case 12:
            case 16:
            case 20:
            case 24:
            case 28:
            case 32:
            case 36: {
                v0 = v2;
                break;
            }
            case 13:
            case 17:
            case 21:
            case 25:
            case 29:
            case 33:
            case 37: {
                v0 = v3;
                break;
            }
            case 51: {
                v0 = 1;
                break;
            }
            case 52: {
                v0 = v2;
                break;
            }
            case 53: {
                v0 = v3;
                break;
            }
            case 101: {
                v0 = 1;
                break;
            }
            case 102: {
                v0 = v2;
                break;
            }
            case 103: {
                v0 = v3;
                break;
            }
            case 151: {
                v0 = 1;
                break;
            }
            case 152: {
                v0 = v2;
                break;
            }
            case 154: {
                v0 = 1;
                break;
            }
            case 155: {
                v0 = v2;
                break;
            }
            case 156: {
                v0 = v3;
                break;
            }
            case 157: {
                v0 = v4;
                break;
            }
            case 158: {
                v0 = 5;
                break;
            }
            case 160: {
                v0 = 1;
                break;
            }
            case 161: {
                v0 = v2;
                break;
            }
            case 162: {
                v0 = v3;
                break;
            }
            case 163: {
                v0 = v4;
                break;
            }
            case 164: {
                v0 = 8;
                break;
            }
            case 165: {
                v0 = 9;
                break;
            }
            case 166: {
                v0 = 10;
                break;
            }
            case 167: {
                v0 = 11;
                break;
            }
            case 168: {
                v0 = 12;
                break;
            }
            case 169: {
                v0 = v4;
                break;
            }
            case 170: {
                v0 = 6;
                break;
            }
            case 171: {
                v0 = 7;
                break;
            }
        }

        return v0;
    }
}


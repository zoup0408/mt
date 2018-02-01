package com.gc.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Map {
    public static int[][] floor1;
    public static int[][] floor10;
    public static int[][] floor11;
    public static int[][] floor12;
    public static int[][] floor13;
    public static int[][] floor14;
    public static int[][] floor15;
    public static int[][] floor2;
    public static int[][] floor3;
    public static int[][] floor4;
    public static int[][] floor5;
    public static int[][] floor6;
    public static int[][] floor7;
    public static int[][] floor8;
    public static int[][] floor9;
    private Bitmap[][] maps;
    private Paint p;
    private Bitmap[] store;
    private int times;

    static {
        int[][] v0 = new int[10][];
        v0[0] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[1] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[2] = new int[]{3, 3, 1, 1, 1, 1, 1, 1, 1, 3, 3};
        v0[3] = new int[]{3, 3, 1, 160, 1, 999, 1, 165, 1, 3, 3};
        v0[4] = new int[]{3, 3, 1, 103, 1, 102, 1, 103, 1, 3, 3};
        int[] v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 1;
        v2[8] = 1;
        v2[9] = 3;
        v2[10] = 3;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 1;
        v2[7] = 53;
        v2[8] = 1;
        v2[9] = 3;
        v2[10] = 3;
        v0[6] = v2;
        v0[7] = new int[]{3, 3, 1, 1, 1, 1, 1, 1, 1, 3, 3};
        v0[8] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[9] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Map.floor1 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 159;
        v2[1] = 151;
        v2[2] = 1;
        v2[5] = 10;
        v2[6] = 10;
        v2[7] = 10;
        v0[0] = v2;
        int[] v1 = new int[11];
        v1[0] = 152;
        v1[2] = 1;
        v1[4] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[7] = 1;
        v1[8] = 1;
        v1[9] = 11;
        v1[10] = 11;
        v0[1] = v1;
        v1 = new int[11];
        v1[1] = 19;
        v1[2] = 1;
        v1[8] = 1;
        v1[9] = 169;
        v1[10] = 11;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 1;
        v1[1] = 100;
        v1[2] = 1;
        v1[4] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[8] = 1;
        v1[9] = 1;
        v1[10] = 1;
        v0[3] = v1;
        v2 = new int[11];
        v2[2] = 1;
        v2[5] = 999;
        v2[6] = 1;
        v2[8] = 100;
        v2[9] = 12;
        v2[10] = 12;
        v0[4] = v2;
        v2 = new int[11];
        v2[1] = 18;
        v2[2] = 101;
        v2[4] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 101;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 155;
        v2[1] = 155;
        v2[2] = 1;
        v2[5] = 150;
        v2[6] = 150;
        v2[7] = 150;
        v2[8] = 1;
        v0[6] = v2;
        v2 = new int[11];
        v2[0] = 153;
        v2[1] = 153;
        v2[2] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v0[7] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[1] = 1;
        v2[2] = 1;
        v2[4] = 1;
        v2[5] = 156;
        v2[6] = 154;
        v2[7] = 153;
        v2[8] = 1;
        v2[10] = 18;
        v0[8] = v2;
        v2 = new int[11];
        v2[0] = 1000;
        v2[4] = 1;
        v2[5] = 156;
        v2[6] = 154;
        v2[7] = 153;
        v2[8] = 102;
        v2[9] = 18;
        v2[10] = 151;
        v0[9] = v2;
        Map.floor2 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{155, 1, 155, 1, 1000, 1, 5, 6, 7, 1, 153};
        v1 = new int[11];
        v1[0] = 153;
        v1[1] = 1;
        v1[2] = 154;
        v1[3] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[8] = 1;
        v1[9] = 1;
        v1[10] = 153;
        v0[1] = v1;
        v1 = new int[11];
        v1[0] = 153;
        v1[1] = 1;
        v1[2] = 154;
        v1[3] = 1;
        v1[5] = 1;
        v1[6] = 18;
        v1[8] = 18;
        v1[9] = 101;
        v1[10] = 18;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 100;
        v1[1] = 1;
        v1[2] = 100;
        v1[3] = 1;
        v1[4] = 11;
        v1[5] = 1;
        v1[9] = 1;
        v1[10] = 154;
        v0[3] = v1;
        v2 = new int[11];
        v2[1] = 12;
        v2[3] = 1;
        v2[4] = 11;
        v2[5] = 1;
        v2[6] = 155;
        v2[8] = 155;
        v2[9] = 1;
        v2[10] = 154;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[1] = 101;
        v2[2] = 1;
        v2[3] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 100;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 1;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 151;
        v2[10] = 50;
        v0[6] = v2;
        v0[7] = new int[]{1, 100, 1, 1, 1, 1, 1, 14, 1, 100, 1};
        v2 = new int[11];
        v2[0] = 150;
        v2[1] = 12;
        v2[2] = 150;
        v2[3] = 1;
        v2[4] = 164;
        v2[5] = 156;
        v2[6] = 1;
        v2[8] = 1;
        v2[9] = 22;
        v2[10] = 155;
        v0[8] = v2;
        v0[9] = new int[]{150, 150, 150, 102, 19, 156, 1, 999, 1, 151, 152};
        Map.floor3 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 151;
        v2[1] = 22;
        v2[3] = 1;
        v2[5] = 999;
        v2[7] = 1;
        v2[8] = 153;
        v2[9] = 154;
        v2[10] = 153;
        v0[0] = v2;
        v1 = new int[11];
        v1[0] = 22;
        v1[1] = 1;
        v1[3] = 1;
        v1[5] = 1;
        v1[7] = 1;
        v1[8] = 22;
        v1[9] = 1;
        v1[10] = 22;
        v0[1] = v1;
        v1 = new int[11];
        v1[3] = 1;
        v1[5] = 13;
        v1[7] = 1;
        v1[9] = 15;
        v0[2] = v1;
        v0[3] = new int[]{1, 100, 1, 1, 1, 101, 1, 1, 1, 1, 101};
        v2 = new int[11];
        v2[0] = 150;
        v2[3] = 1;
        v2[4] = 14;
        v2[6] = 14;
        v2[7] = 1;
        v2[10] = 152;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[1] = 1;
        v2[2] = 15;
        v2[3] = 100;
        v2[5] = 1;
        v2[7] = 100;
        v2[8] = 26;
        v2[9] = 1;
        v2[10] = 1;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 151;
        v2[3] = 1;
        v2[4] = 14;
        v2[6] = 14;
        v2[7] = 1;
        v2[10] = 150;
        v0[6] = v2;
        v0[7] = new int[]{1, 101, 1, 1, 1, 102, 1, 1, 1, 100, 1};
        v2 = new int[11];
        v2[0] = 153;
        v2[1] = 15;
        v2[2] = 153;
        v2[3] = 1;
        v2[7] = 1;
        v2[8] = 154;
        v2[9] = 19;
        v2[10] = 154;
        v0[8] = v2;
        v2 = new int[11];
        v2[0] = 155;
        v2[1] = 155;
        v2[2] = 155;
        v2[3] = 1;
        v2[5] = 1000;
        v2[7] = 1;
        v2[8] = 151;
        v2[9] = 152;
        v2[10] = 151;
        v0[9] = v2;
        Map.floor4 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 999;
        v2[10] = 1000;
        v0[0] = v2;
        v0[1] = new int[]{1, 1, 1, 1, 1, 101, 1, 1, 1, 1, 1};
        v1 = new int[11];
        v1[0] = 19;
        v1[5] = 13;
        v1[10] = 19;
        v0[2] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 100;
        v1[3] = 1;
        v1[4] = 1;
        v1[5] = 102;
        v1[6] = 1;
        v1[7] = 1;
        v1[8] = 100;
        v1[9] = 1;
        v0[3] = v1;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 20;
        v2[3] = 156;
        v2[4] = 1;
        v2[5] = 14;
        v2[6] = 1;
        v2[7] = 156;
        v2[8] = 20;
        v2[9] = 1;
        v0[4] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 15;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v0[5] = v2;
        v0[6] = new int[]{13, 100, 151, 151, 1, 16, 1, 152, 24, 100, 13};
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 155;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v0[7] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 153;
        v2[3] = 153;
        v2[4] = 1;
        v2[5] = 155;
        v2[6] = 1;
        v2[7] = 154;
        v2[8] = 154;
        v2[9] = 1;
        v0[8] = v2;
        v0[9] = new int[]{22, 101, 23, 153, 1, 170, 1, 154, 23, 101, 22};
        Map.floor5 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 1000;
        v2[3] = 1;
        v2[4] = 26;
        v2[7] = 28;
        v2[10] = 150;
        v0[0] = v2;
        v1 = new int[11];
        v1[0] = 1;
        v1[1] = 1;
        v1[3] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[7] = 1;
        v1[8] = 1;
        v1[9] = 1;
        v0[1] = v1;
        v1 = new int[11];
        v1[3] = 1;
        v1[4] = 150;
        v1[5] = 1;
        v1[6] = 155;
        v1[7] = 23;
        v1[8] = 150;
        v1[9] = 1;
        v0[2] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 1;
        v1[3] = 1;
        v1[5] = 1;
        v1[6] = 155;
        v1[7] = 1;
        v1[8] = 102;
        v1[9] = 1;
        v1[10] = 151;
        v0[3] = v1;
        v2 = new int[11];
        v2[1] = 150;
        v2[4] = 23;
        v2[5] = 1;
        v2[6] = 16;
        v2[7] = 1;
        v2[8] = 27;
        v2[9] = 1;
        v0[4] = v2;
        v0[5] = new int[]{1, 1, 1, 1, 1, 1, 102, 1, 52, 1, 20};
        v2 = new int[11];
        v2[2] = 24;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 24;
        v0[6] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 16;
        v2[5] = 1;
        v2[8] = 150;
        v0[7] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 154;
        v2[3] = 1;
        v2[4] = 27;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 1;
        v0[8] = v2;
        v0[9] = new int[]{999, 1, 154, 100, 27, 101, 151, 151, 152, 153, 153};
        Map.floor6 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{171, 153, 153, 150, 150, 1, 157, 1, 155, 155, 155};
        v0[1] = new int[]{1, 1, 1, 1, 100, 1, 30, 1, 154, 27, 154};
        v0[2] = new int[]{1, 26, 26, 28, 28, 1, 100, 1, 1, 101, 1};
        v1 = new int[11];
        v1[0] = 1;
        v1[1] = 102;
        v1[2] = 1;
        v1[3] = 1;
        v1[4] = 1;
        v1[5] = 1;
        v1[10] = 999;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 1000;
        v2[6] = 28;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 1;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[1] = 1;
        v2[2] = 100;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[7] = 1;
        v2[9] = 100;
        v2[10] = 154;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[2] = 31;
        v2[5] = 1;
        v2[7] = 1;
        v2[9] = 1;
        v2[10] = 50;
        v0[6] = v2;
        v0[7] = new int[]{1, 151, 1, 1, 1, 1, 29, 101, 27, 1, 1};
        v2 = new int[11];
        v2[0] = 1;
        v2[2] = 1;
        v2[3] = 152;
        v2[4] = 152;
        v2[5] = 1;
        v2[6] = 153;
        v2[7] = 1;
        v2[9] = 1;
        v2[10] = 51;
        v0[8] = v2;
        v2 = new int[11];
        v2[0] = 1;
        v2[2] = 101;
        v2[3] = 152;
        v2[4] = 152;
        v2[5] = 1;
        v2[6] = 153;
        v2[7] = 1;
        v2[9] = 100;
        v2[10] = 154;
        v0[9] = v2;
        Map.floor7 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{999, 1, 161, 1, 5, 6, 7, 1, 166, 1, 1000};
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 156;
        v1[3] = 30;
        v1[4] = 1;
        v1[5] = 151;
        v1[6] = 1;
        v1[7] = 30;
        v1[8] = 156;
        v1[9] = 1;
        v0[1] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 1;
        v1[3] = 101;
        v1[4] = 1;
        v1[5] = 102;
        v1[6] = 1;
        v1[7] = 101;
        v1[8] = 1;
        v1[9] = 1;
        v0[2] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 150;
        v1[5] = 31;
        v1[8] = 150;
        v1[9] = 1;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 155;
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 155;
        v0[4] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 153;
        v2[3] = 153;
        v2[4] = 1;
        v2[6] = 1;
        v2[7] = 154;
        v2[8] = 154;
        v2[9] = 1;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 150;
        v2[1] = 1;
        v2[2] = 153;
        v2[3] = 31;
        v2[4] = 100;
        v2[6] = 100;
        v2[7] = 31;
        v2[8] = 154;
        v2[9] = 1;
        v2[10] = 150;
        v0[6] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 153;
        v2[3] = 153;
        v2[4] = 1;
        v2[5] = 30;
        v2[6] = 1;
        v2[7] = 154;
        v2[8] = 154;
        v2[9] = 1;
        v0[7] = v2;
        v0[8] = new int[]{155, 1, 1, 1, 1, 101, 1, 1, 1, 1, 155};
        v0[9] = new int[11];
        Map.floor8 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 151;
        v2[1] = 153;
        v2[2] = 32;
        v2[3] = 31;
        v2[5] = 1;
        v2[7] = 31;
        v2[8] = 32;
        v2[9] = 154;
        v2[10] = 151;
        v0[0] = v2;
        v0[1] = new int[]{1, 1, 1, 1, 102, 1, 101, 1, 1, 1, 1};
        v1 = new int[11];
        v1[0] = 1000;
        v1[1] = 1;
        v1[2] = 150;
        v1[3] = 101;
        v1[4] = 150;
        v1[5] = 1;
        v1[7] = 100;
        v1[8] = 155;
        v1[9] = 155;
        v1[10] = 1;
        v0[2] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 171;
        v1[3] = 1;
        v1[4] = 150;
        v1[5] = 100;
        v1[7] = 1;
        v1[8] = 155;
        v1[9] = 155;
        v1[10] = 1;
        v0[3] = v1;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v2[10] = 1;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 100;
        v2[1] = 1;
        v2[6] = 28;
        v2[10] = 1;
        v0[5] = v2;
        v0[6] = new int[]{100, 1, 101, 1, 1, 1, 1, 1, 1, 29, 1};
        v2 = new int[11];
        v2[0] = 100;
        v2[1] = 1;
        v2[3] = 30;
        v2[4] = 31;
        v2[5] = 31;
        v2[6] = 30;
        v2[8] = 1;
        v2[10] = 1;
        v0[7] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 102;
        v2[8] = 1;
        v2[10] = 1;
        v0[8] = v2;
        v2 = new int[11];
        v2[2] = 150;
        v2[3] = 151;
        v2[4] = 150;
        v2[5] = 151;
        v2[8] = 1;
        v2[10] = 999;
        v0[9] = v2;
        Map.floor9 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[1] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[2] = new int[]{3, 3, 3, 162, 3, 158, 3, 167, 3, 3, 3};
        v0[3] = new int[]{3, 3, 3, 102, 3, 102, 3, 102, 3, 3, 3};
        v0[4] = new int[]{3, 3, 3, 101, 3, 100, 3, 101, 3, 3, 3};
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 3;
        v2[8] = 3;
        v2[9] = 3;
        v2[10] = 3;
        v0[5] = v2;
        v0[6] = new int[]{3, 3, 3, 3, 3, 32, 3, 3, 3, 3, 3};
        v0[7] = new int[]{3, 3, 3, 3, 3, 32, 3, 3, 3, 3, 3};
        v0[8] = new int[]{3, 3, 3, 3, 3, 32, 3, 3, 3, 3, 3};
        v2 = new int[11];
        v2[0] = 1000;
        v2[10] = 999;
        v0[9] = v2;
        Map.floor10 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[0] = 33;
        v2[3] = 151;
        v2[6] = 25;
        v2[9] = 1;
        v2[10] = 999;
        v0[0] = v2;
        v1 = new int[11];
        v1[1] = 1;
        v1[2] = 1;
        v1[3] = 1;
        v1[4] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[7] = 1;
        v1[8] = 100;
        v1[9] = 1;
        v0[1] = v1;
        v1 = new int[11];
        v1[1] = 1;
        v1[4] = 150;
        v1[5] = 150;
        v1[6] = 150;
        v1[9] = 1;
        v1[10] = 151;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 156;
        v1[1] = 1;
        v1[3] = 1;
        v1[4] = 1;
        v1[5] = 1;
        v1[6] = 1;
        v1[7] = 1;
        v1[8] = 1;
        v1[9] = 1;
        v1[10] = 100;
        v0[3] = v1;
        v2 = new int[11];
        v2[1] = 1;
        v2[3] = 1;
        v2[4] = 153;
        v2[5] = 153;
        v2[6] = 21;
        v2[7] = 100;
        v2[9] = 1;
        v0[4] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[3] = 101;
        v2[4] = 21;
        v2[5] = 154;
        v2[6] = 154;
        v2[7] = 1;
        v2[9] = 1;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 25;
        v2[1] = 1;
        v2[2] = 1;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 1;
        v2[9] = 1;
        v2[10] = 21;
        v0[6] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[4] = 155;
        v2[5] = 155;
        v2[6] = 155;
        v2[9] = 1;
        v0[7] = v2;
        v2 = new int[11];
        v2[1] = 1;
        v2[2] = 100;
        v2[3] = 1;
        v2[4] = 1;
        v2[5] = 1;
        v2[6] = 1;
        v2[7] = 1;
        v2[8] = 1;
        v2[9] = 1;
        v0[8] = v2;
        v2 = new int[11];
        v2[0] = 1000;
        v2[1] = 1;
        v2[4] = 33;
        v2[7] = 152;
        v2[10] = 25;
        v0[9] = v2;
        Map.floor11 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[1] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v1 = new int[11];
        v1[0] = 3;
        v1[1] = 3;
        v1[5] = 999;
        v1[9] = 3;
        v1[10] = 3;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 3;
        v1[1] = 3;
        v1[2] = 102;
        v1[3] = 3;
        v1[7] = 3;
        v1[8] = 102;
        v1[9] = 3;
        v1[10] = 3;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 154;
        v2[3] = 3;
        v2[5] = 34;
        v2[7] = 3;
        v2[8] = 153;
        v2[9] = 3;
        v2[10] = 3;
        v0[4] = v2;
        v0[5] = new int[]{3, 3, 154, 3, 3, 101, 3, 3, 153, 3, 3};
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 154;
        v2[3] = 3;
        v2[7] = 3;
        v2[8] = 153;
        v2[9] = 3;
        v2[10] = 3;
        v0[6] = v2;
        v0[7] = new int[]{3, 3, 154, 3, 150, 1000, 150, 3, 153, 3, 3};
        v0[8] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[9] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Map.floor12 = v0;
        v0 = new int[10][];
        v2 = new int[11];
        v2[2] = 34;
        v2[5] = 35;
        v2[8] = 37;
        v2[9] = 3;
        v2[10] = 1000;
        v0[0] = v2;
        v1 = new int[11];
        v1[0] = 37;
        v1[1] = 3;
        v1[2] = 3;
        v1[3] = 3;
        v1[4] = 3;
        v1[5] = 3;
        v1[6] = 3;
        v1[7] = 3;
        v1[9] = 3;
        v0[1] = v1;
        v1 = new int[11];
        v1[1] = 3;
        v1[2] = 37;
        v1[5] = 34;
        v1[7] = 3;
        v1[9] = 3;
        v0[2] = v1;
        v1 = new int[11];
        v1[1] = 3;
        v1[3] = 3;
        v1[4] = 3;
        v1[5] = 3;
        v1[7] = 3;
        v1[8] = 34;
        v1[9] = 3;
        v1[10] = 34;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 35;
        v2[1] = 3;
        v2[3] = 3;
        v2[4] = 999;
        v2[5] = 3;
        v2[6] = 35;
        v2[7] = 3;
        v2[9] = 3;
        v0[4] = v2;
        v2 = new int[11];
        v2[1] = 3;
        v2[2] = 35;
        v2[3] = 3;
        v2[7] = 3;
        v2[9] = 3;
        v0[5] = v2;
        v2 = new int[11];
        v2[1] = 3;
        v2[3] = 3;
        v2[4] = 3;
        v2[5] = 3;
        v2[6] = 3;
        v2[7] = 3;
        v2[8] = 35;
        v2[9] = 3;
        v2[10] = 35;
        v0[6] = v2;
        v2 = new int[11];
        v2[0] = 34;
        v2[1] = 3;
        v2[3] = 34;
        v2[6] = 37;
        v2[9] = 3;
        v0[7] = v2;
        v2 = new int[11];
        v2[1] = 3;
        v2[2] = 3;
        v2[3] = 3;
        v2[4] = 3;
        v2[5] = 3;
        v2[6] = 3;
        v2[7] = 3;
        v2[8] = 3;
        v2[9] = 3;
        v0[8] = v2;
        v2 = new int[11];
        v2[1] = 37;
        v2[4] = 35;
        v2[7] = 34;
        v2[10] = 35;
        v0[9] = v2;
        Map.floor13 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v1 = new int[11];
        v1[0] = 3;
        v1[4] = 3;
        v1[5] = 999;
        v1[6] = 3;
        v1[10] = 3;
        v0[1] = v1;
        v1 = new int[11];
        v1[0] = 3;
        v1[2] = 3;
        v1[4] = 3;
        v1[6] = 3;
        v1[8] = 3;
        v1[10] = 3;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 3;
        v1[2] = 3;
        v1[4] = 3;
        v1[5] = 36;
        v1[6] = 3;
        v1[8] = 3;
        v1[10] = 3;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 3;
        v2[2] = 3;
        v2[4] = 3;
        v2[6] = 3;
        v2[8] = 3;
        v2[10] = 3;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[2] = 3;
        v2[4] = 37;
        v2[6] = 37;
        v2[8] = 3;
        v2[10] = 3;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[2] = 3;
        v2[3] = 3;
        v2[4] = 3;
        v2[6] = 3;
        v2[7] = 3;
        v2[8] = 3;
        v2[10] = 3;
        v0[6] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[2] = 3;
        v2[3] = 3;
        v2[4] = 3;
        v2[6] = 3;
        v2[7] = 3;
        v2[8] = 3;
        v2[10] = 3;
        v0[7] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[3] = 163;
        v2[4] = 3;
        v2[5] = 1000;
        v2[6] = 3;
        v2[7] = 168;
        v2[10] = 3;
        v0[8] = v2;
        v0[9] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Map.floor14 = v0;
        v0 = new int[10][];
        v0[0] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        v0[1] = new int[]{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        v1 = new int[11];
        v1[0] = 3;
        v1[1] = 2;
        v1[2] = 36;
        v1[4] = 2;
        v1[5] = 17;
        v1[6] = 2;
        v1[8] = 36;
        v1[9] = 2;
        v1[10] = 3;
        v0[2] = v1;
        v1 = new int[11];
        v1[0] = 3;
        v1[1] = 2;
        v1[2] = 2;
        v1[4] = 2;
        v1[5] = 103;
        v1[6] = 2;
        v1[8] = 2;
        v1[9] = 2;
        v1[10] = 3;
        v0[3] = v1;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 2;
        v2[8] = 2;
        v2[9] = 3;
        v2[10] = 3;
        v0[4] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 3;
        v2[2] = 2;
        v2[8] = 2;
        v2[9] = 3;
        v2[10] = 3;
        v0[5] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 2;
        v2[2] = 2;
        v2[4] = 2;
        v2[6] = 2;
        v2[8] = 2;
        v2[9] = 2;
        v2[10] = 3;
        v0[6] = v2;
        v2 = new int[11];
        v2[0] = 3;
        v2[1] = 2;
        v2[2] = 36;
        v2[4] = 2;
        v2[5] = 1000;
        v2[6] = 2;
        v2[8] = 36;
        v2[9] = 2;
        v2[10] = 3;
        v0[7] = v2;
        v0[8] = new int[]{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        v0[9] = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Map.floor15 = v0;
    }

    public Map(Bitmap[][] arg3, Bitmap[] arg4) {
        super();
        this.maps = new Bitmap[2][3];
        this.store = new Bitmap[4];
        this.times = 0;
        this.maps = arg3;
        this.store = arg4;
        this.p = new Paint();
        this.p.setAntiAlias(true);
    }

    public void draw(Canvas canvas, int screenWidth, int num) {
        int[][] floor = getMap(num);
        for (int i = floor.length - 1; i >= 0; i--) {
            for (int j = floor[i].length - 1; j >= 0; j--) {
                RectF rect = new RectF(((float) screenWidth) - (ConstUtil.MAPITEMWIDTH * ((float) (floor[i].length - j))), ConstUtil.MAPITEMWIDTH * ((float) i), (((float) screenWidth) - (ConstUtil.MAPITEMWIDTH * ((float) (floor[i].length - j)))) + ConstUtil.MAPITEMWIDTH, (ConstUtil.MAPITEMWIDTH * ((float) i)) + ConstUtil.MAPITEMWIDTH);
                if (floor[i][j] == 1) {
                    canvas.drawBitmap(this.maps[0][1], null, rect, this.p);
                } else if (floor[i][j] == 2) {
                    canvas.drawBitmap(this.maps[0][0], null, rect, this.p);
                } else if (floor[i][j] == 3) {
                    canvas.drawBitmap(this.maps[1][0], null, rect, this.p);
                } else if (floor[i][j] == 4) {
                    canvas.drawBitmap(this.maps[1][0], null, rect, this.p);
                } else {
                    canvas.drawBitmap(this.maps[1][2], null, rect, this.p);
                    if (floor[i][j] == 5) {
                        canvas.drawBitmap(this.store[0], null, rect, this.p);
                    } else if (floor[i][j] == 6) {
                        this.times++;
                        if (this.times < 10) {
                            canvas.drawBitmap(this.store[1], null, rect, this.p);
                        } else {
                            this.times = this.times == 20 ? 0 : this.times;
                            canvas.drawBitmap(this.store[3], null, rect, this.p);
                        }
                    } else if (floor[i][j] == 7) {
                        canvas.drawBitmap(this.store[2], null, rect, this.p);
                    }
                }
            }
        }
    }

    public static int[][] getMap(int arg1) {
        int[][] v0;
        switch(arg1) {
            case 1: {
                v0 = Map.floor1;
                break;
            }
            case 2: {
                v0 = Map.floor2;
                break;
            }
            case 3: {
                v0 = Map.floor3;
                break;
            }
            case 4: {
                v0 = Map.floor4;
                break;
            }
            case 5: {
                v0 = Map.floor5;
                break;
            }
            case 6: {
                v0 = Map.floor6;
                break;
            }
            case 7: {
                v0 = Map.floor7;
                break;
            }
            case 8: {
                v0 = Map.floor8;
                break;
            }
            case 9: {
                v0 = Map.floor9;
                break;
            }
            case 10: {
                v0 = Map.floor10;
                break;
            }
            case 11: {
                v0 = Map.floor11;
                break;
            }
            case 12: {
                v0 = Map.floor12;
                break;
            }
            case 13: {
                v0 = Map.floor13;
                break;
            }
            case 14: {
                v0 = Map.floor14;
                break;
            }
            case 15: {
                v0 = Map.floor15;
                break;
            }
            default: {
                v0 = null;
                break;
            }
        }

        return v0;
    }

    public static void setMap(int arg2, int arg3, int arg4) {
        switch(arg2) {
            case 1: {
                Map.floor1[arg3][arg4] = 0;
                break;
            }
            case 2: {
                Map.floor2[arg3][arg4] = 0;
                break;
            }
            case 3: {
                Map.floor3[arg3][arg4] = 0;
                break;
            }
            case 4: {
                Map.floor4[arg3][arg4] = 0;
                break;
            }
            case 5: {
                Map.floor5[arg3][arg4] = 0;
                break;
            }
            case 6: {
                Map.floor6[arg3][arg4] = 0;
                break;
            }
            case 7: {
                Map.floor7[arg3][arg4] = 0;
                break;
            }
            case 8: {
                Map.floor8[arg3][arg4] = 0;
                break;
            }
            case 9: {
                Map.floor9[arg3][arg4] = 0;
                break;
            }
            case 10: {
                Map.floor10[arg3][arg4] = 0;
                break;
            }
            case 11: {
                Map.floor11[arg3][arg4] = 0;
                break;
            }
            case 12: {
                Map.floor12[arg3][arg4] = 0;
                break;
            }
            case 13: {
                Map.floor13[arg3][arg4] = 0;
                break;
            }
            case 14: {
                Map.floor14[arg3][arg4] = 0;
                break;
            }
            case 15: {
                Map.floor15[arg3][arg4] = 0;
                break;
            }
        }
    }

    public static void setMapInfo(int arg1, int arg2, int arg3, int arg4) {
        switch(arg1) {
            case 1: {
                Map.floor1[arg2][arg3] = arg4;
                break;
            }
            case 2: {
                Map.floor2[arg2][arg3] = arg4;
                break;
            }
            case 3: {
                Map.floor3[arg2][arg3] = arg4;
                break;
            }
            case 4: {
                Map.floor4[arg2][arg3] = arg4;
                break;
            }
            case 5: {
                Map.floor5[arg2][arg3] = arg4;
                break;
            }
            case 6: {
                Map.floor6[arg2][arg3] = arg4;
                break;
            }
            case 7: {
                Map.floor7[arg2][arg3] = arg4;
                break;
            }
            case 8: {
                Map.floor8[arg2][arg3] = arg4;
                break;
            }
            case 9: {
                Map.floor9[arg2][arg3] = arg4;
                break;
            }
            case 10: {
                Map.floor10[arg2][arg3] = arg4;
                break;
            }
            case 11: {
                Map.floor11[arg2][arg3] = arg4;
                break;
            }
            case 12: {
                Map.floor12[arg2][arg3] = arg4;
                break;
            }
            case 13: {
                Map.floor13[arg2][arg3] = arg4;
                break;
            }
            case 14: {
                Map.floor14[arg2][arg3] = arg4;
                break;
            }
            case 15: {
                Map.floor15[arg2][arg3] = arg4;
                break;
            }
        }
    }
}


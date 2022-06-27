package LeetCode;

import java.util.Random;

public class L497 {
    //每个矩形的面积不同,按照面积加权随机出这次的点所在的矩形
    int[][] rects;
    int[] sumArea;
    Random random;

    public L497(int[][] rects) {
        this.rects = rects;
        sumArea = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int a = rects[i][0], b = rects[i][1], x = rects[i][2], y = rects[i][3];
            int area = (x - a + 1) * (y - b + 1);
            if (i == 0) {
                sumArea[i] = area;
            } else {
                sumArea[i] = sumArea[i - 1] + area;
            }
        }
    }

    public int[] pick() {
        random = new Random();
        int target = random.nextInt(sumArea[sumArea.length - 1]);
        //找到第一个大于等于该点的sumArea[i],该点即落在i号矩形内
        int l = 0, r = sumArea.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > sumArea[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //落在第l号矩形内
        int a = rects[l][0], b = rects[l][1], x = rects[l][2], y = rects[l][3];
        int xIndex = random.nextInt(x - a + 1);
        int yIndex = random.nextInt(y - b + 1);
        return new int[]{a + xIndex, b + yIndex};
    }
}

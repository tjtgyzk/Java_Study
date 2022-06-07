package LeetCode.SwardOffer.II;

public class OfferII_73 {
    public int minEatingSpeed(int[] piles, int h) {
        //二分查找,速度从[1,max(piles)],找到第一个满足curtime<=h的数字
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int curTime = getTime(piles, mid);
            if (curTime > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int getTime(int[] piles, int speed) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / speed;
            if (piles[i] % speed != 0) {
                time++;
            }
        }
        return time;
    }
}

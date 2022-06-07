package LeetCode;

public class L875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int i = 0; i < piles.length; i++) {
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }
        int l = 1, r = maxSpeed;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (getTime(piles, mid) > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int getTime(int[] piles, int speed) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            ans += piles[i] / speed;
            if (piles[i] % speed != 0) {
                ans++;
            }
        }
        return ans;
    }
}

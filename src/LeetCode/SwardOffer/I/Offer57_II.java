package LeetCode.SwardOffer.I;

import java.util.ArrayList;
import java.util.List;

public class Offer57_II {
    public int[][] findContinuousSequence(int target) {
        //l,r都只会向右
        List<int[]> list = new ArrayList<int[]>();
        int l = 1;
        int r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) {
                r++;
            } else if (sum > target) {
                l++;
            } else {
                int[] ints = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    ints[i - l] = i;
                }
                list.add(ints);
                l++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        new Offer57_II().findContinuousSequence(9);
    }
}

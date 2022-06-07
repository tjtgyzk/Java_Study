package LeetCode.SwardOffer.II;

import java.util.Arrays;
import java.util.LinkedList;

public class OfferII_74 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.pollLast();
            int[] thisOne = intervals[i];
            if (last[1] >= thisOne[0]) {
                last[1] = Math.max(thisOne[1], last[1]);
                list.addLast(last);
            } else {
                list.add(last);
                list.add(thisOne);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

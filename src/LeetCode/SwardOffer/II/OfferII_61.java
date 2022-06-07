package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class OfferII_61 {
    //已知最小是(0,0),可以把所有可能放入堆中,每次弹出堆的是当前最小(i,j),接下来加入的可能性只有(i+1,j)或者(i,j+1)
    //为了防止重复,应该固定i或者j不动,先把所有(i,0)加入,之后只变动j即可
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]])));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            que.add(new int[]{i, 0});
        }
        while (k-- > 0 && !que.isEmpty()) {
            int[] index = que.poll();
            List<Integer> curAns = new ArrayList<>();
            curAns.add(nums1[index[0]]);
            curAns.add(nums2[index[1]]);
            ans.add(curAns);
            if (index[1] + 1 < nums2.length) {
                index[1]++;
                que.add(index);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_61().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}

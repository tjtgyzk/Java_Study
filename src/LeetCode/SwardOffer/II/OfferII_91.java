package LeetCode.SwardOffer.II;

import java.util.HashMap;
import java.util.Map;

public class OfferII_91 {
    int ans = Integer.MAX_VALUE;
    Map<String, Integer> map = new HashMap<>();

    public int minCost(int[][] costs) {
        dfs(costs, 0, -1, 0);
        return ans;
    }

    /**
     * @param costs 花费
     * @param index 第几个房子
     * @param no    不能选择的颜色
     */
    public void dfs(int[][] costs, int index, int no, int curCost) {
        String key = "" + index + no + curCost;
        if (map.containsKey(key)) {
            ans = Math.min(ans, map.get(key));
            return;
        }
        if (index == costs.length) {
            ans = Math.min(ans, curCost);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i != no) {
                dfs(costs, index + 1, i, curCost + costs[index][i]);
            }
        }
        map.put(key, ans);
        return;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_91().minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
    }


    public int minCost1(int[][] costs) {
        //dp[i][0] 代表 第i间房子涂红色时 前i+1间房子累计所需的 最小成本；
        //dp[i][1] 代表 第i间房子涂蓝色时 前i+1间房子累计所需的 最小成本；
        //dp[i][2] 代表 第i间房子涂绿色时 前i+1间房子累计所需的 最小成本；
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
}

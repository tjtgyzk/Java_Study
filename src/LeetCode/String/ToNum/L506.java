package LeetCode.String.ToNum;

import java.util.Arrays;

public class L506 {
    public String[] findRelativeRanks(int[] score) {
        int[][] player = new int[score.length][2];

        for (int i = 0; i < score.length; i++) {
            player[i][0] = i;
            player[i][1] = score[i];
        }
        Arrays.sort(player, (a, b) -> (b[1] - a[1]));
        String[] ans = new String[score.length];


        for (int i = 0; i < player.length; i++) {
            if (i == 0) {
                ans[player[0][0]] = "Gold Medal";
            } else if (i == 1) {
                ans[player[1][0]] = "Silver Medal";
            } else if (i == 2) {
                ans[player[2][0]] = "Bronze Medal";
            } else {
                ans[player[i][0]] = String.valueOf(i + 1);
            }
        }


        return ans;
    }
}

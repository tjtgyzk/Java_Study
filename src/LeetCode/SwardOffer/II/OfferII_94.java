package LeetCode.SwardOffer.II;

import java.util.Arrays;

public class OfferII_94 {
    public int minCut(String s) {
        //dp[i]表示从[0..i]的最少分割次数
        //如果[0...i]为回文字符串,则最少分割次数为0
        //如果[0...i]不是回文字符串,则找到j,使得[j+1...i]为回文串,从j处分割,dp[i] = dp[j] + 1;
        //首先通过动态规划找到所有的g[i][j]是否是回文子串
        boolean[][] g = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            g[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                g[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i + 1 < 3 || g[i + 1][j - 1]);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (g[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        //可能有不同的结果,比如abbab,在最后一个b时前面可能拆成abba,b和a,b,bab
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_94().minCut("abbab"));
    }
}

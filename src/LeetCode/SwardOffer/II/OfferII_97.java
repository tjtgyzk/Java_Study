package LeetCode.SwardOffer.II;

public class OfferII_97 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        //dp[i,j]表示s的[0..i-1]的子序列在中t[0..i-1]出现的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i && j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //如果s(i-1)==t(i-1)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];//考虑当前的s是否和t匹配
                } else {

                    //如果s(i-1)!=t(i-1)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_97().numDistinct("rabb", "rab"));
    }
}

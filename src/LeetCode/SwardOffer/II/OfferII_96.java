package LeetCode.SwardOffer.II;

public class OfferII_96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        //dp[i][j] 表示s1中[0..i-1] s2中[0..j-1]能否交织出s3中[0..i+j-1]
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j]) ||
                        ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

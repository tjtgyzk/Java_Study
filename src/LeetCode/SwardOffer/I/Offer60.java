package LeetCode.SwardOffer.I;

import java.util.Arrays;

public class Offer60 {
    public double[] dicesProbability(int n) {
        //dp[i][j]表示用i个骰子掷出点数j
        //dp[1][1-6]均为1/6
        //i:1到n
        //j:n到6*n
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int m = 1; m <= 6; m++) {
                    if (j - m > 0) {
                        dp[i][j] += dp[i - 1][j - m];
                    }
                }
                dp[i][j] /= 6.0;
            }
        }
        return Arrays.copyOfRange(dp[n], n, 6 * n + 1);
    }
}

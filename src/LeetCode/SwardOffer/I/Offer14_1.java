package LeetCode.SwardOffer.I;

public class Offer14_1 {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int cut = 0;
        int noCut = n;
        for (int i = 2; i < n; i++) {
            int twoCut = i * (n - i);
            int multiCut = i * cuttingRope(n - i);
            cut = Math.max(cut, Math.max(twoCut, multiCut));
        }
        return Math.max(cut, noCut);
    }

    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                //只剪一次,长度为j
                int twoCut = j * (i - j);
                //剩下的i-j长度也去剪
                int multiCut = j * (dp[i - j]);
                dp[i] = Math.max(dp[i], Math.max(twoCut, multiCut));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int a = new Offer14_1().cuttingRope2(8);
        System.out.println(a);
    }
}

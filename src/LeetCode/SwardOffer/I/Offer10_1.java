package LeetCode.SwardOffer.I;

public class Offer10_1 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
        //也可以用滚动数组,使用三个变量实现
    }

    public static void main(String[] args) {
        System.out.println(new Offer10_1().fib(48));
    }
}

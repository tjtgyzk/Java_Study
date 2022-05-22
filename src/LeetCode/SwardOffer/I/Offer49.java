package LeetCode.SwardOffer.I;

public class Offer49 {
    public int nthUglyNumber(int n) {
        //每一个丑数都是由之前的丑数乘2,3,5得来的,最初的丑数为1
        //1产生2,3,5
        //2产生4,6,10
        //以此类推...每个丑数都由之前的某一个丑数乘2,3,5得到,并且每个丑数作为基数时只被乘一次,第n个丑数是min(2*p2,3*p3,5*p5),p2,p3,p5初始都为指向第一个丑数的下标1
        //dp[i]表示第i个丑数,dp[0]无意义
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = 2 * dp[p2], num2 = 3 * dp[p3], num3 = 5 * dp[p5];
            dp[i] = Math.min(num1, Math.min(num2, num3));
            //这里不用else if即考虑了去重问题,如果dp[p2] = 3,dp[p3] = 2,则num1和num2都等于6,即p2和p3位置的数都失去了再乘2和3的机会,一起++
            if (dp[i] == num1) {
                p2++;
            }
            if (dp[i] == num2) {
                p3++;
            }
            if (dp[i] == num3) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Offer49().nthUglyNumber(10);
    }
}

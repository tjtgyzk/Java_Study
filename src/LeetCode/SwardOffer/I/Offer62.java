package LeetCode.SwardOffer.I;

public class Offer62 {
    public int lastRemaining(int n, int m) {
        //如果只有1个孩子0,则它存活
        //从0开始数的第m个孩子为走m-1步后的孩子,删除它之后从m开始继续数m-1步,删除下一个孩子
        //f(n-1)中存活的孩子必在f(n)中存活,假设f(n-1)=x,即走x-1步后找到,它在f(n)中的位置为 (m+(x-1)%(n-1))%n
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (m + ans % (i - 1)) % i;
        }
        return ans;
    }
}

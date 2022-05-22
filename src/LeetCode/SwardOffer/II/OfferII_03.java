package LeetCode.SwardOffer.II;

public class OfferII_03 {
    public int[] countBits1(int n) {
        //方法一:BrainKernighan算法
        //x & (x-1) 会消掉x最右侧的1
        //每次消掉x最右侧的1,直到x为0,操作次数即为1的个数,对于每个x时间复杂度为O(logn),故时间复杂度为O(n*logn)
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                num &= (num - 1);
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public int[] countBits2(int n) {
        //方法二:动态规划
        //对于每个奇数:最右侧为1,前一个数最右侧为0,相对于前一个数只有这一个变化,故dp[n] = do[n-1] + 1;
        //对于每个偶数:最右侧为0,右移一位即为n/2,对1的个数无影响,故dp[n] = dp[n/2]
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = i % 2 == 0 ? ans[i / 2] : ans[i - 1] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_03().countBits1(5));

    }
}

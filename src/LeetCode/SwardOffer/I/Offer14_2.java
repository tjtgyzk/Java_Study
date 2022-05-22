package LeetCode.SwardOffer.I;

public class Offer14_2 {
    public int cuttingRope(int n) {
        //贪心算法  可以通过数学证明得知当等于3的绳子段数越多，乘积越大
        if (n < 4) {
            return n - 1;
        } else if (n == 4) {
            return 4;
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);

    }
}

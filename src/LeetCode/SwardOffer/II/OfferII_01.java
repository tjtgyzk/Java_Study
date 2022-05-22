package LeetCode.SwardOffer.II;

public class OfferII_01 {
    public int divide(int a, int b) {
        //你故意找茬是不是?
        if (a == -2147483648 && b == -1) {
            return 2147483647;
        }
        if (b == -2147483648) {
            return a == -2147483648 ? 1 : 0;
        }
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        if (b == 1) {
            return a;
        }
        if (b == -1) {
            return -a;
        }
        boolean flag = false;
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            flag = true;
        }
        int ans = 0;
        a = -Math.abs(a);
        b = -Math.abs(b);
        while (a <= b) {
            a -= b;
            ans++;
        }
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        int a = new OfferII_01().divide(15, 2);
        System.out.println(a);
    }
}

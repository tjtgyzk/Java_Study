package LeetCode.SwardOffer.II;

public class OfferII_72 {
    public int mySqrt(int x) {
        //从[1,x]找到第一个不满足i平方<=x的数,即第一个>x的数
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_72().mySqrt(24));
    }
}

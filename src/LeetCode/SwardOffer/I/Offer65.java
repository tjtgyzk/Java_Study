package LeetCode.SwardOffer.I;

public class Offer65 {
    public int add(int a, int b) {
        //a^b可以求得无进位加法m
        //a&b<<1可以求得所有进位n
        //接下来就是求m+n,由于不能用加法,我们递归以上过程,直到进位为0无需加法,直接返回
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}

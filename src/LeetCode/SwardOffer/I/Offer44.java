package LeetCode.SwardOffer.I;

public class Offer44 {
    public int findNthDigit(int n) {
        //k位数一共占多少字符位:
        //1位数:1-9               每个数字占1位  *  数字数量9个            = 9个
        //2位数:10-99             每个数字占2位  *  数字数量90个           = 180个
        //k位数:10^(k-1)-10^k-1   每个数字占k位  *  数字数量9*10^(k-1)个   = 9*k*10^(k-1)个 = number
        //首先令n不断-number,直到n<number位置,此时起始点为10^(k-1)(第0个),对应数字为第(n-1)/k个,对应这个数字的第(n-1)%k位
        int k = 1;
        long nums = 9 * k * (long) Math.pow(10, k - 1);
        while (n > nums) {
            n -= nums;
            k++;
            nums = 9 * k * (long) Math.pow(10, k - 1);
        }
        Long num = ((long) Math.pow(10, k - 1)) + (n - 1) / k;
        int i = (n - 1) % k;
        return Integer.parseInt((Character.toString(num.toString().charAt(i))));
    }

    public static void main(String[] args) {
        new Offer44().findNthDigit(15);
    }
}

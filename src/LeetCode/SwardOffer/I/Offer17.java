package LeetCode.SwardOffer.I;

public class Offer17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] res = new int[max];
        int num = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = num++;
        }
        return res;
    }
}

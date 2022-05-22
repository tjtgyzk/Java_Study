package LeetCode.SwardOffer.I;

public class Offer10_2 {
    public int numWays(int n) {
        int n1 = 1;
        int n2 = 1;
        for (int i = 2; i <= n; i++) {
            int n3 = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(new Offer10_2().numWays(44));
    }
}

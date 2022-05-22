package LeetCode.SwardOffer.I;

public class Offer13 {
    public int movingCount(int m, int n, int k) {
        //注意,有障碍的格子走不了,所以有的符合条件的格子走不到
        boolean[][] can = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (numCount(i) > k) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (numCount(j) > k) {
                    break;
                }
                if (numCount(j) + numCount(i) <= k && ((i == 0 || can[i - 1][j]) || (j == 0 || can[i][j - 1]))) {
                    can[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numCount(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = new Offer13().movingCount(38, 15, 9);
        System.out.println(a);
    }
}

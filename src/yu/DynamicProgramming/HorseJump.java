package yu.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HorseJump {
    public static int function1(int a, int b, int k) {
        if (a < 0 || a > 9 || b < 0 || b > 8 || k < 0) {
            return 0;
        }
        return process(0, 0, a, b, k);
    }

    public static int process(int x, int y, int a, int b, int rest) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        if (rest == 0) {
            return (x == a && y == b) ? 1 : 0;
        }
        int ans = 0;
        ans += process(x - 2, y - 1, a, b, rest - 1);
        ans += process(x - 2, y + 1, a, b, rest - 1);
        ans += process(x + 2, y - 1, a, b, rest - 1);
        ans += process(x + 2, y + 1, a, b, rest - 1);
        ans += process(x - 1, y - 2, a, b, rest - 1);
        ans += process(x - 1, y + 2, a, b, rest - 1);
        ans += process(x + 1, y - 2, a, b, rest - 1);
        ans += process(x + 1, y + 2, a, b, rest - 1);
        return ans;
    }

    public static int function2(int a, int b, int k) {
        if (a < 0 || a > 9 || b < 0 || b > 8 || k < 0) {
            return 0;
        }
        //x:0-9 y:0-8 rest:0-k
        int[][][] dp = new int[10][9][k + 1];
        dp[a][b][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    dp[x][y][rest] += pick(dp, x + 2, y + 1, rest - 1);
                    dp[x][y][rest] += pick(dp, x + 2, y - 1, rest - 1);
                    dp[x][y][rest] += pick(dp, x - 2, y + 1, rest - 1);
                    dp[x][y][rest] += pick(dp, x - 2, y - 1, rest - 1);
                    dp[x][y][rest] += pick(dp, x + 1, y + 2, rest - 1);
                    dp[x][y][rest] += pick(dp, x + 1, y - 2, rest - 1);
                    dp[x][y][rest] += pick(dp, x - 1, y - 2, rest - 1);
                    dp[x][y][rest] += pick(dp, x - 1, y + 2, rest - 1);
                }
            }
        }
        return dp[0][0][k];
    }

    public static int pick(int[][][] arr, int x, int y, int rest) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return arr[x][y][rest];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 5;
        int step = 10;
        System.out.println(function1(x, y, step));
        System.out.println(function2(x, y, step));
        Map<Character, Integer> map = new HashMap<>();
        map.containsKey
    }
}

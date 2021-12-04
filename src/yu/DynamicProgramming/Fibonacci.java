package yu.DynamicProgramming;

public class Fibonacci {
    public static int process(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return process(N - 1) + process(N - 2);
    }

    public static int process1(int N, int[] map) {
        if (map[N] != 0) {
            return map[N];
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int ans = process1(N - 1, map) + process1(N - 2, map);
        map[N] = ans;
        return ans;
    }

    public static int function1(int N) {
        int[] map = new int[N + 1];
        return process1(N, map);
    }

    public static void main(String[] args) {
        System.out.println(process(7));
        System.out.println(function1(7));
        System.out.println(function2(7));
    }

    public static int function2(int N) {
        int[] map = new int[N + 1];
        map[1] = 1;
        map[2] = 1;
        for (int i = 3; i <= N; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[N];
    }
}

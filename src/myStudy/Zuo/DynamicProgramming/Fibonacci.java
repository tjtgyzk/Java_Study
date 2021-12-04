package myStudy.Zuo.DynamicProgramming;

public class Fibonacci {
    //1,1,2,3,5,8,……
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
        int p1 = process1(N - 1, map);
        int p2 = process1(N - 2, map);
        map[N] = p1 + p2;

        return p1 + p2;
    }

    public static void main(String[] args) {
        System.out.println(process(7));
        int[] map = new int[8];
        System.out.println(process1(7, map));
    }
}

package myStudy.Zuo.ShuaTi.Day01;

public class Near2Power {
    public static int getNear2Power(int n) {
        if (n <= 0) {
            return 1;
        }
        n -= 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n == Integer.MAX_VALUE ? Integer.MAX_VALUE : n + 1;

    }

    public static void main(String[] args) {
        System.out.println(getNear2Power(165));
    }

}

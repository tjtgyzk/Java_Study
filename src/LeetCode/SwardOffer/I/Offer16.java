package LeetCode.SwardOffer.I;

public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        boolean flag = n > 0;
        double ans = 1;
        n = Math.abs(n);
        while (n > 0) {
            ans *= x;
            n--;
        }
        return flag ? ans : 1 / ans;


    }

    //快速幂
    //递归
    //先计算x的N/2次,如果N为奇数,还需要多乘一个x
    public double function2(double x, int n) {
        long N = n;
        return N > 0 ? process(x, N) : 1 / process(x, -N);
    }

    public double process(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = process(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    //迭代
    //通过x不断的平方,计算每个x的贡献值
    //假设n=77
    // x---x^2---x^4---x^9(额外添加一个x)---x^19(额外添加一个x)---x^38---x^77(额外添加一个x)
    // 这里总共平方了6次,第一个x参与了全部6次平方,贡献了2^6 = 64个x
    // 第二个加入的x参与了3次平方,贡献了2^3 = 8个x
    // 第三个加入的x参与了2次平方,贡献了2^2 = 4个x
    // 最后一个加入的x没有参与平方,只贡献了1个x
    // 64+8+4+1=77个x,刚好等于n,也就是n的二进制1001101中1所在的位置
    // 故有 x^n = x^(2^i0)*x^(2^i1)*...*x^(2^ik) 在此例中,i0 = 1,i1 = 4,i2 =8,i3 = 64
    // x的"贡献"不断平方,假设平方m次,当次的结果即为x^(2^m),所以在n的最低位为1时,让结果乘上当前的数字,当n==0时结束,即可得到答案
    public double function(double x, int n) {
        long N = n;
        boolean flag = N > 0;
        N = Math.abs(N);
        double contribut = x;
        double ans = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) {
                //最低位为1
                ans *= contribut;
            }
            //每次将贡献平方
            contribut *= contribut;
            N >>= 1;
        }
        return flag ? ans : 1 / ans;
    }


    public static void main(String[] args) {
        System.out.println(new Offer16().myPow(2, 3));
    }
}

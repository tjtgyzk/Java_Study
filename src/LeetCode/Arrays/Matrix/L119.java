package LeetCode.Arrays.Matrix;

import java.util.LinkedList;
import java.util.List;

public class L119 {
    public static List<Integer> getRow(int rowIndex) {
        //当然可以递推计算出来,这里采用另一种方法
        //杨辉三角的第n层的第i个数,其实就是组合数C(n,i)的值
        //根据组合数公式C(n,i) = n!/i!(n-i)!
        //例如C(5,2) 一般计算采用 5*4/2*1 ,即为(5*4*3*2*1)/(3*2*1)(2*1)
        //C(n,i-1) = n!/(i-1)!(n-i+1)!
        //所以C(n,i) = C(n,i-1) * (n-i+1)/i
        //已知C(n,0) = 1;即可递推计算后面所有数
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            //n = rowIndex,i = i
            //这里可能会溢出,中间值用long存储
            //注意list.getlast也要取long,不然用int算完溢出了赋给long也是负数
            long cur = (long) list.getLast() * (rowIndex - i + 1) / i;
            list.add((int) cur);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(30));
    }
}

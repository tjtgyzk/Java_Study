package myStudy.dataStructure.Zuo.mergeTi;

import java.util.HashMap;

public class LeetCode327 {
    public static void main(String[] args) {

        int[] arr = {-2147483647, 0, -2147483647, 2147483647};
        System.out.println(process(arr, -564, 3864));
    }

    public static int process(int[] arr, int lower, int upper) {
        long[] sum = new long[arr.length];//防止加减导致int溢出
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {//防止下标越界，先定义好sum[0]，之后可以用sum[i-1]
            sum[i] = arr[i] + sum[i - 1];
        }
        int L = 0, R = sum.length - 1;
        // int mid = L + ((R - L) >> 1);
        return count(sum, L, R, lower, upper);
    }

    public static int count(long[] sum, int l, int r, int lower, int upper) {
        if (l == r) {//如果l=r，即为arr中（0，l）之和
            return (sum[l] <= upper && sum[l] >= lower) ? 1 : 0;
        }
        int mid = (l + r) / 2;
        int n1 = count(sum, l, mid, lower, upper);
        int n2 = count(sum, mid + 1, r, lower, upper);
        int res = n1 + n2;
        int WindowL = l;//左侧数组指针
        int WindowR = l;//左侧数组指针
        for (int i = mid + 1; i <= r; i++) {//遍历右侧数组
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (WindowL <= mid && sum[WindowL] < min) {//找到第一个大于等于min的位置停下来
                WindowL++;
            }
            while (WindowR <= mid && sum[WindowR] <= max) {//找到第一个大于max的位置停下来
                WindowR++;
            }
            res += WindowR - WindowL;
        }
        //做排序
        long[] help = new long[r - l + 1];
        int li = l, ri = mid + 1, hi = 0;
        while (li <= mid && ri <= r) {
            help[hi++] = sum[li] < sum[ri] ? sum[li++] : sum[ri++];
        }
        while (li <= mid) {
            help[hi++] = sum[li++];
        }
        while (ri <= r) {
            help[hi++] = sum[ri++];
        }
        for (int i = 0; i < help.length; i++) {
            sum[l + i] = help[i];
        }
        return res;
    }

}


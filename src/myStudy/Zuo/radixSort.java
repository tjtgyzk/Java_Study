package myStudy.Zuo;

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] arr = {412, 652, 774, 123, 896, 310, 1024, 2048, 421, 563};
        raSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void raSort(int[] arr) {
        //取得最大值
        int maxarr = Integer.MIN_VALUE;
        for (int num : arr) {
            maxarr = Math.max(num, maxarr);
        }
        //取得位数
        int digit = 0;
        while (maxarr > 0) {
            digit++;
            maxarr /= 10;
        }
        //排序
        for (int d = 1; d <= digit; d++) {//有多少位就进行多少次循环
            int[] count = new int[10]; //count数组
            for (int num : arr) {//遍历数组，找到对应位数出现次数
                count[getDigit(num, d)]++;
            }
            //前缀和数组
            int[] countSum = new int[10];
            countSum[0] = count[0];
            for (int i = 1; i < countSum.length; i++) {
                countSum[i] = countSum[i - 1] + count[i];
            }
            //从右向左遍历数组
            int[] help = new int[arr.length];//辅助空间
            for (int i = arr.length - 1; i >= 0; i--) {
                int j = getDigit(arr[i], d);
                help[--countSum[j]] = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = help[i];
            }

        }
    }

    public static int getDigit(int num, int digit) {//用于获取数字的第digit位
        return ((num / (int) Math.pow(10, digit - 1)) % 10);
    }

}

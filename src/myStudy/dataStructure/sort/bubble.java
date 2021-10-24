package myStudy.dataStructure.sort;

import java.util.Arrays;

public class bubble {


    public static void BubbleSort(int[] arr) {
        boolean flag = false;//代码优化，如果在一次大循环中未发生过交换，可以看做排序完成，直接退出循环
        for (int i = 0; i < arr.length - 1; i++) {//只需要循环数组长度-1次，即可完成排序
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {//每次循环都可以确定最后一位数，所以每次遍历比上次少一次，故-i
                if (arr[j] > arr[j + 1]) {//如果后一位数更小，与前一位数交换次序
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (flag == false) {
                break;
            }
        }
    }
}

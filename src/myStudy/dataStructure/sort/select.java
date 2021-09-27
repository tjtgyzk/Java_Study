package myStudy.dataStructure.sort;

import java.util.Arrays;

public class select {

    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//进行size-1次循环，每次循环找到其中的最小值，与当前的序列头部交换
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {//从当前头部开始，遍历剩余数组，找到最小值
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            //交换
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}

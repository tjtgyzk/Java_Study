package myStudy.dataStructure.Zuo;

import myStudy.dataStructure.sort.bubble;
import myStudy.dataStructure.sort.insertion;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean res = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = getRandomArray(maxSize, maxValue);
            int[] arr1 = arr;
            int[] arr2 = arr;
            bubble.BubbleSort(arr1);
            insertion.InserationSortZ(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("Wrong");
                System.out.println(arr);
            }
        }
        System.out.println(res ? "Nice" : "FuckU");
    }

    public static int[] getRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//生成随机长度的数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1.equals(arr2)) {
            return true;
        } else {
            return false;
        }
    }

}

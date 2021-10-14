package myStudy.dataStructure.Zuo.QuickTi;

import java.util.Arrays;

public class Holland {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 2, 7, 9, 0, 4, 2, 1, 7};
        process(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void process(int[] arr, int x) {
        int l = -1;
        int r = arr.length;
        int i = 0;
        while (i < r) {
            if (arr[i] < x) {
                swap(arr, ++l, i++);
            } else if (arr[i] > x) {
                swap(arr, i, --r);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

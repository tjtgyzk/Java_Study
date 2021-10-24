package myStudy.Zuo.QuickTi;

import java.util.Arrays;

public class QuicKsort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        int l = 0, r = arr.length - 1;
        partition(arr, l, r);
    }


    public static void partition(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int target = arr[l + (int) Math.random() * (r - l + 1)];
        int less = l - 1;
        int more = r + 1;
        int index = l;
        while (index < more) {
            if (arr[index] < target) {
                swap(arr, index++, ++less);
            } else if (arr[index] > target) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        //   int[] base =  {less + 1, more - 1};
        partition(arr, l, less);
        partition(arr, more, r);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

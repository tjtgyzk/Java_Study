package myStudy.dataStructure.Zuo;

import java.util.Arrays;

public class Demo01_findK {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 11, 15};
        System.out.println(findK(arr, 5));
    }

    public static boolean findK(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) >> 1;
            if (arr[mid] == k) {
                return true;
            } else if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] == k;
    }

}

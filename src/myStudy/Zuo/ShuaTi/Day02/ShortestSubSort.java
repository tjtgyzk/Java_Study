package myStudy.Zuo.ShuaTi.Day02;

public class ShortestSubSort {
    public static int getShortest(int[] arr) {
        int maxLeft = arr[0];
        int minRight = arr[arr.length - 1];
        int stop = -1;
        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < maxLeft) {
                stop = i;
            } else {
                maxLeft = arr[i];
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > minRight) {
                begin = i;
            } else {
                minRight = arr[i];
            }
        }
        return stop - begin + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 3, 2, 3, 10, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("arr1:" + getShortest(arr1) + "\n"
                + "arr2:" + getShortest(arr2) + "\n"
                + "arr3:" + getShortest(arr3));
    }
}

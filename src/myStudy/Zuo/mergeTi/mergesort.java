package myStudy.Zuo.mergeTi;

import java.util.Arrays;

public class mergesort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 6, 3, 2};
        merge2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        //int mid = l + ((r - l) >> 1);
        int ti = 0, li = l, ri = mid + 1;
        while (li <= mid && ri <= r) {
            temp[ti++] = arr[li] < arr[ri] ? arr[li++] : arr[ri++];
        }
        while (li <= mid) {
            temp[ti++] = arr[li++];
        }
        while (ri <= r) {
            temp[ti++] = arr[ri++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void merge2(int[] arr) {
        int rate = 1, N = arr.length - 1;
        while (rate < N) {
            int L = 0;
            while (L <= N) {
                int M = L + rate - 1;
                if (M > N) {
                    break;
                }
                int R = Math.min(N, M + rate);
                merge(arr, L, M, R);
                L = R + 1;
            }
            rate <<= 1;
        }
    }
}

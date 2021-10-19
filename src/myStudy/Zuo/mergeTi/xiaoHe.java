package myStudy.Zuo.mergeTi;

public class xiaoHe {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        System.out.println(mergeSort(arr, 0, 4));
    }

    // static int sum = 0;
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);

    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int sum = 0;
        //int mid = l + ((r - l) >> 1);
        int ti = 0, li = l, ri = mid + 1;
        while (li <= mid && ri <= r) {
            sum += arr[li] < arr[ri] ? (arr[li] * (r - ri + 1)) : 0;
            temp[ti++] = arr[li] < arr[ri] ? arr[li++] : arr[ri++];//若相等，先拷贝右组
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
        return sum;
    }
}

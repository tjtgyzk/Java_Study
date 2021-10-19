package myStudy.Zuo.mergeTi;

public class nixudui {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 2, 1};
        System.out.println(mergeSort(arr, 0, 4));
    }

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
        //int mid = l + ((r - l) >> 1);
        int num = 0;
        int ti = 0, li = l, ri = mid + 1;
        while (li <= mid && ri <= r) {
            num += arr[ri] < arr[li] ? (mid - li + 1) : 0;
            temp[ti++] = arr[li] <= arr[ri] ? arr[li++] : arr[ri++];//相等时，先拷贝左边
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
        return num;
    }
}

package myStudy.Zuo.mergeTi;

public class RightMchu2 {
    public static void main(String[] args) {
        int[] arr = {7, 7, 1, 3, 2};
        System.out.println(mergeSort(arr, 0, 4));
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return
                mergeSort(arr, l, mid)
                        + mergeSort(arr, mid + 1, r)
                        + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int P = mid + 1, L = l, res = 0;
        for (int i = 0; i < mid - L + 1; i++) {//遍历左侧数组
            while (P <= r && 2 * arr[P] < arr[i]) {
                P++;
            }
            res += P - (mid + 1);
        }
        int[] temp = new int[r - l + 1];
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
        return res;
    }
}

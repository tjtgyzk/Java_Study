package yu;

public class Tirtle {
    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 2, 9, 2, 3, 5, 60, 1, 0, 2, 3, -8};
        System.out.println(findMax(arr, 0, arr.length - 1));
    }

    public static int findMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = findMax(arr, l, mid);
        int ringtMiax = findMax(arr, mid + 1, r);
        return Math.max(leftMax, ringtMiax);
    }
}

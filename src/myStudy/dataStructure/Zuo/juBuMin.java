package myStudy.dataStructure.Zuo;

public class juBuMin {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 7, 8};
        System.out.println(FindMin(arr));
    }

    public static int FindMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        if (arr[0] < arr[1]) {
            return arr[0];
        } else if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        } else {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid] > arr[mid - 1]) {
                    r = mid - 1;
                } else if (arr[mid] > arr[mid + 1]) {
                    l = mid + 1;
                }
            }
            return arr[l];
        }
    }
}

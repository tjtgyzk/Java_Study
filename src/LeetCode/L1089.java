package LeetCode;

public class L1089 {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[i] == 0) {
                i++;
                j += 2;
            } else {
                i++;
                j++;
            }
        }
        j--;
        i--;
        if (j == arr.length) {
            arr[--j] = 0;
            j--;
            i--;
        }
        while (i >= 0) {
            if (arr[i] == 0) {
                arr[j--] = 0;
                arr[j--] = 0;
                i--;
            } else {
                arr[j--] = arr[i--];
            }
        }
    }

    public static void main(String[] args) {
        new L1089().duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }
}

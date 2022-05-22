package LeetCode.SwardOffer.I;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        int[] ans = new int[m * n];
        int i = 0;
        while (left <= right && up <= down) {
            for (int j = left; j <= right; j++) {
                ans[i++] = matrix[up][j];
            }
            for (int j = up + 1; j <= down; j++) {
                ans[i++] = matrix[j][right];
            }
            if (left < right && up < down) {
                for (int j = right - 1; j >= left; j--) {
                    ans[i++] = matrix[down][j];
                }
                for (int j = down - 1; j >= up + 1; j--) {
                    ans[i++] = matrix[j][left];
                }
            }
            up++;
            left++;
            down--;
            right--;
        }
        return ans;

    }
}

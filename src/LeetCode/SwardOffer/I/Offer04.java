package LeetCode.SwardOffer.I;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //首先能确定的是,某个点的左上所有点都比它小,其余位置都比它大
        //需要找到一个位置,比如最右上角的点,向下都比它大,向左都比它小,如此搜索可以不重不漏
        //同理左下角的点也行,向上都比它小,向右都比它大
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int r = m - 1;
        int l = 0;
        while (l < n && r >= 0) {
            if (matrix[l][r] > target) {
                r--;
            } else if (matrix[l][r] < target) {
                l++;
            } else {
                return true;
            }
        }
        return false;

    }
}

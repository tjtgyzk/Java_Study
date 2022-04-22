package LeetCode.Arrays.MatrixDifferent;

public class L59 {
    public int[][] generateMatrix(int n) {
        //此题明确为方阵反而简单了一点
        int[][] ans = new int[n][n];
        int l = 0;
        int u = 0;
        int cur = 1;
        for (int i = n; i >= 1; i -= 2) {
            //i为当前层的边长
            //从左到右填i个,从上到下填i-1个,从右到左填i-1个,从下到上填i-2个
            //每一层的起始位置为(l,h)
            int r = l + i - 1;
            int d = u + i - 1;
            for (int j = l; j <= r; j++) {
                ans[u][j] = cur++;
            }
            for (int j = u + 1; j <= d; j++) {
                ans[j][r] = cur++;
            }
            for (int j = r - 1; j >= l; j--) {
                ans[d][j] = cur++;
            }
            for (int j = d - 1; j >= u + 1; j--) {
                ans[j][l] = cur++;
            }
            l++;
            u++;
        }
        return ans;
    }
}

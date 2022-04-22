package LeetCode.Arrays.AreaSum;

public class L304 {
    //二维前缀和
    //sum[i][j]表示从(0,0)开始到(i,j)的矩形内元素的累加和
    //先算每行的累加和,然后加上上一行同样位置的值
    //所以求(r1,c1)到(r2,c2)的和为:sum[r2,c2] - sum[r2,c1-1] - sum[r1-1,c2] + sum[r1-1,c1-1]
    //见图解
    static class NumMatrix {
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sum = new int[m][n];
            //先算出来第一行
            sum[0][0] = matrix[0][0];
            for (int i = 1; i < n; i++) {
                sum[0][i] = sum[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < m; i++) {
                sum[i][0] = matrix[i][0] + sum[i - 1][0];
                for (int j = 1; j < n; j++) {
                    //(sum[i][j - 1] - sum[i - 1][j - 1])为本行前一格中,只考虑此行的前缀和,减掉了上一行的影响
                    //加上matrix[i][j]为本行当前位置的前缀和,加上sum[i-1][j](上一行同一列的前缀和)即为从(0,0)开始到(i,j)的矩形内元素的累加和
                    sum[i][j] = sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j] + sum[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return sum[row2][col2];
            }
            if (row1 == 0) {
                return sum[row2][col2] - sum[row2][col1 - 1];
            }
            if (col1 == 0) {
                return sum[row2][col2] - sum[row1 - 1][col2];
            }
            return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{7, 7, 0}, {-4, -7, 7}, {-4, 0, -2}, {-8, -5, 6}};
        NumMatrix numMatrix = new NumMatrix(matrix1);
        System.out.println(numMatrix.sumRegion(1, 0, 2, 2));
    }
}

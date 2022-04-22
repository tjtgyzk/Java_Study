package LeetCode.Arrays.MatrixChange;

public class L566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        //如果元素个数一样,则合法
        //对于合法的,按序填新数组的即可,从原数组的第i行取第j列的数,每次j++
        //j如果等于n,将i+1,j变回0即可
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        int i = 0;
        int j = 0;
        for (int k = 0; k < r; k++) {
            for (int p = 0; p < c; p++) {
                if (j == n) {
                    i++;
                    j = 0;
                }
                ans[k][p] = mat[i][j++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        matrixReshape(mat, 1, 4);
    }
}

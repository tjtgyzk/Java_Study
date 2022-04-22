package LeetCode.Arrays.MatrixChange;

public class L73 {
    public static void setZeroes(int[][] matrix) {
        //为了记录出现0的行和列,且不使用额外的矩阵资源
        //使用原矩阵的第一行和第一列来记录其他行列0的情况,用第一行对应列的数字,记录每一列是否出现0
        //利用第一列每一行的数据,记录每一行是否出现0
        //由于第一列和第一行的数据一定会被污染,所以用(0,0)位置记录第0行是否存在0,用一个额外变量记录第一列是否存在0
        int m = matrix.length;
        int n = matrix[0].length;
        boolean ifColExist0 = false;
        //遍历第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                ifColExist0 = true;
            }
        }
        //遍历第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                matrix[0][0] = 0;
            }
        }
        //遍历其余位置,(i,j)位置如果为0,就把(0,j)位置和(i,0)位置设置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //遍历除第一行第一列以外的其它数据,如果该行or该列存在过0,则置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //如果第一行有0,则把第一行全置为0,注意,为了防止第一列有0时污染(0,0),故先判断第一行是否有0;
        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        //如果第一列有0,则把第一列全置为0
        if (ifColExist0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes(matrix1);
    }
}

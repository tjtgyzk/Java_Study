package LeetCode.Arrays.MatrixChange;

public class L48 {
    public static void rotate(int[][] matrix) {
        //难点: 原地更改,否则令i行变为倒数第i行即可
        //分析坐标变化,第i列的逆序变为第i行,此为LeetCode官解:(i,j)->(j,n-1-i),递推即可得到一个循环式,利用中间变量保存其中之一即可
        //分享一种好理解的思路: 递推思路一致, 简化需要遍历哪些数的思路, 可与官解对比
        //把最外侧一圈视为一层,单独看每一层的变化:假设该层的长度为m,即为该层整体顺时针旋转了m-1位,对应关系仍为(i,j)->(j,n-1-i)->(n-i-1,n-j-1)->(n-j-1,i)->(i,j)
        //初始起始点为最外层(0,0),每层的起始点对应(+1,+1),每层需要遍历的点数为(该层长度-1),只需要记录初始行号即可
        //层数为(n+1)/2,从外至内每层长度递减2,如果该层长度≤1,则已经得到正确结果,可以在已知长度的情况下用for控制次数,也可以用while(true),通过长度控制跳出循环
        //for平时用的比较多,这里用while
        int n = matrix.length;
        int length = n;
        int beginI = 0;
        while (true) {
            if (length <= 1) {
                break;
            }
            for (int curJ = beginI; curJ < beginI + length - 1; curJ++) {
                int temp = matrix[beginI][curJ];
                matrix[beginI][curJ] = matrix[n - curJ - 1][beginI];
                matrix[n - curJ - 1][beginI] = matrix[n - beginI - 1][n - curJ - 1];
                matrix[n - beginI - 1][n - curJ - 1] = matrix[curJ][n - beginI - 1];
                matrix[curJ][n - beginI - 1] = temp;
            }
            beginI++;
            length -= 2;
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 0}};
        setZeroes(matrix2);
        rotate(matrix1);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }

}

package myStudy.Zuo.DynamicProgramming;

public class NearestRoad {
    public static int function1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        return process(m.length - 1, m[0].length - 1, m);
    }

    //process的功能是从（0，0）到（x,y）位置最短的路径
    public static int process(int x, int y, int[][] m) {
        if (x == 0 && y == 0) {
            return m[0][0];
        }
        if (x == 0) {
            return m[0][y] + process(0, y - 1, m);
        }
        if (y == 0) {
            return m[x][0] + process(x - 1, 0, m);
        }

        int p1 = process(x - 1, y, m);
        int p2 = process(x, y - 1, m);
        int ways = m[x][y] + Math.min(p1, p2);
        return ways;
    }

    public static int function2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        //x:0-->row-1
        //y:0-->col-1
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        //第一行只依赖左边
        for (int j = 1; j < col; j++) {
            dp[0][j] = m[0][j] + dp[0][j - 1];
        }
        //第一列只依赖上边
        for (int i = 1; i < row; i++) {
            dp[i][0] = m[i][0] + dp[i - 1][0];
        }
        for (int x = 1; x < row; x++) {
            for (int y = 1; y < col; y++) {
                dp[x][y] = m[x][y] + Math.min(dp[x][y - 1], dp[x - 1][y]);
            }
        }
        return dp[row - 1][col - 1];
    }

    //空间优化，每一个点只依赖自己的左边和上边
    // [a           b           c    ]
    // [a'      min(a',b)  min（b',c）]
    public static int function3(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[] dp = new int[col];
        dp[0] = m[0][0];
        //初始的第一行只依赖左侧的值
        for (int j = 1; j < col; j++) {
            dp[j] = m[0][j] + dp[j - 1];
        }
        for (int x = 1; x < row; x++) {
            dp[0] += m[x][0];
            for (int y = 1; y < col; y++) {
                dp[y] = m[x][y] + Math.min(dp[y - 1], dp[y]);
            }
        }
        return dp[col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 100);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int rowSize = 10;
        int colSize = 10;
        int[][] m = generateRandomMatrix(rowSize, colSize);
        System.out.println(function1(m));
        System.out.println(function2(m));
        System.out.println(function3(m));

    }

}

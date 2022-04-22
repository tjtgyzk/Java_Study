package LeetCode.Arrays.MatrixChange;

public class L289 {
    //难点在于,此刻的数据依赖于上一时刻旁边位置的数据,可以使用额外的一个数组来解决
    //如果要求空间复杂度O(1),可以发现数组中只使用了1和0来表示存活与否,故我们可以使用其他数字来同时表示前一刻和后一刻的状态
    //活->死:2
    //死->活:3
    //活->活和死->死,状态没有发生变化,则可以用原来的1和0
    //翻译一下规则:
    //如果活细胞周围有2-3个活细胞,继续存活
    //如果死细胞周围有3个活细胞,变活
    //其余都是死
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遍历周围8个位置,找到活细胞的个数
                int neighborsLiveCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    if (k < 0 || k >= m) {
                        continue;
                    }
                    for (int p = j - 1; p <= j + 1; p++) {
                        if (p < 0 || p >= n) {
                            continue;
                        }

                        if ((board[k][p] == 1 || board[k][p] == 2) && (k != i || p != j)) {
                            //前一状态是活细胞,排除当前点
                            neighborsLiveCount++;
                        }
                    }
                }
                if (board[i][j] == 1) {
                    //原本是活细胞
                    if (neighborsLiveCount == 2 || neighborsLiveCount == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 2;
                    }
                } else {
                    //原本是死细胞
                    if (neighborsLiveCount == 3) {
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
        //遍历整个数组,把1和3设置为1,其余设置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3 || board[i][j] == 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1}, {1, 0}};
        gameOfLife(matrix1);
    }
}

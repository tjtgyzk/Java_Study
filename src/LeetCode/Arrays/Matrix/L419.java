package LeetCode.Arrays.Matrix;

public class L419 {
    //并查集可解,但如果要求空间复杂度,则不可以
    //先写个空间复杂度O(1)解法
    //方法一:遇到每一个x,向右或向下将所有的X都变成.
    //弊端:改变原数组,时间复杂度较高
    //方法二:遇到每个X时,如果其上方是.或者小于0越界,且其左边是.或者小于0越界,则证明他是战舰的头部
    //统计所有头部个数
    public static int function1(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    //为头部,战舰数+1
                    ans++;
                }
            }
        }
        return ans;
    }

    //并查集
    public static class UnionFind {
        int[] parent;
        int[] size;
        int unionSize;
        int[] stack;
        int row;
        int col;

        public UnionFind(char[][] board) {
            row = board.length;
            col = board[0].length;
            int length = row * col;
            parent = new int[length];
            size = new int[length];
            stack = new int[length];
            unionSize = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'X') {
                        unionSize++;
                        int index = getIndex(i, j);
                        parent[index] = index;
                        size[index] = 1;
                    }
                }
            }
        }

        private int getIndex(int i, int j) {
            return i * col + j;
        }

        private int findFather(int i, int j) {
            int curIndex = getIndex(i, j);
            int stackIndex = -1;
            while (parent[curIndex] != curIndex) {
                stack[++stackIndex] = curIndex;
                curIndex = parent[curIndex];
            }
            while (stackIndex >= 0) {
                parent[stack[stackIndex--]] = curIndex;
            }
            return curIndex;
        }

        public void union(int r1, int c1, int r2, int c2) {
            int fatherA = findFather(r1, c1);
            int fatherB = findFather(r2, c2);
            if (fatherA != fatherB) {
                if (size[fatherA] >= size[fatherB]) {
                    parent[fatherB] = fatherA;
                    size[fatherA] += size[fatherB];
                    unionSize--;
                } else {
                    parent[fatherA] = fatherB;
                    size[fatherB] += size[fatherA];
                    unionSize--;
                }
            }
        }

        public int getSize() {
            return unionSize;
        }
    }

    public static int function2(char[][] board) {
        UnionFind un = new UnionFind(board);
        int row = board.length;
        int col = board[0].length;
        //第一列,判断上面的是否可以合并
        for (int i = 1; i < row; i++) {
            if (board[i][0] == 'X' && board[i - 1][0] == 'X') {
                un.union(i, 0, i - 1, 0);
            }
        }
        //第一行,判断左面的是否可以合并
        for (int j = 1; j < col; j++) {
            if (board[0][j] == 'X' && board[0][j - 1] == 'X') {
                un.union(0, j, 0, j - 1);
            }
        }
        //遍历其他,判断左上是否可以合并
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 'X') {
                    if (board[i - 1][j] == 'X') {
                        un.union(i, j, i - 1, j);
                    }
                    if (board[i][j - 1] == 'X') {
                        un.union(i, j, i, j - 1);
                    }
                }
            }
        }
        return un.getSize();
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X' }, {'.', '.', '.', 'X' }, {'.', '.', '.', 'X' }};
        System.out.println(function2(board));
    }
}

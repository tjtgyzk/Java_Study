package LeetCode;

public class L498 {
    public int[] findDiagonalOrder(int[][] mat) {
        //true代表向右上,false代表向左下
        int m = mat.length;
        int n = mat[0].length;
        int x = 0, y = 0;
        boolean flag = true;
        int[] ans = new int[m * n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[x][y];
            if (flag) {
                if (x - 1 < 0 && y + 1 >= n) {
                    x++;
                    flag = false;
                } else if (x - 1 < 0) {
                    y++;
                    flag = false;
                } else if (y + 1 >= n) {
                    x++;
                    flag = false;
                } else {
                    x--;
                    y++;
                }

            } else {
                if (x + 1 >= m && y - 1 < 0) {
                    y++;
                    flag = true;
                } else if (y - 1 < 0) {
                    x++;
                    flag = true;
                } else if (x + 1 >= m) {
                    y++;
                    flag = true;
                } else {
                    x++;
                    y--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new L498().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

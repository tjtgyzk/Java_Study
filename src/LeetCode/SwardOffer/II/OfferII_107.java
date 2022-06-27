package LeetCode.SwardOffer.II;

import java.util.LinkedList;
import java.util.Queue;

public class OfferII_107 {
    public int[][] updateMatrix(int[][] mat) {
        //bfs,把0都加入队列中,找其上下左右如果有1,则距离设置为1,将该点也加入队列
        int[][] step = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] next : step) {
                int x = poll[0] + next[0];
                int y = poll[1] + next[1];
                if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && mat[x][y] == -1) {
                    mat[x][y] = mat[poll[0]][poll[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return mat;
    }
}

package LeetCode.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class L417 {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //利用dfs, 从太平洋边界和大西洋边界开始反向找寻更高的节点, 用boolean数组存储每个点是否可以到达
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] ocean1 = new boolean[m][n];
        boolean[][] ocean2 = new boolean[m][n];
        //第一行
        for (int i = 0; i < n; i++) {
            dfs(0, i, ocean1, heights);
        }
        //第一列
        for (int i = 1; i < m; i++) {
            dfs(i, 0, ocean1, heights);
        }
        //最后一行
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, ocean2, heights);
        }
        //最后一列
        for (int i = 0; i < m - 1; i++) {
            dfs(i, n - 1, ocean2, heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ocean1[i][j] && ocean2[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        if (ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        for (int[] dir : dirs) {
            int m = i + dir[0], n = j + dir[1];
            if (m >= 0 && m < ocean.length && n >= 0 && n < ocean.length && heights[m][n] >= heights[i][j]) {
                dfs(m, n, ocean, heights);
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] heights2 = {{2, 1}, {1, 2}};
        new L417().pacificAtlantic(heights2);
    }
}

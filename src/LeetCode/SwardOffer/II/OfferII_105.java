package LeetCode.SwardOffer.II;

public class OfferII_105 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, process(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int process(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1 + process(grid, i + 1, j) + process(grid, i - 1, j) + process(grid, i, j + 1) + process(grid, i, j - 1);
        return ans;
    }
}

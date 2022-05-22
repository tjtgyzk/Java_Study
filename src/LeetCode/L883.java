package LeetCode;

public class L883 {
    public int projectionArea(int[][] grid) {
        //xy面面积为grid有几个不为0的元素
        //xz面为矩阵每行最高元素相加
        //yz面为矩阵每列最高元素相加
        //矩阵为方阵,所以可以一起求每行最高和每列最高
        int xy = 0;
        int xz = 0;
        int yz = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowMax = 0, colMax = 0;
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] > 0) {
                    xy += 1;
                }
                rowMax = Math.max(rowMax, grid[i][j]);
                colMax = Math.max(colMax, grid[j][i]);
            }
            xz += rowMax;
            yz += colMax;
        }
        return xy + xz + yz;
    }
}

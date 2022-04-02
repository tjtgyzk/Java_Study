package myStudy.Zuo.z19_upperStack;

public class GetMaxSubSquareHaveOne {
    public static int getMax(int[][] matrix) {
        int[] row = matrix[0];
        int max = ReturnMaxSquare.getMax(row);
        for (int i = 1; i < matrix.length; i++) {
            //更新每一行数据
            for (int j = 0; j < row.length; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 0;
                } else {
                    row[j]++;
                }
            }
            max = Math.max(max, ReturnMaxSquare.getMax(row));
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(getMax(matrix));
    }
}

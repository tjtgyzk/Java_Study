package LeetCode.Arrays.Matrix;

public class L661 {
    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int numbers = 0;
                int sum = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        //判断越界与否
                        //都不越界,这个数字要,总数字数+1,sum+=该数字
                        if (k >= 0 && k < m && l >= 0 && l < n) {
                            numbers++;
                            sum += img[k][l];
                        }
                    }
                }
                //算出该位置平滑后的数字
                res[i][j] = sum / numbers;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        System.out.println(imageSmoother(img));
    }
}

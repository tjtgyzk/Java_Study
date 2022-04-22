package LeetCode.Arrays.MatrixDifferent;

import java.util.ArrayList;
import java.util.List;

public class L54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int L = 0;
        int U = 0;
        int R = matrix[0].length - 1;
        int D = matrix.length - 1;
        List<Integer> ans = new ArrayList<Integer>();
        while (true) {
            //跳出条件
            if (L > R || U > D) {
                break;
            }
            //从左往右
            for (int ltr = L; ltr <= R; ltr++) {
                ans.add(matrix[U][ltr]);
            }
            //如果只有一行,则不用执行从上往下,从右往左,从下往上,故加个判断
            if (U == D) {
                break;
            }
            //从上往下,第一行的已经打印过,从第二行开始
            for (int utd = U + 1; utd <= D; utd++) {
                ans.add(matrix[utd][R]);
            }
            //从右往左,最后一列已经打印过,从倒数第二列开始
            for (int rtl = R - 1; rtl >= L; rtl--) {
                ans.add(matrix[D][rtl]);
            }
            //如果只有两行,则不用执行从下往上
            if (D - U == 1) {
                break;
            }
            //如果只有一列,不需要从下往上
            if (R == L) {
                break;
            }
            //从下往上,最后一行的已经打印过,从倒数第二行开始
            for (int dtu = D - 1; dtu > U; dtu--) {
                ans.add(matrix[dtu][L]);
            }
            L++;
            R--;
            U++;
            D--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = {{7}, {9}, {6}};
        System.out.println(spiralOrder(matrix3).toString());
    }
}

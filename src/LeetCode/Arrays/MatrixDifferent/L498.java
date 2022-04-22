package LeetCode.Arrays.MatrixDifferent;

public class L498 {
    public static int[] findDiagonalOrder(int[][] mat) {//观察可知,向右上遍历时,若向上越界向右不越界,下一个为右边,开始向左下遍历; 若向上向右都越界,则下一个为下边,开始向左下遍历
        //向左下遍历时,若向下越界向左越界,向下不越界,则下一个为下半边,开始向右上遍历; 若都越界,下一个为右边,开始向右上遍历
        //左下与右上交替进行
        //碰到最后一个位置时,结束
        //使用一个boolean类型的flag标志,ture表示向右上遍历,false表示向左下遍历
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int nextNumIndex = 0;
        boolean flag = true;
        int i = 0;
        int j = 0;
        while (true) {
            if (i == m - 1 && j == n - 1) {
                //遍历到最后一个数
                ans[nextNumIndex] = mat[i][j];
                break;
            }
            if (flag) {
                //右上遍历
                ans[nextNumIndex++] = mat[i][j];
                if (i - 1 >= 0 && j + 1 < n) {
                    //都不越界
                    i -= 1;
                    j += 1;
                    continue;
                } else if (j + 1 < n) {
                    //右边不越界,变为右边,切换遍历模式
                    j += 1;
                    flag = false;
                    continue;
                } else {
                    //右边越界,上不管越界与否,都找下边,切换遍历模式
                    i += 1;
                    flag = false;
                    continue;
                }
            } else {
                //左下遍历
                ans[nextNumIndex++] = mat[i][j];
                if (i + 1 < m && j - 1 >= 0) {
                    //都不越界
                    i += 1;
                    j -= 1;
                    continue;
                } else if (i + 1 < m) {
                    //下不越界
                    i += 1;
                    flag = true;
                    continue;
                } else {
                    //下越界,左边不管越界与否,都找右,切换遍历模式
                    j += 1;
                    flag = true;
                    continue;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{6, 9, 7}};
        System.out.println(findDiagonalOrder(mat));
    }
}

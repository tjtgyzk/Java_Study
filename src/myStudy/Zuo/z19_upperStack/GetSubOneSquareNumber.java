package myStudy.Zuo.z19_upperStack;

import java.util.Deque;
import java.util.LinkedList;

public class GetSubOneSquareNumber {
    public static int getNum(int[][] mat) {
        int[] row = new int[mat[0].length];
        int num = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[j] = 0;
                } else {
                    row[j]++;
                }
            }
            num += perRowNumber(row);
        }
        return num;
    }

    public static int perRowNumber(int[] row) {
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < row.length; i++) {
            while (!stack.isEmpty() && row[stack.peek()] >= row[i]) {
                int now = stack.pop();
                //如果相等，只计算右边的，弹出左边的即可
                if (row[now] == row[i]) {
                    continue;
                }
                int L = stack.isEmpty() ? i : i - stack.peek() - 1;
                int times = row[now] - Math.max(row[i], stack.isEmpty() ? 0 : row[stack.peek()]);
                num += times * L * (L + 1) / 2;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int now = stack.pop();
            int L = stack.isEmpty() ? row.length : row.length - stack.peek() - 1;
            int times = row[now] - (stack.isEmpty() ? 0 : row[stack.peek()]);
            num += times * L * (L + 1) / 2;
        }
        return num;
    }
}

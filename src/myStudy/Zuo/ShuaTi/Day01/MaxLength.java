package myStudy.Zuo.ShuaTi.Day01;

public class MaxLength {
    public static int function(int[][] arr) {
        if (arr == null) {
            return 0;
        }
        int ans = 0;
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process(arr, i, j));
            }
        }
        return ans;
    }

    /**
     * @param arr
     * @param x   当前位置x
     * @param y   当前位置y
     * @return 递增链长度
     */
    public static int process(int[][] arr, int x, int y) {
        //越界
        if (x < 0 || x >= arr.length || y < 0 || y > arr[0].length) {
            return 0;
        }
        int now = arr[x][y];
        int up = (arr[x - 1][y] > now) ? process(arr, x - 1, y) : 0;
        int down = (arr[x + 1][y] > now) ? process(arr, x + 1, y) : 0;
        int left = (arr[x][y - 1] > now) ? process(arr, x, y - 1) : 0;
        int right = (arr[x][y + 1] > now) ? process(arr, x, y + 1) : 0;
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }


}

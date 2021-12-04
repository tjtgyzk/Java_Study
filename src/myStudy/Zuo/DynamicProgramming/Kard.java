package myStudy.Zuo.DynamicProgramming;

public class Kard {
    public static void main(String[] args) {
        int[] arr = {50, 100, 20, 10};
        System.out.println(kards1(arr));
        System.out.println(kards2(arr));
        System.out.println(kards3(arr));
    }

    //暴力递归
    public static int kards1(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int p1 = first1(arr, 0, arr.length - 1);
        int p2 = last1(arr, 0, arr.length - 1);
        return Math.max(p1, p2);
    }

    public static int first1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + last1(arr, L + 1, R);
        int p2 = arr[R] + last1(arr, L, R - 1);
        return Math.max(p1, p2);

    }

    public static int last1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = first1(arr, L + 1, R);
        int p2 = first1(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    //傻缓存
    public static int kards2(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int p1 = first2(arr, 0, arr.length - 1, fmap, gmap);
        int p2 = last2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(p1, p2);
    }

    public static int first2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + last2(arr, L + 1, R, fmap, gmap);
            int p2 = arr[R] + last2(arr, L, R - 1, fmap, gmap);
            ans = Math.max(p1, p2);
        }
        fmap[L][R] = ans;
        return ans;
    }

    public static int last2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int ans = 0;
        if (L != R) {
            int p1 = first2(arr, L + 1, R, fmap, gmap);
            int p2 = first2(arr, L, R - 1, fmap, gmap);
            ans = Math.min(p1, p2);
        }
        gmap[L][R] = ans;
        return ans;
    }

    //动态规划
    public static int kards3(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        //fmap对角线元素就是arr值
        //gamp对角线元素为0
        for (int i = 0; i < arr.length; i++) {
            fmap[i][i] = arr[i];
        }
        //按对角线填
        //f和g都依赖对方相同位置的左侧和下侧数据
        for (int col = 1; col < N; col++) {
            //L总是从第0行开始
            int L = 0;
            int R = col;
            while (R < N) {
                //只有R可能越界
                fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
                gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }
}

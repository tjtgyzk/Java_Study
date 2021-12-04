package yu.DynamicProgramming;

public class StupidLiangXinYu {
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        //如果我拿左边的
        int p1 = arr[L] + g(arr, L + 1, R);
        //拿右边的
        int p2 = arr[R] + g(arr, L, R - 1);
        int ans = Math.max(p1, p2);
        return ans;
    }

    public static int g(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        //如果对方拿了L
        int p1 = f(arr, L + 1, R);
        //如果对方拿了R
        int p2 = f(arr, L, R - 1);
        int ans = Math.min(p1, p2);
        return ans;
    }

    public static int function1(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int first = f(arr, 0, arr.length - 1);
        int last = g(arr, 0, arr.length - 1);
        return Math.max(first, last);
    }

    public static void main(String[] args) {
        int[] arr = {50, 100, 20, 10, 20, 65, 98, 7};
        System.out.println(function1(arr));
        System.out.println(function2(arr));
        System.out.println(function3(arr));
    }

    //傻缓存法
    public static int function2(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        //L：0-length-1
        //R：0-length-1
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int first = f2(arr, 0, arr.length - 1, fmap, gmap);
        int last = g2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(first, last);
    }

    public static int f2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + g2(arr, L + 1, R, fmap, gmap);
            int p2 = arr[R] + g2(arr, L, R - 1, fmap, gmap);
            ans = Math.max(p1, p2);
        }
        fmap[L][R] = ans;
        return ans;
    }

    public static int g2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int ans = 0;
        if (L != R) {
            int p1 = f2(arr, L + 1, R, fmap, gmap);
            int p2 = f2(arr, L, R - 1, fmap, gmap);
            ans = Math.min(p1, p2);
        }
        gmap[L][R] = ans;
        return ans;
    }

//    public static int function3(int[] arr) {
//        if (arr.length == 0 || arr == null) {
//            return -1;
//        }
//        int N = arr.length;
//        int[][] fmap = new int[N][N];
//        int[][] gmap = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            fmap[i][i] = arr[i];
//        }
//        for (int col = 1; col < N; col++) {
//            int L = 0;
//            int R = col;
//            while (R < N) {
//                fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
//                gmap[L][R] = Math.min(fmap[L][R - 1], fmap[L + 1][R]);
//                L++;
//                R++;
//            }
//        }
//        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
//    }


    public static int function3(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }
        for (int col = 1; col < N; col++) {
            int L = 0;
            int R = col;
            while (R < N) {
                int p1 = arr[L] + gmap[L + 1][R];
                int p2 = arr[R] + gmap[L][R - 1];
                fmap[L][R] = Math.max(p1, p2);
                int r1 = fmap[L + 1][R];
                int r2 = fmap[L][R - 1];
                gmap[L][R] = Math.min(r1, r2);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }
}

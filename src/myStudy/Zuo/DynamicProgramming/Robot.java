package myStudy.Zuo.DynamicProgramming;

public class Robot {
    //N为一共有几个位置
    //start为初始位置
    //aim为目标位置
    //K为步数

    //自然智慧想出的暴力递归尝试
    public static int ways1(int N, int start, int aim, int K) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        return process(start, K, N, aim);
    }

    public static int process(int cur, int rest, int N, int aim) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(cur + 1, rest - 1, N, aim);
        }
        if (cur == N) {
            return process(cur - 1, rest - 1, N, aim);
        }
        int left = process(cur - 1, rest - 1, N, aim);
        int right = process(cur + 1, rest - 1, N, aim);
        return left + right;
    }

    //傻缓存法
    //数据只和cur以及rest有关，所以记录一个表来保存每个cur和rest对应的值
    public static int ways2(int N, int start, int aim, int K) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        int[][] map = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                map[i][j] = -1;
            }
        }
        return process2(start, K, N, aim, map);
    }

    public static int process2(int cur, int rest, int N, int aim, int[][] map) {
        if (map[cur][rest] != -1) {
            return map[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, rest - 1, N, aim, map);
        } else if (cur == N) {
            ans = process2(cur - 1, rest - 1, N, aim, map);
        } else {
            ans = process2(cur - 1, rest - 1, N, aim, map) + process2(cur + 1, rest - 1, N, aim, map);
        }
        map[cur][rest] = ans;
        return ans;
    }

    public static int ways3(int N, int start, int aim, int K) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        int[][] map = new int[N + 1][K + 1];
        //如果rest==0，则只有aim位置的值是1，其余都是0
        map[aim][0] = 1;
        //一列一列的填表
        for (int rest = 1; rest <= K; rest++) {
            //如果cur==1,则只和2,rest-1位置有关
            map[1][rest] = map[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                //cur在中间，与cur-1，rest-1，cur+1,rest-1有关
                map[cur][rest] = map[cur - 1][rest - 1] + map[cur + 1][rest - 1];
            }
            //cur==N,只和N-1,rest-1位置有关
            map[N][rest] = map[N - 1][rest - 1];
        }
        return map[start][K];
    }

    public static void main(String[] args) {
        System.out.println(ways1(5, 4, 2, 6));
        System.out.println(ways2(5, 4, 2, 6));
        System.out.println(ways3(5, 4, 2, 6));
    }
}

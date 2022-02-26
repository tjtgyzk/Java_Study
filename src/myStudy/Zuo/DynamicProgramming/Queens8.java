package myStudy.Zuo.DynamicProgramming;

public class Queens8 {
    //n皇后问题
    //一共n行n列，放置皇后不能共行共列共斜线
    //使用record数组来保存已填皇后的位置信息，数组下标表示行，内容表示列
    public static int Queens(int n) {
        if (n <= 3) {
            if (n == 1) {
                return 1;
            }
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    //i为当前行数，record为位置数组，n为总行数
    //i的范围是0--n-1
    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        //从第0列开始试
        for (int j = 0; j < n; j++) {
            if (judge(record, i, j)) {//如果i，j位置可以放
                record[i] = j;
                ans += process(i + 1, record, n);
            }
        }
        return ans;
    }

    public static boolean judge(int[] record, int i, int j) {
        //i每次都不同保证不在同一行
        //j不同则不在同一列
        //|i-x|≠|j-y|保证不在同一斜线
        for (int k = 0; k < i; k++) {//把第i行之前的全部试一次
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    //位运算优化
    public static int Queens1(int n) {
        if (n <= 3) {
            if (n == 1) {
                return 1;
            }
            return 0;
        }
        //int是32位，只能做小于32皇后的问题
        //n皇后问题，期望0--n-1位为1，剩余为0
        int limit = (1 << n) - 1;
        return process1(limit, 0, 0, 0);

    }

    public static int process1(int limit, int colLimit, int leLimit, int riLimit) {
        //如果colLimit==limit，则说明所有位置都放置了皇后，是一种情况
        if (colLimit == limit) {
            return 1;
        }
        //pos令当前行可放置皇后的位置为1，其余位置为0
        int pos = limit & (~(colLimit | leLimit | riLimit));
        int rightOne = 0;
        int res = 0;
        //当pos不全为0时，从最右侧开始试，当pos为0时，直接返回当前的res值为0
        while (pos != 0) {
            //获得最右侧的1
            rightOne = pos & (~pos + 1);
            //将rightOne位置置0
            pos = pos - rightOne;
            //接下来更新三个limit的值
            //注意：不能直接改这三个lim，因为迭代过程还要用之前的值。每次变化过后的直接传入递归函数

            //列限制为直接加上当前添加的位置
            //colLimit = (colLimit | rightOne);
            //左下限制为之前左下限制左移一位，以及当前放置的位置左移一位
            //leLimit = ((leLimit | rightOne) << 1);
            //右下限制为之前右下限制右移一位，以及当前放置的位置右移一位
            //>>>为右移补0
            //riLimit = ((riLimit | rightOne) >>> 1);

            res += process1(limit, colLimit | rightOne, (leLimit | rightOne) << 1, riLimit);
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(Queens(5));
        System.out.println(Queens1(5));
    }
}

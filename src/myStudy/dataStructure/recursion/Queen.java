package myStudy.dataStructure.recursion;

public class Queen {
    int max = 8;
    int[] array = new int[max];
    int n = 0;//从第一行开始，遍历0-7行
    static int count = 0;

    public static void main(String[] args) {

        Queen queen = new Queen();
        queen.check(0);
        System.out.println(count);
    }

    public void check(int n) {
        if (n == max) {//n=8说明遍历完毕，输出结果
            show(array);
            System.out.println();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {//遍历列
            array[n] = i;//先把第n行的皇后放置在第一列上，判断是否冲突，如果冲突就跟着for循环放到第二列继续判断，以此类推
            if (judge(n)) {//如果不冲突，继续判断下一个皇后放在哪儿
                check(n + 1);
            }
        }
    }

    public void show(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public boolean judge(int n) {//判断第n行的皇后
        for (int i = 0; i < n; i++) {//判断前面行的皇后
            //array[i]==array[n] 判断是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]) 行数之差等于列数之差，即在同一斜线上
            //由于i<n,所以不可能在同一行
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {//在同一行or同一斜线
                return false;
            }
        }
        return true;//前面所有皇后都不矛盾，返回true
    }
}

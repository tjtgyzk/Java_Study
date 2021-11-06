package myStudy.Zuo.Tree;

public class fold {
    public static void main(String[] args) {
        printFold(4);
    }

    public static void printFold(int N) {
        process(1, N, true);
    }

    public static void process(int i, int N, boolean flag) {
        if (i > N) {//用N表示遍历到哪一层的子树
            return;
        }
        process(i + 1, N, true);
        System.out.println(flag ? "凹" : "凸");
        process(i + 1, N, false);
    }
}

package myStudy.Zuo.Union;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        unionFind union = new unionFind(N);
        for (int i = 0; i < N; i++) {//只遍历上半矩阵
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.getSetNum();
    }

    //并查集
    //需要union方法，setNum方法
    //数组实现
    public static class unionFind {
        //用于存放节点i的代表节点parent[i]
        int[] parent;
        //如果i是代表节点，size[i]表示i所在集合的大小
        int[] size;
        //用于实现栈的辅助结构
        int[] stack;
        //一共有多少个集合
        int setNum;

        public unionFind(int N) {
            parent = new int[N];
            size = new int[N];
            stack = new int[N];
            setNum = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        //找到i的代表节点，并压缩路径
        public int findFather(int i) {
            int si = 0;
            while (parent[i] != i) {
                stack[si++] = i;
                i = parent[i];
            }
            for (si--; si >= 0; si--) {
                parent[stack[si]] = i;
            }
            return i;
        }

        //合并集合
        public void union(int i, int j) {
            int fatherI = findFather(i);
            int fatherJ = findFather(j);
            if (fatherI != fatherJ) {
                if (size[fatherI] >= size[fatherJ]) {
                    parent[fatherJ] = fatherI;
                    size[fatherI] += size[fatherJ];
                } else {
                    parent[fatherI] = fatherJ;
                    size[fatherJ] += size[fatherI];
                }
                setNum--;
            }
        }

        //返回集合数
        public int getSetNum() {
            return setNum;
        }

    }
}

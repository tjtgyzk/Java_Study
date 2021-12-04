package yu.Bing;

public class LeetCode_547 {
    public static class UnionFind {
        int[] parent;
        int[] size;
        int[] stack;
        int sets;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            stack = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
                sets++;
            }
        }

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

        public void union(int i, int j) {
            int fatherI = findFather(i);
            int fatherJ = findFather(j);
            if (fatherI != fatherJ) {
                if (size[fatherI] >= size[fatherJ]) {
                    parent[fatherJ] = fatherI;
                    size[fatherI] += size[fatherJ];
                    //    size[fatherJ] = 0;
                    sets--;
                } else {
                    parent[fatherI] = fatherJ;
                    size[fatherJ] += size[fatherI];
                    //    size[fatherI] = 0;
                    sets--;
                }
            }
        }

        public int setsNum() {
            return sets;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind un = new UnionFind(N);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    un.union(i, j);
                }
            }
        }
        return un.sets;
    }
}

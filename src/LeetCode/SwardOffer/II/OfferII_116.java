package LeetCode.SwardOffer.II;

public class OfferII_116 {
    class UnionFind {
        int[] size;
        int unionSize;
        int[] parent;
        int[] stack;

        public UnionFind(int[][] isConnected) {
            int n = isConnected.length;
            parent = new int[n];
            stack = new int[n];
            size = new int[n];
            unionSize = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findFather(int index) {
            int cur = index;
            int i = 0;
            while (parent[cur] != cur) {
                stack[i++] = cur;
                cur = parent[cur];
            }
            i--;
            while (i >= 0) {
                parent[stack[i]] = cur;
                i--;
            }
            return cur;
        }

        public void union(int index1, int index2) {
            int fatherA = findFather(index1);
            int fatherB = findFather(index2);
            if (fatherA != fatherB) {
                int big = size[fatherA] > size[fatherB] ? fatherA : fatherB;
                int small = big == fatherA ? fatherB : fatherA;
                parent[small] = big;
                size[big] += size[small];
                unionSize--;
            }
        }

        public int getSetNum() {
            return unionSize;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind un = new UnionFind(isConnected);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    un.union(i, j);
                }
            }
        }
        return un.getSetNum();
    }
}

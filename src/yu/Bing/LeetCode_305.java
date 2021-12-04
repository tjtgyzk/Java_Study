package yu.Bing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_305 {
    public static class UnionFind {
        int[] parent;
        int[] size;
        int[] stack;
        int sets;
        int row;
        int col;

        public UnionFind(int m, int n) {
            row = m;
            col = n;
            int N = row * col;
            parent = new int[N];
            size = new int[N];
            stack = new int[N];
            sets = 0;
        }

        public int index(int m, int n) {
            return m * col + n;
        }

        public int findFather(int r, int c) {
            int index = index(r, c);
            int si = 0;
            while (parent[index] != index) {
                stack[si++] = index;
                index = parent[index];
            }
            for (si--; si >= 0; si--) {
                parent[stack[si]] = index;
            }
            return index;
        }

        public void add(int[] position) {
            int i = position[0];
            int j = position[1];
            int index = index(i, j);
            if (size[index] == 0) {
                parent[index] = index;
                size[index] = 1;
                sets++;
                union(i, j, i - 1, j);
                union(i, j, i + 1, j);
                union(i, j, i, j - 1);
                union(i, j, i, j + 1);
            }
        }

        public void union(int r1, int c1, int r2, int c2) {
            if (r1 < 0 || r1 >= row || r2 < 0 || r2 >= row || c1 < 0 || c1 >= col || c2 < 0 || c2 >= col) {
                return;
            }
            int father1 = findFather(r1, c1);
            int father2 = findFather(r2, c2);
            int index1 = index(r1, c1);
            int index2 = index(r2, c2);
            if (size[index1] == 0 || size[index2] == 0) {
                return;
            }
            if (father1 != father2) {
                if (size[father1] >= size[father2]) {
                    parent[father2] = father1;
                    size[father1] += size[father2];
                    sets--;
                } else {
                    parent[father1] = father2;
                    size[father2] += size[father1];
                    sets--;
                }
            }
        }

    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind un = new UnionFind(m, n);
        for (int[] position : positions) {
            un.add(position);
            ans.add(un.sets);
        }
        return ans;
    }
}



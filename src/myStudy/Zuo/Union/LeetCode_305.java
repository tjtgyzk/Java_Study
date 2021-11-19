package myStudy.Zuo.Union;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_305 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        List<Integer> ans = numIslands2(m, n, positions);
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind un = new UnionFind(m, n);
        for (int[] pos : positions) {
            un.add(pos);
            ans.add(un.sets);
        }
        return ans;
    }

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
            int len = row * col;
            parent = new int[len];
            size = new int[len];
            stack = new int[len];
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


        public void add(int[] position) {//添加时同时合并
            int row = position[0];
            int col = position[1];
            int index = index(row, col);
            if (size[index] == 0) {
                parent[index] = index;
                size[index] = 1;
                sets++;
                union(row, col, row - 1, col);
                union(row, col, row + 1, col);
                union(row, col, row, col - 1);
                union(row, col, row, col + 1);
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
            //判断，必须两个都被初始化过才可以合并
//            if (size[father1] == 0 || size[father2] == 0) {
//                return;
//            }这里错误是因为其父节点未初始化时为0，0的位置可能被初始化过，要用index，只有size[index]才能表示其位置是否被初始化过，father不行，有歧义！！！！
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

}

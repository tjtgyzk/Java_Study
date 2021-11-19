package myStudy.Zuo.Union;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LeetCode_200 {
    //    //方法一：递归
//    public int numIslands1(char[][] grid) {
//        int ans = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    chuanRan(grid, i, j);
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//    //如果该节点是1，转化成2，
//    public static void chuanRan(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {//如果超出边界，直接返回
//            return;
//        }
//        if (grid[i][j] != '1') {//如果不是1，则不进行任何操作
//            return;
//        }
//        grid[i][j] = 2;
//        chuanRan(grid, i - 1, j);
//        chuanRan(grid, i + 1, j);
//        chuanRan(grid, i, j - 1);
//        chuanRan(grid, i, j + 1);
//    }


    //    //方法二：并查集（表）
//    public class dot {
//
//    }
//
//    public class unionFind1 {
//        HashMap<dot, dot> parent;
//        HashMap<dot, Integer> size;
//
//        public unionFind1(List<dot> dotList) {
//            parent = new HashMap<>();
//            size = new HashMap<>();
//            for (dot d : dotList) {
//                parent.put(d, d);
//                size.put(d, 1);
//            }
//        }
//
//        public dot findFather(dot d) {
//            Stack<dot> stack = new Stack<>();
//            while (parent.get(d) != d) {
//                stack.push(d);
//                d = parent.get(d);
//            }
//            while (!stack.isEmpty()) {
//                parent.put(stack.pop(), d);
//            }
//            return d;
//        }
//
//        public void union(dot a, dot b) {
//            dot fatherA = findFather(a);
//            dot fatherB = findFather(b);
//            if (fatherA != fatherB) {
//                if (size.get(fatherA) >= size.get(fatherB)) {
//                    parent.put(fatherB, fatherA);
//                    size.put(fatherA, size.get(fatherB) + size.get(fatherA));
//                    size.remove(fatherB);
//                } else {
//                    parent.put(fatherA, fatherB);
//                    size.put(fatherB, size.get(fatherA) + size.get(fatherB));
//                    size.remove(fatherA);
//                }
//            }
//        }
//
//        public int getSets() {
//            return size.size();
//        }
//    }
//
//    public int numIslands(char[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        //用一个dot数组复刻原始数组
//        dot[][] dots = new dot[row][col];
//        List<dot> dotList = new ArrayList<>();
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    dots[i][j] = new dot();
//                    dotList.add(dots[i][j]);
//                }
//            }
//        }
//        unionFind1 un = new unionFind1(dotList);
//        //遍历数组，为了不每次都判断是否超出边界，第一行和第一列分别进行遍历，这样时间复杂度更低
//        //遍历第一行
//        for (int j = 1; j < col; j++) {
//            //(0,j) 跳过(0,0)
//            if (grid[0][j] == '1' && grid[0][j - 1] == '1') {//自己和左边的都是1
//                un.union(dots[0][j], dots[0][j - 1]);
//            }
//        }
//        for (int i = 1; i < row; i++) {
//            if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
//                un.union(dots[i][0], dots[i - 1][0]);
//            }
//        }
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                if (grid[i][j] == '1') {
//                    if (grid[i - 1][j] == '1') {
//                        un.union(dots[i][j], dots[i - 1][j]);
//                    }
//                    if (grid[i][j - 1] == '1') {
//                        un.union(dots[i][j], dots[i][j - 1]);
//                    }
//                }
//            }
//        }
//        return un.getSets();
//
//    }
    //方法三：数组式并查集
    public static class UnionFind {
        int[] parent;
        int[] size;
        int[] stack;
        int col;//为了index方法使用
        int sets;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            col = grid[0].length;
            sets = 0;
            int len = row * col;
            parent = new int[len];
            size = new int[len];
            stack = new int[len];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        int index = index(i, j);
                        parent[index] = index;
                        size[index] = 1;
                        sets++;
                    }
                }
            }
        }

        public int index(int r, int c) {//第r行第c列，每行col个数，所以索引为r * col + c
            return r * col + c;
        }

        public int findFather(int r, int c) {
            int index = index(r, c);
            int si = 0;
            while (parent[index] != index) {
                stack[si] = index;
                index = parent[index];
            }
            for (si--; si >= 0; si--) {
                parent[stack[si]] = index;
            }
            return index;
        }

        public void union(int r1, int c1, int r2, int c2) {
            int father1 = findFather(r1, c1);
            int father2 = findFather(r2, c2);
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

        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            UnionFind un = new UnionFind(grid);
            //遍历第一行
            for (int j = 1; j < col; j++) {
                if (grid[0][j] == '1' && grid[0][j - 1] == '1') {
                    un.union(0, j, 0, j - 1);
                }
            }
            //遍历第一列
            for (int i = 1; i < row; i++) {
                if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
                    un.union(i, 0, i - 1, 0);
                }
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == '1') {
                        if (grid[i][j - 1] == '1') {
                            un.union(i, j, i, j - 1);
                        }
                        if (grid[i - 1][j] == '1') {
                            un.union(i, j, i - 1, j);
                        }

                    }
                }
            }
            return un.sets;
        }
    }
}

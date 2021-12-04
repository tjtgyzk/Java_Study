package yu.Bing;


import java.util.*;

public class LeetCode_200 {
    //    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
//        System.out.println(numIslands(grid));
//    }
//
//    public static int numIslands(char[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        int ans = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == '1') {
//                    process(grid, i, j);
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//
//    public static void process(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
//            return;
//        }
//        if (grid[i][j] != '1') {
//            return;
//        }
//        grid[i][j] = 2;
//        process(grid, i - 1, j);
//        process(grid, i + 1, j);
//        process(grid, i, j - 1);
//        process(grid, i, j + 1);
//    }
//
//    public static int numIslands(char[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        dot[][] dots = new dot[row][col];
//        List<dot> dotList = new ArrayList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == '1') {
//                    dots[i][j] = new dot();
//                    dotList.add(dots[i][j]);
//                }
//            }
//        }//所有的1拿出来了，放到并查集里
//        UnionFind un = new UnionFind(dotList);
//        for (int j = 1; j < col; j++) {
//            if (grid[0][j - 1] == '1' && grid[0][j] == '1') {
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
//        return un.setsNum();
//    }
//
//    public static class dot {
//    }
//
//    public static class UnionFind {
//        public HashMap<dot, dot> parent;
//        public HashMap<dot, Integer> size;
//
//        public UnionFind(List<dot> list) {
//            parent = new HashMap<>();
//            size = new HashMap<>();
//            for (dot cur : list) {
//                parent.put(cur, cur);
//                size.put(cur, 1);
//            }
//        }
//
//        public dot findFather(dot d) {
//            Deque<dot> stack = new LinkedList<>();
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
//        public int setsNum() {
//            return size.size();
//        }
//    }
//
    public class UnionFind {
        int[] parent;
        int[] size;
        int[] stack;
        int sets;
        int row;
        int col;

        public UnionFind(char[][] grid) {
            row = grid.length;
            col = grid[0].length;
            int N = row * col;
            parent = new int[N];
            size = new int[N];
            stack = new int[N];
            sets = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        int index = getIndex(i, j);
                        parent[index] = index;
                        size[index] = 1;
                        sets++;
                    }
                }
            }
        }

        public int findFather(int i, int j) {
            int index = getIndex(i, j);
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

        public void union(int r1, int c1, int r2, int c2) {
            int fatherA = findFather(r1, c1);
            int fatherB = findFather(r2, c2);
            if (fatherA != fatherB) {
                if (size[fatherA] >= size[fatherB]) {
                    parent[fatherB] = fatherA;
                    size[fatherA] += size[fatherB];
                    sets--;
                } else {
                    parent[fatherA] = fatherB;
                    size[fatherB] += size[fatherA];
                    sets--;
                }
            }
        }

        public int getIndex(int i, int j) {
            return i * col + j;
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind un = new UnionFind(grid);
        for (int j = 1; j < col; j++) {
            if (grid[0][j - 1] == '1' && grid[0][j] == '1') {
                un.union(0, j - 1, 0, j);
            }
        }
        for (int i = 1; i < row; i++) {
            if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
                un.union(i, 0, i - 1, 0);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (grid[i - 1][j] == '1') {
                        un.union(i, j, i - 1, j);
                    }
                    if (grid[i][j - 1] == '1') {
                        un.union(i, j, i, j - 1);
                    }
                }

            }
        }
        return un.sets;
    }
}



package myStudy;

import java.util.*;

public class Graph {
    //Node节点
    public static class Node {
        //一个自己的值
        int value;
        //一个邻居链表
        List<Node> children;
    }

    //图
    public static class Tu {
        //Node的链表
        List<Node> list;
    }

    //并查集
    public static class UnionFind {
        HashMap<Node, Node> father;//存代表节点
        HashMap<Node, Integer> size;//存集合大小
        Deque<Node> stack;//路径优化的栈

        public UnionFind(Tu graph) {
            father = new HashMap<>();
            this.size = new HashMap<>();
            stack = new LinkedList<>();
            for (Node cur : graph.list) {
                //初始每个人都独自一个集合，代表节点是自己，大小是1
                father.put(cur, cur);
                size.put(cur, 1);
            }
        }

        //找爹函数
        private Node findFather(Node node) {
            while (father.get(node) != node) {
                //路径优化，存到栈里
                stack.push(node);
                node = father.get(node);
            }
            //此时node就是代表节点
            while (!stack.isEmpty()) {
                father.put(stack.pop(), node);
            }
            return node;
        }

        public void union(Node a, Node b) {
            //找到ab的代表节点
            Node fatherA = findFather(a);
            Node fatherB = findFather(b);
            if (fatherA != fatherB) {
                //找到更大的集合
                Node big = size.get(fatherA) >= size.get(fatherB) ? fatherA : fatherB;
                Node small = big == fatherA ? fatherB : fatherA;
                father.put(small, big);
                size.put(big, size.get(fatherA) + size.get(fatherB));
                size.remove(small);
            }
        }

    }

    //DFS
    public static int DFS(Tu graph) {
        //并查集
        UnionFind un = new UnionFind(graph);
        //避免重复调用
        Set<Node> set = new HashSet<>();
        //对邻接表中的每一个节点做dfs
        for (Node cur : graph.list) {
            dfs(cur, un, set);
        }
        return un.size.size();
    }

    public static void dfs(Node cur, UnionFind un, Set<Node> set) {
        if (cur == null) {
            return;
        }
        for (Node n : cur.children) {
            if (!set.contains(n)) {
                set.add(n);
                //把两个点合并到一个集合
                un.union(cur, n);
                dfs(n, un, set);
            }
        }
    }

    //BFS
    public static int BFS(Tu graph) {
        //并查集
        UnionFind un = new UnionFind(graph);
        //避免重复调用
        Set<Node> set = new HashSet<>();
        //对邻接表中的每一个节点做bfs
        for (Node cur : graph.list) {
            Queue<Node> que = new LinkedList<>();
            que.add(cur);
            set.add(cur);
            while (!que.isEmpty()) {
                Node poll = que.poll();
                un.union(cur, poll);
                for (Node n : poll.children) {
                    if (!set.contains(n)) {
                        que.add(n);
                        set.add(n);
                    }
                }
            }
        }
        return un.size.size();
    }

}

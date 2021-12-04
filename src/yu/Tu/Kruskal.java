package yu.Tu;

import java.util.*;

public class Kruskal {
    public static class UnionFind {
        HashMap<Node, Node> parent;
        HashMap<Node, Integer> size;
        Deque<Node> stack = new LinkedList<>();

        public UnionFind(Graph graph) {
            parent = new HashMap<>();
            size = new HashMap<>();
            for (Node n : graph.nodes.values()) {
                parent.put(n, n);
                size.put(n, 1);
            }
        }

        private Node findFather(Node n) {
            while (parent.get(n) != n) {
                stack.push(n);
                n = parent.get(n);
            }
            while (!stack.isEmpty()) {
                parent.put(stack.pop(), n);
            }
            return n;
        }

        public void union(Node a, Node b) {
            Node fatherA = findFather(a);
            Node fatherB = findFather(b);
            if (fatherA != fatherB) {
                if (size.get(fatherA) >= size.get(fatherB)) {
                    parent.put(fatherB, fatherA);
                    size.put(fatherA, size.get(fatherA) + size.get(fatherB));
                    size.remove(fatherB);
                } else {
                    parent.put(fatherA, fatherB);
                    size.put(fatherB, size.get(fatherA) + size.get(fatherB));
                    size.remove(fatherA);
                }
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }
    }

    public static class MyComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        //用小根堆保存所有的边
        PriorityQueue<Edge> edges = new PriorityQueue<>(new MyComparator());
        UnionFind un = new UnionFind(graph);
        for (Edge cur : graph.edges) {
            edges.add(cur);
        }
        Set<Edge> ans = new HashSet<>();
        while (!edges.isEmpty()) {
            Edge cur = edges.poll();
            if (!un.isSameSet(cur.from, cur.to)) {
                ans.add(cur);
                un.union(cur.from, cur.to);
            }
        }
        return ans;
    }

}

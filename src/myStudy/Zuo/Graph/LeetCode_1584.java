package myStudy.Zuo.Graph;

import java.util.*;

public class LeetCode_1584 {
    public static void main(String[] args) {
        int[][] points = {{2, -3}, {-17, -8}, {13, 8}, {-17, -15}};
        System.out.println(minCostConnectPoints(points));
    }

    public static class myComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(new myComparator());
        Set<Node> alreadyConnected = new HashSet<>();
        ArrayList<Node> pointsList = new ArrayList<>();
        for (int[] point : points) {
            pointsList.add(new Node(point[0], point[1]));
        }
        int ans = 0;
        for (int i = 0; i < pointsList.size(); i++) {
            for (int j = i + 1; j < pointsList.size(); j++) {
                Node a = pointsList.get(i);
                Node b = pointsList.get(j);
                edges.add(new Edge(a, b, distance(a, b)));
            }
        }
        //以上，获得了所有点和所有边
        UnionFind un = new UnionFind(edges);
        while (!edges.isEmpty()) {
            Edge cur = edges.poll();
            if (!un.isSameSet(cur.from, cur.to)) {
                ans += cur.weight;
                un.union(cur.from, cur.to);
            }
        }
        return ans;
    }

    public static class UnionFind {
        HashMap<Node, Node> parent;

        public UnionFind(PriorityQueue<Edge> edges) {
            parent = new HashMap<>();
            for (Edge edge : edges) {
                parent.put(edge.from, edge.from);
                parent.put(edge.to, edge.to);
            }
        }

        private Node findFather(Node n) {
            while (parent.get(n) != n) {
                n = parent.get(n);
            }
            return n;
        }

        public void union(Node a, Node b) {
            Node fatherA = findFather(a);
            Node fatherB = findFather(b);
            if (fatherA != fatherB) {
                parent.put(fatherB, fatherA);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge {
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int distance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

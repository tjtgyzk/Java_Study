package myStudy.Zuo.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static class MyComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(new MyComparator());
        Set<Edge> ans = new HashSet<>();
        Set<Node> alreadyConnected = new HashSet<>();
        //随机从一个点开始
        for (Node n : graph.nodes.values()) {
            if (!alreadyConnected.contains(n)) {
                alreadyConnected.add(n);
                //解锁该点的边，加入小根堆
                for (Edge cur : n.edges) {
                    edges.add(cur);
                }
                while (!edges.isEmpty()) {
                    Edge cur = edges.poll();
                    if (!alreadyConnected.contains(cur.to)) {
                        alreadyConnected.add(cur.to);
                        ans.add(cur);
                        for (Edge to : cur.to.edges) {
                            edges.add(to);
                        }
                    }
                }
            }
            //break;
        }
        return ans;

    }
}

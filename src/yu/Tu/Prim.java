package yu.Tu;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Set<Edge> ans = new HashSet<>();
        Set<Node> alreadyConnected = new HashSet<>();
        //随机从一个点开始
        for (Node n : graph.nodes.values()) {
            if (!alreadyConnected.contains(n)) {
                alreadyConnected.add(n);
                //解锁它的边，放入小根堆
                for (Edge cur : n.edges) {
                    edges.add(cur);
                }
                while (graph.nodes.size() == alreadyConnected.size()) {
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

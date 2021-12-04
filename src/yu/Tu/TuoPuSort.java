package yu.Tu;

import java.util.*;

public class TuoPuSort {
    public static List<Node> sort(Graph graph) {
        //保存每个节点的剩余入度
        Map<Node, Integer> nodesIn = new HashMap<>();
        //只有入度为0的节点才能入队列，用于控制循环终止
        Queue<Node> zeroIn = new LinkedList<>();
        //找到一开始入度就为0的点，加入队列
        for (Node node : graph.nodes.values()) {
            nodesIn.put(node, node.in);
            if (node.in == 0) {
                zeroIn.add(node);
            }
        }
        List<Node> ans = new ArrayList<>();
        while (!zeroIn.isEmpty()) {
            Node cur = zeroIn.poll();
            ans.add(cur);
            for (Node next : cur.nexts) {
                nodesIn.put(next, nodesIn.get(next) - 1);
                if (nodesIn.get(next) == 0) {
                    zeroIn.add(next);
                }
            }
        }
        return ans;
    }
}

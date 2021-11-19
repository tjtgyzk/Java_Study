package myStudy.Zuo.Graph;

import java.util.*;

public class TopologicalSort {
    public static List<Node> sortedTopology(Graph graph) {
        //用于保存每个节点的剩余入度
        Map<Node, Integer> nodesIn = new HashMap<>();
        //只有入度为0的才能进队列，用于控制循环终止
        Queue<Node> zeroIn = new LinkedList<>();
        //拿到所有节点的入度,为0的入队列
        for (Node cur : graph.nodes.values()) {
            nodesIn.put(cur, cur.in);
            if (cur.in == 0) {
                zeroIn.add(cur);
            }
        }
        List<Node> ans = new LinkedList<>();
        while (!zeroIn.isEmpty()) {
            Node cur = zeroIn.poll();
            //弹出的时候加入结果
            ans.add(cur);
            for (Node next : cur.nexts) {
                //对当前节点的所有后继节点入度-1
                nodesIn.put(next, nodesIn.get(next) - 1);
                if (nodesIn.get(cur) == 0) {
                    //如果剩余入度为0，加入队列
                    zeroIn.add(next);
                }
            }
        }
        return ans;
    }
}

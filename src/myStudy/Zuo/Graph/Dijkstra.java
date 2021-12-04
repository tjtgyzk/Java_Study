package myStudy.Zuo.Graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node from) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        //打过对号的点
        Set<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            //minNode是跳转点，要算初始点到目标点的距离，初始点到跳转点的距离+跳转点到目标点的距离
            //初始点到跳转点的距离
            int distance = distanceMap.get(minNode);
            for (Edge cur : minNode.edges) {
                Node toNode = cur.to;
                if (distanceMap.containsKey(toNode)) {
                    //如果我在Map里有，那就和原来的选一个小的，distance是初始点到跳转点的距离，cur.weight(当前边的权重)是跳转点到目标点的距离，相加即为该次的距离
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + cur.weight));
                } else {
                    //如果没有，就直接给他，distance是初始点到跳转点的距离，cur.weight(当前边的权重)是跳转点到目标点的距离，相加即为该次的距离
                    distanceMap.put(toNode, distance + cur.weight);
                }
            }
            //给minNode挑对号了
            selectedNodes.add(minNode);
            //再找一个新的minNode
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, Set<Node> selectedNodes) {
        //遍历distanceMap，选择一个有值的，最小的，没打过对号的点
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}

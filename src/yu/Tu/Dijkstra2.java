package yu.Tu;

import java.util.HashMap;

public class Dijkstra2 {
    public static class NodeInfo {
        Node node;
        int distance;

        public NodeInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private Node[] nodes;
        private HashMap<Node, Integer> indexMap;
        private HashMap<Node, Integer> distanceMap;
        private int heapSize;

        public NodeHeap(int size) {
            nodes = new Node[size];
            indexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        private void swap(int i, int j) {
            indexMap.put(nodes[i], j);
            indexMap.put(nodes[j], i);
            Node temp = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = temp;
        }

        private void heapInsert(int index) {
            int father = (index - 1) / 2;
            //如果father比index大，index就要上去
            while (distanceMap.get(index) < distanceMap.get(father)) {//index==0,father==0
                swap(index, father);
            }
        }

        private void heapIfy(int index) {
            int leftKid = 2 * index + 1;
            while (leftKid < heapSize) {
                int small = (leftKid + 1 < heapSize) && (distanceMap.get(leftKid + 1) < distanceMap.get(leftKid)) ? leftKid + 1 : leftKid;
                small = distanceMap.get(small) < distanceMap.get(index) ? small : index;
                if (small == index) {
                    break;
                }
                swap(small, index);
                index = small;
                leftKid = 2 * index + 1;
            }

        }

        private boolean isEntered(Node node) {
            return indexMap.containsKey(node);
        }

        private boolean inHeap(Node node) {
            return isEntered(node) && (indexMap.get(node) != -1);
        }

        //add
        public void addOrUpdate(Node node, int distance) {
            if (!isEntered(node)) {
                nodes[heapSize] = node;
                indexMap.put(node, heapSize);
                distanceMap.put(node, distance);
                heapInsert(heapSize++);
            } else if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                heapInsert(indexMap.get(node));
            }
        }

        //pop
        public NodeInfo pop() {
            NodeInfo ans = new NodeInfo(nodes[0], distanceMap.get(nodes[0]));
            swap(0, heapSize - 1);
            indexMap.put(nodes[heapSize - 1], -1);
            nodes[--heapSize] = null;
            heapIfy(0);
            return ans;
        }
    }

    public static HashMap<Node, Integer> dijkstra(Node node, int size) {
        HashMap<Node, Integer> ans = new HashMap<>();
        NodeHeap heap = new NodeHeap(size);
        heap.addOrUpdate(node, 0);
        while (!heap.isEmpty()) {
            NodeInfo cur = heap.pop();
            Node n = cur.node;
            int distance = cur.distance;
            for (Edge e : n.edges) {
                heap.addOrUpdate(e.to, e.weight + distance);
            }
            ans.put(n, distance);
        }
        return ans;
    }
}

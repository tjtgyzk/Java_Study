package myStudy.Zuo.Graph;

import java.util.HashMap;

public class Dijkstra2 {
    //节点数据，保存节点和距离
    public static class NodeInfo {
        Node node;
        int distance;

        public NodeInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    //加强堆
    public static class NodeHeap {
        //堆结构
        private Node[] nodes;
        //反向索引表
        private HashMap<Node, Integer> indexMap;
        //保存节点对应的距离
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

        //上浮
        private void heapInsert(int index) {
            int father = (index - 1) / 2;
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[father])) {
                //如果index = 0,则两个数会相等，跳出循环
                swap(index, father);
            }
        }

        //下沉
        private void heapIfy(int index) {
            int leftKid = 2 * index + 1;
            while (leftKid < heapSize) {
                int small = (leftKid + 1 < heapSize) && distanceMap.get(leftKid) > distanceMap.get(leftKid + 1) ? leftKid + 1 : leftKid;
                small = distanceMap.get(small) < distanceMap.get(index) ? small : index;
                if (small == index) {
                    break;
                }
                swap(small, index);//如果index更大，把index沉下去
                index = small;
                leftKid = 2 * index + 1;

            }
        }

        //判断一个节点是否进过堆
        private boolean isEntered(Node node) {
            return indexMap.containsKey(node);
        }

        //判断一个节点是不是在堆里，首先是没进来过的，其次是出去过挑过勾的，为了区别，将弹出去的indexMap设置成-1
        private boolean inHeap(Node node) {
            return isEntered(node) && indexMap.get(node) != -1;
        }

        public NodeInfo pop() {
            NodeInfo ans = new NodeInfo(nodes[0], distanceMap.get(nodes[0]));
            swap(0, heapSize - 1);//与最后一个节点交换位置
            indexMap.put(nodes[heapSize - 1], -1);//弹出的设置为-1
            nodes[--heapSize] = null;//删除最后一个节点，减小长度
            heapIfy(0);
            return ans;
        }

        //添加进来一个节点，如果之前没有距离记录，则加入，如果有，则更新
        public void addOrUpdate(Node node, int distance) {
            if (!isEntered(node)) {
                //不存在，添加,-1视为不存在
                nodes[heapSize] = node;
                indexMap.put(node, heapSize);
                distanceMap.put(node, distance);
                heapInsert(heapSize++);
            } else if (inHeap(node)) {
                //存在，更新
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                heapInsert(indexMap.get(node));
            }
        }
    }

    public static HashMap<Node, Integer> dijkstra(Node head, int size) {
        HashMap<Node, Integer> res = new HashMap<>();
        NodeHeap heap = new NodeHeap(size);
        heap.addOrUpdate(head, 0);
        while (!heap.isEmpty()) {
            NodeInfo info = heap.pop();
            Node cur = info.node;
            int distance = info.distance;
            for (Edge e : cur.edges) {
                heap.addOrUpdate(e.to, e.weight + distance);
            }
            res.put(cur, distance);
        }
        return res;
    }
}

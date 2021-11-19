package myStudy.Zuo.Union;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class Union {
    public static class Node<T> {
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class UnionFind<T> {
        public HashMap<T, Node<T>> findNodes;//用于找到传入数据对应的节点类
        public HashMap<Node<T>, Node<T>> father;//保存每个节点的代表节点是谁
        public HashMap<Node<T>, Integer> sizeMap;//每个代表节点所在的集合大小，仅保存代表节点数据

        public UnionFind(List<T> values) {
            findNodes = new HashMap<>();
            father = new HashMap<>();
            sizeMap = new HashMap<>();
            for (T value : values) {
                Node<T> cur = new Node<>(value);
                findNodes.put(value, cur);
                father.put(cur, cur);
                sizeMap.put(cur, 1);
            }
        }

        public Node<T> findFather(Node<T> cur) {
            Deque<Node<T>> pathNodes = new ArrayDeque<>();
            while (cur != father.get(cur)) {
                pathNodes.push(cur);
                cur = father.get(cur);
            }
            while (!pathNodes.isEmpty()) {
                father.put(pathNodes.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(T a, T b) {
            return findFather(findNodes.get(a)) == findFather(findNodes.get(b));
        }

        //合并集合
        public void union(T a, T b) {
            Node<T> aHead = findFather(findNodes.get(a));
            Node<T> bHead = findFather(findNodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<T> bigHead = aSetSize >= bSetSize ? aHead : bHead;
                Node<T> smallHead = bigHead == aHead ? bHead : aHead;
                father.put(smallHead, bigHead);
                sizeMap.put(bigHead, aSetSize + bSetSize);
                sizeMap.remove(smallHead);
            }
        }

        //查询一共有几个集合
        public int setsNum() {
            return sizeMap.size();
        }
    }


}

package yu.Bing;

import java.util.*;

public class BCJ {
    public static class Node<T> {
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class UnionFind<T> {
        public HashMap<Node<T>, Node<T>> parent;
        public HashMap<Node<T>, Integer> size;

        public UnionFind(List<Node<T>> lists) {
            parent = new HashMap<>();
            size = new HashMap<>();
            for (Node cur : lists) {
                parent.put(cur, cur);
                size.put(cur, 1);
            }
        }

        public Node<T> findFather(Node<T> n) {
            Deque<Node<T>> stack = new LinkedList<>();
            while (parent.get(n) != n) {
                stack.push(n);
                n = parent.get(n);
            }//n已经是爹了
            while (!stack.isEmpty()) {
                parent.put(stack.pop(), n);
            }
            return n;
        }

        public void union(Node<T> a, Node<T> b) {
            Node<T> fatherA = findFather(a);
            Node<T> fatherB = findFather(b);
            if (fatherA != fatherB) {
                Node<T> small = size.get(fatherA) >= size.get(fatherB) ? fatherB : fatherA;
                Node<T> big = small == fatherA ? fatherB : fatherA;
                parent.put(small, big);
                size.put(big, size.get(small) + size.get(big));
                size.remove(small);
            }
        }

        public boolean isSameSet(Node<T> a, Node<T> b) {
            return findFather(a) == findFather(b);
        }

        public int setsNum() {
            return size.size();
        }

    }

}

package myStudy.Zuo.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> que = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        que.add(start);
        set.add(start);
        while (!que.isEmpty()) {
            Node cur = que.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    que.add(next);
                    set.add(next);
                }
            }
        }
    }
}

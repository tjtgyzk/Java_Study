package myStudy.Zuo.Graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS {
    public static void dfs(Node start) {
        if (start == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        stack.push(start);
        System.out.println(start.value);
        set.add(start);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {//如果set中没有该点
                    set.add(next);
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}

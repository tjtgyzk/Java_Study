package LeetCode.String.Statistics;

import java.util.*;

public class L451 {
    public String frequencySort(String s) {
        //统计频次,按频次排序,字符串拼接
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int newValue = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), newValue);
        }
        PriorityQueue<Map.Entry<Character, Integer>> que = new PriorityQueue<>((o1, o2) -> (o2.getValue() - o1.getValue()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            que.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            Map.Entry<Character, Integer> cur = que.poll();
            for (int i = 0; i < cur.getValue(); i++) {
                sb.append(cur.getKey());
            }
        }
        return sb.toString();
    }
}

package LeetCode.SwardOffer.II;

import java.util.*;

public class OfferII_114 {
    //拓扑排序

    // 用于保存每个点和该点指向不同子点的所有边
    Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
    // 用于保存每个点的入度
    Map<Character, Integer> indegrees = new HashMap<Character, Integer>();
    // 记录是否合法
    boolean valid = true;

    public String alienOrder(String[] words) {
        int length = words.length;
        // 先对每个字符点创建空的边集加入map
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }
        //加入边
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        //如果有非法字符,直接返回空
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<Character>();
        Set<Character> letterSet = edges.keySet();
        // 对于每一个起始点,如果不存在该点的入度,说明初始入度为0,加入队列
        for (char u : letterSet) {
            if (!indegrees.containsKey(u)) {
                queue.offer(u);
            }
        }
        StringBuffer order = new StringBuffer();
        while (!queue.isEmpty()) {
            //弹出队列的都是入度为0的点,加入结果中
            char u = queue.poll();
            order.append(u);
            //对于加入结果的每一个点,将其边中对应的点的入度减1
            //如果减完入度为0,则加入队列
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                indegrees.put(v, indegrees.get(v) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }
        //最后如果所有点都加入结果中,说明无环,返回结果,否则说明有环,返回空
        return order.length() == edges.size() ? order.toString() : "";
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                // 加入c1的边
                edges.get(c1).add(c2);
                // 更新c2的入度
                indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }
        //如果前面字符都一样,但第一个字符的长度更长,显然违背字典序,返回空值
        if (index == length && length1 > length2) {
            valid = false;
        }
    }
}

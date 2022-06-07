package LeetCode.SwardOffer.II;

import java.util.HashMap;
import java.util.Map;

public class OfferII_66 {
    class Node {
        int val;
        Node[] next;

        public Node() {
            val = 0;
            next = new Node[26];
        }
    }

    class MapSum {
        /**
         * Initialize your data structure here.
         */
        Map<String, Integer> map;
        Node head;

        public MapSum() {
            head = new Node();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int dif = val - map.getOrDefault(key, 0);
            map.put(key, val);
            Node cur = head;
            char[] chars = key.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (cur.next[path] == null) {
                    cur.next[path] = new Node();
                }
                cur = cur.next[path];
                cur.val += dif;
            }
        }

        public int sum(String prefix) {
            Node cur = head;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (cur.next[path] == null) {
                    return 0;
                }
                cur = cur.next[path];
            }
            return cur.val;
        }
    }
}

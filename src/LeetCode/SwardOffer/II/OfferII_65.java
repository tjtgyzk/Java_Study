package LeetCode.SwardOffer.II;

import java.util.HashSet;
import java.util.Set;

public class OfferII_65 {
    public int minimumLengthEncoding(String[] words) {
        //逆序插入单词,相同后缀问题转化为相同前缀问题
        Trie trie = new Trie();
        int ans = 0;
        Set<Node> map = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            map.add(trie.insert(new StringBuilder(words[i]).reverse().toString()));
        }
        for (Node node : map) {
            if (node.pass == 0) {
                ans += node.length + 1;
            }
        }
        return ans;
    }

    public class Node {
        Node[] next;
        int pass;
        int length;

        public Node() {
            next = new Node[26];
            pass = 0;
            length = 0;
        }
    }

    public class Trie {
        Node head;

        public Trie() {
            head = new Node();
        }

        public Node insert(String word) {
            char[] chars = word.toCharArray();
            int len = 0;
            Node cur = head;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (cur.next[path] == null) {
                    cur.next[path] = new Node();
                }
                len++;
                cur.pass++;
                cur = cur.next[path];
            }
            cur.length = len;
            return cur;
        }
    }

    public static void main(String[] args) {
        new OfferII_65().minimumLengthEncoding(new String[]{"time", "me", "bell"});
    }
}

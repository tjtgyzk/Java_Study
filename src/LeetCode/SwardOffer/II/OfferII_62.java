package LeetCode.SwardOffer.II;

public class OfferII_62 {
    class Node {
        //经过当前节点的单词数
        int pass;
        //以当前节点结尾的单词数
        int end;
        //路径
        Node[] next;

        public Node() {
            pass = 0;
            end = 0;
            next = new Node[26];
        }
    }

    class Trie {

        //头节点,pass和end永远为0
        Node head;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] words = word.toCharArray();
            Node cur = head;
            for (int i = 0; i < words.length; i++) {
                int path = words[i] - 'a';
                if (cur.next[path] == null) {
                    //该路径没被初始化过
                    cur.next[path] = new Node();
                }
                cur = cur.next[path];
                cur.pass++;
            }
            cur.end++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] words = word.toCharArray();
            Node cur = head;
            for (int i = 0; i < words.length; i++) {
                int path = words[i] - 'a';
                if (cur.next[path] == null) {
                    return false;
                }
                cur = cur.next[path];
            }
            return cur.end != 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] words = prefix.toCharArray();
            Node cur = head;
            for (int i = 0; i < words.length; i++) {
                int path = words[i] - 'a';
                if (cur.next[path] == null) {
                    return false;
                }
                cur = cur.next[path];
            }
            return true;
        }
    }
}

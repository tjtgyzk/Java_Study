package myStudy.Zuo.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public static class Node {
        public int pass;
        public int end;
        public Node[] next;

        public Node() {
            pass = 0;
            end = 0;
            next = new Node[26];
        }
    }

    public static class Trie1 {
        private Node head;

        public Trie1() {
            head = new Node();
        }

        //添加单词
        public void insert(String str) {
            if (str == null) {
                System.out.println("单词为空");
                return;
            }
            char[] chars = str.toCharArray();
            Node node = head;
            for (int i = 0; i < chars.length; i++) {//遍历单词中的每一个字母
                int path = chars[i] - 'a';//asc码，计算该字母对应路径
                if (node.next[path] == null) {
                    node.next[path] = new Node();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
        }

        //查找单词有几次
        public int serch(String str) {
            if (str == null) {
                System.out.println("单词为空");
                return 0;
            }
            char[] chars = str.toCharArray();
            Node node = head;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        //删除单词
        public void delete(String str) {
            if (serch(str) != 0) {
                char[] chars = str.toCharArray();
                Node node = head;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (--node.next[index].pass == 0) {//这里已经对pass-1
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }
        }

        //查找以pre开头的单词数
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node node = head;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.pass;
        }

    }


}

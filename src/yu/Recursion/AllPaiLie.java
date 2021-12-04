package yu.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPaiLie {
    public static List<String> function1(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<Character> rest = new ArrayList<>();
        for (char c : chars) {
            rest.add(c);
        }
        String cur = "";
        List<String> ans = new ArrayList<>();
        process1(rest, cur, ans);
        return ans;
    }

    public static void process1(List<Character> rest, String cur, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(cur);
            return;
        }
//        for (Character c : rest) {
//            cur += c;
//            rest.remove(c);
//            process(rest, cur, ans);
//            rest.add(c);
//        }
        int N = rest.size();
        for (int i = 0; i < N; i++) {
            char c = rest.get(i);
            rest.remove(i);
            process1(rest, cur + c, ans);
            rest.add(i, c);
        }
    }

    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(function1(s));
        System.out.println("==============================");
        System.out.println(function2(s));
        System.out.println("==============================");
        System.out.println(function3(s));

    }

    public static List<String> function2(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();
        process2(chars, 0, ans);
        return ans;
    }

    public static void process2(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            process2(chars, index + 1, ans);
            swap(chars, i, index);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static List<String> function3(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();
        process3(chars, 0, ans);
        return ans;
    }

    public static void process3(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        boolean[] check = new boolean[256];
        for (int i = index; i < chars.length; i++) {
            if (!check[chars[i]]) {
                check[chars[i]] = true;
                swap(chars, i, index);
                process3(chars, index + 1, ans);
                swap(chars, i, index);
            }
        }
    }

}

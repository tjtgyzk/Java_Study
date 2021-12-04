package yu.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubArray {
    public static void process(String cur, int index, char[] chars, List<String> ans) {
        if (index == chars.length) {
            ans.add(cur);
            return;
        }
        //index的位置要
        process(cur + chars[index], index + 1, chars, ans);
        //index位置不要
        process(cur, index + 1, chars, ans);
    }

    public static List<String> get(String s) {
        if (s == null) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        String cur = "";
        process(cur, 0, chars, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "acc";
        System.out.println(get(s));
        System.out.println("=================");
        System.out.println(get1(s));
    }

    public static void process1(String cur, int index, char[] chars, HashSet<String> ans) {
        if (index == chars.length) {
            ans.add(cur);
            return;
        }
        //index的位置要
        process1(cur + chars[index], index + 1, chars, ans);
        //index位置不要
        process1(cur, index + 1, chars, ans);
    }

    public static List<String> get1(String s) {
        if (s == null) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        char[] chars = s.toCharArray();
        String cur = "";
        process1(cur, 0, chars, res);
        for (String p : res) {
            ans.add(p);
        }
        return ans;
    }
}

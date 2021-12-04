package myStudy.Zuo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubStr {
    public static void process(String cur, int index, char[] chars, List<String> ans) {
        if (index == chars.length) {
            ans.add(cur);
            return;
        }
        //index的位置的字母要
        process(cur + chars[index], index + 1, chars, ans);
        //index位置的字母不要
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
        String str = "acc";
        System.out.println(get(str));
    }
}

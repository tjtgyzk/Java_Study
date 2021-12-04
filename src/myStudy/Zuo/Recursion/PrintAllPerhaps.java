package myStudy.Zuo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPerhaps {
    //方法一：
    public static List<String> fuction1(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<Character> rest = new ArrayList<>();
        for (char c : chars) {
            rest.add(c);
        }
        List<String> ans = new ArrayList<>();
        String cur = "";
        process1(rest, cur, ans);
        return ans;
    }

    public static void process1(List<Character> rest, String cur, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(cur);
            return;
        }
        //不能这么写，增强for不允许用remove和add
//        for (Character c : rest) {
//            char curC = c;
//            rest.remove(curC);
//            process1(rest,cur+curC,ans);
//            //恢复现场
//            rest.add(curC);
//
//        }
        int N = rest.size();
        for (int i = 0; i < N; i++) {
            char curC = rest.get(i);
            rest.remove(i);
            process1(rest, cur + curC, ans);
            rest.add(i, curC);
        }
    }

    //方法二：
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
            swap(chars, index, i);
            process2(chars, index + 1, ans);
            //恢复现场
            swap(chars, i, index);
        }
    }

    //方法二-剪枝
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
                swap(chars, index, i);
                process3(chars, index + 1, ans);
                //恢复现场
                swap(chars, i, index);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        String s = "acc";
        System.out.println(fuction1(s));
        System.out.println(function2(s));
        System.out.println(function3(s));

    }
}

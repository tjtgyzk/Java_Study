package LeetCode.SwardOffer.II;

import java.util.*;

public class OfferII_109 {
    Set<String> seen = new HashSet<>();
    Set<String> dead = new HashSet<>();

    //dfs会死
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        if ("0000".equals(target)) {
            return 0;
        }
        for (String deadStr : deadends) {
            dead.add(deadStr);
            if (target.equals(deadStr)) {
                return -1;
            }
        }
        if (dead.contains("0000")) {
            return -1;
        }
        queue.add("0000");
        seen.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            //为了保证step的正确性
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String cur = queue.poll();
                List<String> next = next(cur);
                List<String> pre = pre(cur);
                for (String n : next) {
                    seen.add(n);
                    if (n.equals(target)) {
                        return step;
                    }
                    queue.add(n);
                }
                for (String n : pre) {
                    seen.add(n);
                    if (n.equals(target)) {
                        return step;
                    }
                    queue.add(n);
                }
            }
        }
        return -1;
    }

//    public int dfs(String cur, String target) {
//        if (seen.containsKey(cur)) {
//            return seen.get(cur);
//        }
//        if (cur.equals(target)) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        List<String> next = next(cur);
//        List<String> pre = pre(cur);
//        for (String n : next) {
//            if (dead.contains(n)) {
//                continue;
//            }
//            int nextAns = dfs(n, target);
//            if (nextAns != Integer.MAX_VALUE) {
//                ans = Math.min(ans, nextAns + 1);
//            }
//            seen.put(n, ans);
//        }
//        for (String n : pre) {
//            if (dead.contains(n)) {
//                continue;
//            }
//            int nextAns = dfs(n, target);
//            if (nextAns != Integer.MAX_VALUE) {
//                ans = Math.min(ans, nextAns + 1);
//            }
//            seen.put(n, ans);
//        }
//        return ans;
//    }

    public List<String> next(String cur) {
        char[] chars = cur.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[i] == '9' ? '0' : (char) (chars[i] + 1);
            String s = new String(chars);
            if (seen.contains(s) || dead.contains(s)) {
                //这里记得恢复现场
                chars[i] = temp;
                continue;
            }
            result.add(s);
            chars[i] = temp;
        }
        return result;
    }

    public List<String> pre(String cur) {
        char[] chars = cur.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[i] == '0' ? '9' : (char) (chars[i] - 1);
            String s = new String(chars);
            if (seen.contains(s) || dead.contains(s)) {
                //这里记得恢复现场
                chars[i] = temp;
                continue;
            }
            result.add(new String(chars));
            chars[i] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_109().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}

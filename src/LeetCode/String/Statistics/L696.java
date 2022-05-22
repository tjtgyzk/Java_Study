package LeetCode.String.Statistics;

import java.util.Deque;
import java.util.LinkedList;

public class L696 {
    public int countBinarySubstrings(String s) {
        //用两个栈,同理两个变量也可
        //1110100中,最后一个0会匹配到之前剩的1,所以每次新的一组1到时,要清除之前剩的1;对于0同理
        //
        //也可以统计连续字符的个数,比如1110100为{3,1,1,2},统计该数组连续值间的最小值之和即可,更简单
        Deque<Integer> zero = new LinkedList<>();
        Deque<Integer> one = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i != 0 && s.charAt(i) != s.charAt(i - 1)) {
                    //新的一组0
                    zero.clear();
                }
                zero.push(0);
                if (!one.isEmpty()) {
                    one.pop();
                    ans++;
                }
            } else {
                if (i != 0 && s.charAt(i) != s.charAt(i - 1)) {
                    //新的一组1
                    one.clear();
                }
                one.push(1);
                if (!zero.isEmpty()) {
                    zero.pop();
                    ans++;
                }
            }
        }
        return ans;
    }
    /*
        public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

    */

    public static void main(String[] args) {
        System.out.println(new L696().countBinarySubstrings("00111011"));
    }
}

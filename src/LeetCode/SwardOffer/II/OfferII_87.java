package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_87 {
    int[] temp = new int[4];
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0, 0, s);
        return ans;
    }

    /**
     * @param id    第几个ip字段
     * @param index 从第几个字段开始
     * @param s     ip字符串
     */
    public void dfs(int id, int index, String s) {
        if (id == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(temp[i]);
                    if (i != 3) {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        //如果没有凑够4个ip字段就遇到了结尾
        if (index == s.length()) {
            return;
        }
        if (s.charAt(index) == '0') {
            //前导0,则只能0自己一个字段
            temp[id] = 0;
            dfs(id + 1, index + 1, s);
        }
        //正常情况
        int curNum = 0;
        for (int i = index; i < s.length(); i++) {
            curNum = 10 * curNum + (s.charAt(i) - '0');
            if (curNum > 0 && curNum <= 255) {
                temp[id] = curNum;
                dfs(id + 1, i + 1, s);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_87().restoreIpAddresses("25525511135"));
    }
}

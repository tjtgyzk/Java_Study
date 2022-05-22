package LeetCode.SwardOffer.I;

import java.util.ArrayList;
import java.util.List;

public class Offer38 {
    List<String> ans = new ArrayList<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        char[] chars = s.toCharArray();
        process(chars, 0);
        return ans.toArray(new String[ans.size()]);
    }

    public void process(char[] chars, int index) {
        //交换
        if (index == chars.length - 1) {
            ans.add(String.valueOf(chars));
        }
        //baac,b和第一个a换过则不需要再换第二个a了
        boolean[] visited = new boolean[256];
        for (int i = index; i < chars.length; i++) {
            if (!visited[chars[i]]) {
                visited[chars[i]] = true;
                swap(chars, index, i);
                process(chars, index + 1);
                //恢复现场
                swap(chars, i, index);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        new Offer38().permutation("baaac");
    }
}

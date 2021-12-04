package yu.DynamicProgramming;

import java.util.HashMap;

public class Stickers {
    public static int function1(String[] stickers, String target) {
        int ans = process(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //stickers[]
    //rest我还需要什么字母
    public static int process(String[] stickers, String rest) {
        if (rest.length() == 0) {
            //拿够了，我接下来一张贴纸都不用选了
            return 0;
        }
        //后面的能不能拼出来
        int min = Integer.MAX_VALUE;
        for (String s : stickers) {
            //现在是上一个调用我的函数给我的rest，cur = rest-s剩的字母,cur想作为下一个rest
            String cur = minus(rest, s);
            if (cur.length() != rest.length()) {
                //说明这个s我要了
                min = Math.min(min, process(stickers, cur));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);

    }

    public static String minus(String s1, String s2) {
        //要s1-s2剩余的字母
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //可以用一个长度为26的int数组，来统计每个字母出现的次数
        //统计被减数的
        int[] count = new int[26];
        for (char c : str1) {
            count[c - 'a']++;
        }
        //知道被减数的每个字母的个数
        //遍历减数的每个字母，它是谁，就把被减数的对应字母个数-1
        for (char c : str2) {
            count[c - 'a']--;
        }
        //得到的是减过之后的结果的每个字母的个数，有可能有负的，没事儿，要的是剩的字母
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    public static int minStickers(String[] stickers, String target) {
        int[][] stickersCount = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            char[] cur = stickers[i].toCharArray();
            for (char c : cur) {
                stickersCount[i][c - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process2(stickersCount, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process2(int[][] stickers, String target, HashMap<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        if (target.length() == 0) {
            return 0;
        }
        //target的词频统计
        char[] targets = target.toCharArray();
        int[] count = new int[26];
        for (char c : targets) {
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            if (sticker[targets[0] - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    int num = count[i] - sticker[i];
                    while (num-- > 0) {
                        sb.append((char) (i + 'a'));
                    }
                }
                String rest = sb.toString();
                min = Math.min(min, process2(stickers, rest, dp));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] stickers = {"these", "guess", "about", "garden", "him"};
        String target = "atomher";
        System.out.println(function1(stickers, target));
        System.out.println(minStickers(stickers, target));

    }
}

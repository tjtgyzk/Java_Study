package myStudy.Zuo.DynamicProgramming;

import java.util.HashMap;

public class Sticker {
    public static int minStickers(String[] stickers, String target) {
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process1(stickers, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process1(String[] stickers, String rest, HashMap<String, Integer> dp) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }
        if (rest.length() == 0) {
            //如果rest==0，说明已经满足了题目要求，这次递归没有使用任何贴纸，返回0
            return 0;
        }
        //设置为异常值，如果到最后还是MAX_VALUE,则证明剩余的单词不能用贴画贴出来，返回0；
        int min = Integer.MAX_VALUE;
        for (String s : stickers) {
            //每次都拿每一个贴画开始试
            //cur为rest减去所选择的贴画剩余的字符串
            String cur = minus(rest, s);
            //如果s中有目标字母，rest的长度真的减少了，再递归调用继续减，否则保持min为无效值
            //注意，如果进行下面的if，则说明当前贴画s被选择了，则最终结果要+1
            if (rest.length() != cur.length()) {
                //min = process1(stickers, cur);
                //注意，上述代码错误是因为min可能在之前的递归中已经得到了更小的结果，所以要在min和递归结果的返回值中选择一个更小的
                min = Math.min(min, process1(stickers, cur, dp));
            }
        }
        //由于第20行所述，如果min为有效值，要在结果加一
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(rest, ans);
        return ans;
    }

    public static String minus(String rest, String s) {
        char[] rests = rest.toCharArray();
        char[] ss = s.toCharArray();
        //统计rests中的各字母数量
        int[] count = new int[26];
        for (char cur : rests) {
            count[cur - 'a']++;
        }
        //根据ss删除rests中对应数量的字母
        for (int i = 0; i < ss.length; i++) {
            count[ss[i] - 'a']--;
        }
        //重建出删除后的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    public static int minStickers1(String[] stickers, String target) {
        //一个int类型的二维数组，存放每个sticker的字母频率
        int[][] sticker = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            char[] curs = stickers[i].toCharArray();
            for (char c : curs) {
                sticker[i][c - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process2(sticker, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process2(int[][] stickers, String target, HashMap<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        if (target.length() == 0) {
            return 0;
        }
        //target的字母频率统计
        //放到for循环里可以做到恢复现场，不然再选择下一个sticker时targets词频数组会出错
        //如果放到外面，则必须在生成rest的时候不动target的值
        int[] targets = new int[26];
        char[] targetChars = target.toCharArray();
        for (char c : targetChars) {
            targets[c - 'a']++;
        }
        //遍历每一个stickers
        int min = Integer.MAX_VALUE;//无效值
        for (int[] sticker : stickers) {
            //只有在存在target中的第一个字母时，才选择它作为第一张贴纸
            //这是一个剪枝过程，对最后结果不会有影响，能减少递归的次数，是一种贪心算法
            if (sticker[targetChars[0] - 'a'] > 0) {
                //对于每一个sticker的字母，算出剪掉后剩余几个，不能直接在target中减掉
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (targets[i] > 0) {
                        int num = targets[i] - sticker[i];
                        while (num-- > 0) {
                            sb.append((char) (i + 'a'));
                        }
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
        System.out.println(minStickers(stickers, target));
        System.out.println(minStickers1(stickers, target));
    }
}

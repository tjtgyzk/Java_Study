package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferII_33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //用map存count数组生成的字符串以及对应的List<String>
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) {
                    sb.append(i + 'a');
                    sb.append(cnt[i]);
                }
            }
            List<String> curList = map.getOrDefault(sb.toString(), new ArrayList<String>());
            curList.add(str);
            map.put(sb.toString(), curList);
        }
        return new ArrayList<>(map.values());
    }
}

package LeetCode.String.Statistics;

import java.util.*;

public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //使用哈希表,key放置每个异位词的词根,value放对应的结果List
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

package LeetCode;

import java.util.*;

public class L433 {
    //存s对应的bank中只相差一位的基因
    HashMap<String, List<String>> bankMap = new HashMap<>();
    List<String> list = new ArrayList<>();

    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        for (int i = 0; i < bank.length; i++) {
            List<String> curListI = bankMap.getOrDefault(bank[i], new ArrayList<>());
            for (int j = i + 1; j < bank.length; j++) {
                List<String> curListJ = bankMap.getOrDefault(bank[j], new ArrayList<>());
                if (findNumDiff(bank[i], bank[j]) == 1) {
                    curListI.add(bank[j]);
                    curListJ.add(bank[i]);
                    bankMap.put(bank[i], curListI);
                    bankMap.put(bank[j], curListJ);
                }
            }
        }
        for (int i = 0; i < bankMap.size(); i++) {
            if (findNumDiff(start, bank[i]) == 1) {
                list.add(bank[i]);
            }
        }
        if (!bankMap.containsKey(end) || list.size() == 0) {
            return -1;
        }
        int maxLength = findNumDiff(start, end);
        if (maxLength == 1) {
            return 1;
        }
        int ans = 1;
        for (String s : list) {
            HashSet<String> set = new HashSet<>();
            Queue<String> que = new LinkedList<>();
            que.add(s);
            set.add(s);
            while (!que.isEmpty()) {
                int temp = ans;
                String cur = que.poll();
                List<String> curList = bankMap.get(cur);
                for (String curr : curList) {
                    if (!set.contains(curr)) {
                        set.add(curr);
                        que.add(curr);
                        temp++;
                    }
                    if (curr == end) {
                        ans = Math.min(ans, temp);
                    }
                }
            }
        }
        return ans;
    }

    public int findNumDiff(String a, String b) {
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(new L433().minMutation(start, end, bank));
    }
}

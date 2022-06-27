package LeetCode.SwardOffer.II;

import java.util.*;

public class OfferII_115 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> seqs) {
        //通过拓扑排序，找出序列，拓扑排序的每一步仅能有一个可选择的点，看结果是否与给定序列相同
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Set<Integer>> edge = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int from = seq.get(i);
                int to = seq.get(i + 1);
                Set<Integer> setFrom = edge.getOrDefault(from, new HashSet<>());
                Integer inTo = in.getOrDefault(to, 0);
                if (setFrom.contains(to)) {
                    continue;
                } else {
                    setFrom.add(to);
                    inTo++;
                    edge.put(from, setFrom);
                    in.put(to, inTo);
                }
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!in.containsKey(nums[i])) {
                que.add(nums[i]);
            }
        }
        if (que.size() != 1) {
            return false;
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (!que.isEmpty()) {
            Integer poll = que.poll();
            ans[index++] = poll;
            Set<Integer> curTo = edge.get(poll);
            if (curTo == null) {
                continue;
            }
            for (Integer to : curTo) {
                Integer integer = in.get(to);
                integer--;
                if (integer == 0) {
                    que.add(to);
                }
                in.put(to, integer);
            }
            if (que.size() > 1) {
                return false;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        List<Integer> seq1 = new ArrayList<>();
        seq1.add(1);
        seq1.add(2);
        List<Integer> seq2 = new ArrayList<>();
        seq2.add(1);
        seq2.add(3);
        List<Integer> seq3 = new ArrayList<>();
        seq3.add(2);
        seq3.add(3);
        seqs.add(seq1);
        seqs.add(seq2);
        seqs.add(seq3);
        System.out.println(new OfferII_115().sequenceReconstruction(org, seqs));
    }
}

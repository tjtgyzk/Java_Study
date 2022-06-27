package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_110 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return ans;
    }

    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {
            temp.add(node);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        if (graph[node] == null || graph[node].length == 0) {
            return;
        }
        temp.add(node);
        for (int neibour : graph[node]) {
            dfs(graph, neibour);
        }
        temp.remove(temp.size() - 1);
    }
}

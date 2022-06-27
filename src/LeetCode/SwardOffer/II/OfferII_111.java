package LeetCode.SwardOffer.II;

import java.util.*;

public class OfferII_111 {
    class Edge {
        double val;
        String to;

        public Edge(double val, String to) {
            this.val = val;
            this.to = to;
        }
    }

    Set<String> seen = new HashSet<>();
    boolean findAns = false;
    Map<String, List<Edge>> map = new HashMap<>();
    List<Double> result = new ArrayList<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String node1 = equations.get(i).get(0);
            String node2 = equations.get(i).get(1);
            List<Edge> edges1 = map.getOrDefault(node1, new ArrayList<>());
            edges1.add(new Edge(values[i], node2));
            List<Edge> edges2 = map.getOrDefault(node2, new ArrayList<>());
            edges2.add(new Edge(1 / values[i], node1));
            map.put(node1, edges1);
            map.put(node2, edges2);
        }
        for (int i = 0; i < queries.size(); i++) {
            String begin = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            findAns = false;
            if (!map.containsKey(begin) || !map.containsKey(end)) {
                result.add(-1.0);
                continue;
            }
            seen.add(begin);
            dfs(begin, end, 1.0);
            seen.remove(begin);
            if (!findAns) {
                result.add(-1.0);
            }
        }
        double[] ans = new double[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public void dfs(String cur, String end, double curAns) {
        if (findAns) {
            return;
        }
        if (cur.equals(end)) {
            result.add(curAns);
            findAns = true;
            return;
        }
        List<Edge> edges = map.get(cur);
        if (edges == null) {
            return;
        }
        for (Edge edge : edges) {
            if (seen.contains(edge.to)) {
                continue;
            }
            seen.add(edge.to);
            dfs(edge.to, end, curAns * edge.val);
            seen.remove(edge.to);
            if (findAns) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String[][] strs = {{"a", "b"}, {"b", "c"}};
        String[][] strs1 = {{"a", "c"}, {"b", "a"}};
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of(strs[0]));
        equations.add(List.of(strs[1]));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of(strs1[0]));
        queries.add(List.of(strs1[1]));
        new OfferII_111().calcEquation(equations, values, queries);
    }
}

package LeetCode.SwardOffer.II;

public class OfferII_106 {
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int NO = 0;
    public boolean valid = true;

    public boolean isBipartite(int[][] graph) {
        //染色
        int[] nodeColor = new int[graph.length];
        for (int i = 0; i < graph.length && valid; i++) {
            if (nodeColor[i] == NO) {
                dfs(i, RED, graph, nodeColor);
            }

        }
        return valid;
    }

    public void dfs(int index, int color, int[][] graph, int[] nodeColor) {
        if (!valid) {
            return;
        }
        nodeColor[index] = color;
        int nextColor = color == RED ? GREEN : RED;
        for (int neighbors : graph[index]) {
            if (nodeColor[neighbors] == NO) {
                //没涂过才递归
                dfs(neighbors, nextColor, graph, nodeColor);
            } else if (nodeColor[neighbors] != nextColor) {
                valid = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_106().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}

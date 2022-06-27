package LeetCode.SwardOffer.II;

public class OfferII_118 {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        //并查集
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int fatherA = findFather(edge[0]);
            int fatherB = findFather(edge[1]);
            if (fatherA == fatherB) {
                return edge;
            } else {
                parent[fatherB] = fatherA;
            }
        }
        return null;
    }

    public int findFather(int a) {
        while (a != parent[a]) {
            a = parent[a];
        }
        return a;
    }
}

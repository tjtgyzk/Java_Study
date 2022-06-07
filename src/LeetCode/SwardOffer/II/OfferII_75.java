package LeetCode.SwardOffer.II;

public class OfferII_75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //桶排序
        int[] bucket = new int[1001];
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            bucket[arr1[i]]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            while (bucket[arr2[i]]-- > 0) {
                ans[index++] = arr2[i];
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}

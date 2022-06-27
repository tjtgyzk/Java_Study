package LeetCode.SwardOffer.II;

import java.util.HashMap;
import java.util.Map;

public class OfferII_93 {
    public int lenLongestFibSubseq(int[] arr) {
        //使用一个fib数列的最后两项j,k可以唯一确定一组fib数列,例如[0,2,3,5,8]可以用[5,8]唯一确定[2,3,5,8]
        //已知j,k,可以由arr[k]-arr[j]找到前一项arr[i],以及索引i,此时可以得到由i,j确立的fib数列
        //使用dp[j][k]存储由[j,k]唯一确定的fib数列的长度,遍历数组,
        //[0,2]找不到对应的i满足arr[k]-arr[j] = arr[i],同理[0,3到8],[2,3到8]
        //[3,5]找到arr[i]=2,但[i,j]对应的fib数列不存在,故默认长度为arr[i]和arr[j]的长度为2,加上arr[k],长度为3
        //[5,8]找到arr[i]=3,且[i,j]对应长度为3,加上8,长度为4
        //使用哈希表存储[i,j]对应的fib长度,将i,j序列化为i*N+j,保证唯一性
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> fibLength = new HashMap<>();
        int N = arr.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            indexMap.put(arr[i], i);
        }
        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int i = indexMap.getOrDefault(arr[k] - arr[j], -1);
                if (i >= j) {
                    //由于k递增,故i递增,所以一旦i大于等于j,可以跳出此次循环,进入下一个j
                    break;
                }
                if (i != -1) {
                    int length = fibLength.getOrDefault(i * N + j, 2) + 1;
                    fibLength.put(j * N + k, length);
                    ans = Math.max(ans, length);
                }
            }
        }
        return ans;
    }
}

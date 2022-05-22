package LeetCode.SwardOffer.I;

import java.util.Arrays;

public class Offer45 {
    public String minNumber(int[] nums) {
        //字典序排序,定义.为拼接
        //若a.b<b.a ,则a<b
        Integer[] numsI = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsI[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(numsI, (o1, o2) -> {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(o1).append(o2);
            sb2.append(o2).append(o1);
            return sb1.toString().compareTo(sb2.toString());
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(numsI[i]);
        }
        return sb.toString();
    }
}

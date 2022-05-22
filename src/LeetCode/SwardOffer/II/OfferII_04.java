package LeetCode.SwardOffer.II;

public class OfferII_04 {
    public int singleNumber(int[] nums) {
        //累加32位每一位出现的次数
        //最后%3不等于0的,即为目标元素
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += (nums[i] >> j) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = "Sb";
        System.out.println(new OfferII_04().singleNumber(new int[]{-2, -2, 3, -2}));
    }
}

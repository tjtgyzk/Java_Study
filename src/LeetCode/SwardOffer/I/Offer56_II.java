package LeetCode.SwardOffer.I;

public class Offer56_II {
    //    将每个int数字展开成为32位二进制
    //    建立一个32位数组(空间复杂度O(1))，将这些数全部以二进制形式加在数组的对应位置上
    //    如果在某一位上只存在出现了M次的数，则该位置上出现的总次数%M一定为0，不为0的即为出现K次的数据的二进制形式中不为0的位
    //    将这些不为0的位找到，组合，即为出现了K次的数
    public int singleNumber(int[] nums) {
        int[] keys = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                keys[j] += (nums[i] >> j) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] % 3 != 0) {
                ans += Math.pow(2, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Offer56_II().singleNumber(new int[]{3, 4, 3, 3});
    }
}

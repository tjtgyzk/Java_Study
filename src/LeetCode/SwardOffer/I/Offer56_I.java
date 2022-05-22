package LeetCode.SwardOffer.I;

public class Offer56_I {
    public int[] singleNumbers(int[] nums) {
        //整个数组异或一遍,得到的eor1即为出现一次的两个数的异或a^b
        //找到eor1最右侧的1,rightOne = eor1 & (-eor1)
        //异或整个数组与rightOne位置为1的数,得到的eor2即为a和b中的一个
        //eor2^eor1,即可得到另一个数
        int eor1 = 0, eor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            eor1 ^= nums[i];
        }
        int rightOne = eor1 & (-eor1);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) != 0) {
                eor2 ^= nums[i];
            }
        }
        eor1 ^= eor2;
        return new int[]{eor1, eor2};
    }
}

package LeetCode.Arrays.MoveChange;

public class L665 {
    public static boolean checkPossibility(int[] nums) {
        //测试思路:遍历数组,如果nums[i+1]<nums[i],则为一个递减组
        //如果遇到两个递减组,则不可能通过改变一个数成为非递减数列
        //反例:[3,4,2,3],只有一个递减组,但依旧无法改变一个数字成为非递减数列
//        int lowTimes = 1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                if (lowTimes == 0) {
//                    return false;
//                }
//                lowTimes--;
//            }
//        }
//        return true;
        //进化:在找到第一个递减组之后,将其修改为合理数字(即nums[i]≤nums[i+1]且≥nums[i-1],这里做两次尝试,可以将nums[i]修改为nums[i+1],也可以将nums[i+1]修改成nums[i]),
        //再遍历一遍数组,检查是否存在递减组,如果存在即为false
        //只遍历一遍?可行!我们发现,[3,4,2,3]不可以是因为:如果将4改成2,则这个位置的数小于前一个的3,不可行;若将2改成4,则会大于后面的3,不可行
        //也就是[3,4],[1,2]中,nums[i-1]必须小于等于nums[i+1],或者nums[i]必须小于等于nums[i+2]
        //如果这个逻辑绕,可以判断如果nums[i-1]>nums[i+1],则将nums[i+1] = nums[i],之后如果还存在逆序对,则为false
        int lowTimes = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (lowTimes == 0 || ((i > 0 && nums[i - 1] > nums[i + 1]) && (i != nums.length - 2) && nums[i] > nums[i + 2])) {
                    return false;
                } else {
                    lowTimes--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 8};
        System.out.println(checkPossibility(nums));
    }
}

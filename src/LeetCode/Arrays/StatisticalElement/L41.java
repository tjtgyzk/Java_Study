package LeetCode.Arrays.StatisticalElement;

public class L41 {
    public static int firstMissingPositive(int[] nums) {
        //数组长度为N,则可以用于检测[1,N]的正整数是否出现,如果都出现了,则返回N+1即可
        //类似于上一题,需要找到一种合适的映射思路,在不改变结果的情况下使用数组下标
        //思路一: 负数不会影响结果,首先将所有负数处理成N+1,整个数组均为正数
        //遍历数组,假设nums[i] = k, 则index = k-1, 将nums[index]位置的数变为负数
        //防止提前变为负数,这里求index用nums[i]的绝对值
        //如果index > N-1,则证明这个数本身就大于N,直接舍弃,不做任何操作,因为最终结果不会大于N+1
        //如果一个数出现两次,就会变回正数,所以在变负数的时候可以加一个判断,只有正数才变,或者用取绝对值再变负数
        //最后遍历数组,假设index位置为负数,则证明数(index+1)出现过,返回第一个为正数的下标+1
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= 0) {
//                nums[i] = n + 1;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (Math.abs(nums[i]) <= n) {
//                int index = Math.abs(nums[i]) - 1;
//                nums[index] = -Math.abs(nums[index]);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return n + 1;
        //思路二:遍历数组,每次将nums[i] = k 的值交换到nums[k-1]位置
        //如果是负数或者大于N+1的数,则原地不动
        //防止一个数出现多次,导致在被换时对应位置已经是正确的数导致死循环,加一个判断nums[k-1]!=k
        //最后遍历数组,找到第一个i位置的值不是i+1的,如果都是,返回n+1
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(firstMissingPositive(nums));
    }
}

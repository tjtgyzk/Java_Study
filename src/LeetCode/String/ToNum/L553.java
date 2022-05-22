package LeetCode.String.ToNum;

public class L553 {
    //数组中的数都大于1
    //被除数尽可能大,除数尽可能小,能得到最大的结果
    //用第一个数除以剩下所有数直接相除
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0] + "/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i] + "/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.append(")").toString();
    }
}

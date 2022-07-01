package LeetCode.SwardOffer.II;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferII_07 {
    public List<List<Integer>> threeSum(int[] nums) {
        //极端情况,数组为[0,0,0,0,0,0,0],则全部都是重复答案
        //如何排除重复答案:将数组排序,则 (a, b, c) 满足 a <= b <= c,即答案数组为递增数组,排除了(b,a,c)(b,c,a)等答案
        //对于每一重循环而言,如果下一个数字与当前数字相等,则向后跳,直到下一个数字与当前数字不相等为止
        //优化为O(N^2):观察a + b + c:在第二层循环中,随着b不断增加,一定会不断减小,也就是下一个c一定出现在当前c的左侧,指向c的指针只会左移
        //所以可以从小到大枚举 b，同时从大到小枚举 c，即第二重循环和第三重循环实际上是并列的关系。
        //这个方法就是我们常说的「双指针」，当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2)
        //减少至 O(N)。为什么是 O(N) 呢？这是因为在枚举的过程每一步中，「左指针」会向右移动一个位置（也就是题目中的 b），而「右指针」会向左移动若干个位置
        //这个与数组的元素有关，但我们知道它一共会移动的位置数为 O(N)，均摊下来，每次也向左移动一个位置，因此时间复杂度为 O(N)。
        //注意:需要保持b < c,不然就破坏了答案数组的递增性
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int pointC = nums.length - 1;
                int target = -nums[i];
                for (int j = i + 1; j < nums.length; j++) {

                    
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        while (j < pointC && nums[j] + nums[pointC] > target) {
                            pointC--;
                        }
                        if (j == pointC) {
                            break;
                        }
                        if (nums[j] + nums[pointC] == target) {
                            ArrayList<Integer> subAns = new ArrayList<>();
                            subAns.add(nums[i]);
                            subAns.add(nums[j]);
                            subAns.add(nums[pointC]);
                            ans.add(subAns);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new OfferII_07().threeSum(nums);
    }
}

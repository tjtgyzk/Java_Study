package myStudy.Zuo.ShuaTi.Day01;

public class WaysToTarget {

    public static int function(int[] arr, int target) {
        return process(arr, 0, target);
    }

    /**
     * @param arr
     * @param index 当前要选择的数字
     * @param rest  剩余要凑的数
     * @return
     */
    public static int process(int[] arr, int index, int rest) {
        //没数可以选了
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int add;
        int minus;
        add = process(arr, index + 1, rest - arr[index]);
        minus = process(arr, index + 1, rest + arr[index]);
        return add + minus;
    }

    //优化点：
//- 可以处理成非负数组，因为不影响结果
//- 如果target>所有数的和，0种
//- 如果target与所有数之和的奇偶性不同，0种
//- 取正集合P，取负集合N，可知P-N = tar；故2P = tar + sum，故p = （tar + sum） / 2。即转化为用arr有多少种方法可以凑出(tar + sum)/2，可以节省dp表的规模，进而减少空间复杂度和时间复杂度
//- 空间压缩（只依赖下一行右侧的值）
    public static int function2(int[] nums, int target) {
        //target无所谓正负，统一处理为正
        target = Math.abs(target);
        int N = nums.length;
        //处理成为非负数组+取得数组和
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        //如果所有数的和小于target，则没有
        //如果奇偶性不同，也没有
        if (sum < target || (target % 2) != (sum % 2)) {
            return 0;
        }
        //根据转化，凑累加和为（tar + sum） / 2的可能性
        int s = target + ((sum - target) >> 1);
        //index范围：0-N
        //rest范围：0-s
        //依赖下左，故可以优化成为一维dp表,从右向左填，否则会污染数据
        //这里rest必须包含0的情况，否则当nums里出现0的时候会少考虑情况（0要与不要均可，算两种情况）
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = s; rest >= 0; rest--) {
                if (rest - nums[index] >= 0) {
                    //如果减完大于等于0，说明这个数可以要，则加上要与不要的可能性
                    //如果减完小于0，则说明这个数一定不能要，保持原有值即可（相当于二维dp取下一行同一列的值）
                    dp[rest] += dp[rest - nums[index]];
                }
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        System.out.println(function2(nums, 1));
    }

    public static int getMin(int[] x, int[] hp, int range) {
        int n = x.length;
        // cover[i] : 如果i位置是技能的最左侧，技能往右的range范围内，最右影响到哪
        int[] cover = new int[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && x[r] - x[i] <= range) {
                r++;
            }
            cover[i] = r;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hp[i] > 0) {
                int minus = hp[i];
                for (int index = i; index < cover[i]; index++) {
                    hp[index] -= minus;
                }
                ans += minus;
            }
        }
        return ans;
    }

}


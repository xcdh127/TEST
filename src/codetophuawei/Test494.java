package codetophuawei;

/*给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
示例 1：
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：
输入：nums = [1], target = 1
输出：1
提示：
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/
public class Test494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(sum) < Math.abs(target)) {
            return 0;
        }
        int goal = sum + target;
        if (goal % 2 == 1) {
            return 0;
        }
        goal = goal / 2;
        //塞满容量为goal的背包的方法数
        int[] dp = new int[goal + 1];
        //塞满背包容量为0的方法数量为1
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            //0 1背包问题倒序遍历物品，使得物品只放进背包一次
            //从背包容量最大，遍历到当前物品的大小值
            for (int j = goal; j >= nums[i]; j--) {
                //方法数量的通用公式
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[goal];
    }
}


class Solution104 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //suma+sumb=sum
        //suma-sumb=target
        int goal = (sum + target);
        if (goal % 2 == 1) {
            return 0;
        }
        goal = goal / 2;
        if (Math.abs(sum) < Math.abs(target)) {
            return 0;
        }
        int[][] dp = new int[n + 1][goal + 1];
        //塞满容量为1的背包的方法数为1
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= goal; j++) {
                //不将i位置的物品放进背包
                dp[i][j] = dp[i - 1][j];
                //将i位置的物品添加进背包，累加可以塞满容量为j的背包的方法数
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        //返回n个物品塞满容量为goal的背包的方法数
        return dp[n][goal];
    }
}
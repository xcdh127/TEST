package Jianzhioffer02;

import sun.nio.cs.ext.MacHebrew;

/*输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
提示：
1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
*/
public class Test42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //长度为1的数组和的最大值处的数字为数组0位置的数字
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }
}

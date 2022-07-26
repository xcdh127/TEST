package codeTop;
/*输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。
提示：
1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
*/
public class TestOffer42 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        //记录连续数组前n位的最大值
        int[] dp=new int[n];
        //位置为0的和为nums[0]
        dp[0]=nums[0];
        //前i位置的最大连续和为 前i-1位置的最大连续和+nums[i] 与 nums[i]的较大者
        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        //记录连续数组最大和，初始化为最小的整数
        int max=Integer.MIN_VALUE;
        //遍历dp数组，找出连续数组最大和
        for (int num :dp) {
            max=Math.max(num,max);
        }
        //返回最大值
        return max;
    }
}

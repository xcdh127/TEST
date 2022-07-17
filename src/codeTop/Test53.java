package codeTop;
/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [5,4,-1,7,8]
输出：23
提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
*/
public class Test53 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for (int i = 1; i < n; i++) {
            //当前位置的最大子数组的和是当前数字本身和当前数字+之前子数组的和
            dp[i]=Math.max(nums[i], dp[i-1]+nums[i]);
        }
        int max=Integer.MIN_VALUE;
        //遍历dp数组，寻找最大子数组的和
        for (int num :dp) {
            max=Math.max(num,max);
        }
        return max;
    }
}

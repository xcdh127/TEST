package codeTop;

/*给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
测试用例的答案是一个32-位 整数。
子数组 是数组的连续子序列。
示例 1:
输入: nums = [2,3,-2,4]
输出: 6
解释:子数组 [2,3] 有最大乘积 6。
示例 2:
输入: nums = [-2,0,-1]
输出: 0
解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
提示:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
nums 的任何前缀或后缀的乘积都 保证是一个 32-位 整数
*/
public class Test152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //记录最大值数组
        int[] max = new int[n];
        //记录最小值数组
        int[] min = new int[n];
        //记录最大值的数组
        max[0]=nums[0];
        //记录最小值的数组
        min[0]=nums[0];
        for (int i = 1; i < n; i++) {
            //最大值数组，最大值从数组当前数字，当前数字*max[i-1]，当前数字*min[i-1]
            max[i] = Math.max(Math.max(nums[i], max[i-1] * nums[i]), min[i-1] * nums[i]);
            //最小值数组，最小值从数组当前数字，当前数字*max[i-1]，当前数字*min[i-1]
            min[i] = Math.min(Math.min(nums[i], max[i-1] * nums[i]), min[i-1] * nums[i]);
        }
        //记录最大值
        int maxNum=Integer.MIN_VALUE;
        //最大值
        for (int num :max) {
            maxNum=Math.max(num,maxNum);
        }
        //返回最大值
        return maxNum;
    }
}

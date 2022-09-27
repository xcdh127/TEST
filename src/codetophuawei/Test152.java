package codetophuawei;

/*给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
并返回该子数组所对应的乘积。
测试用例的答案是一个 32-位 整数。
子数组 是数组的连续子序列。
示例 1:
输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
提示:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
*/
public class Test152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        //确定最大乘积的初始值
        max[0] = nums[0];
        //确定最小乘积的初始值
        min[0] = nums[0];
        //从1位置遍历到数组末尾位置
        for (int i = 1; i < n; i++) {
            //记录连续最大乘积，当前数字，当前数字乘前i-1个数的最大乘积 ，当前数字乘前i-1个数字的最小乘积
            max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            //记录连续最小乘积，当前数字，当前数字乘前i-1个数的最大乘积 ，当前数字乘前i-1个数字的最小乘积
            min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
        }
        //记录连续最大乘积值
        int maxValue = Integer.MIN_VALUE;
        for (int num : max) {
            maxValue = Math.max(maxValue, num);
        }
        //返回
        return maxValue;
    }
}

package codeTop;

/*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
这意味着第一个房屋和最后一个房屋是紧挨着的。同时，
相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
示例 1：
输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：
输入：nums = [1,2,3]
输出：3
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/
public class Test213 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //将房屋分成（0，n-2）和（1，n-1）
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            //偷当前屋子与不同当前屋子的最大价值
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        int max1 = Integer.MIN_VALUE;
        for (int num : dp1) {
            max1 = Math.max(num, max1);
        }
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            //偷当前屋子与不同当前屋子的最大价值
            dp2[i - 1] = Math.max(dp2[i - 2], dp2[i - 3] + nums[i]);
        }

        int max2 = Integer.MIN_VALUE;
        for (int num : dp2) {
            max2 = Math.max(max2, num);
        }
        //返回两批房子，偷盗最大值
        return Math.max(max1, max2);

    }
}

class Solution32 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {

            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        int max1 = Integer.MIN_VALUE;
        for (int num : dp1) {
            max1 = Math.max(num, max1);
        }
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        //nums从下标3开始，dp从下标2开始
        for (int i = 3; i < n; i++) {
            dp2[i - 1] = Math.max(dp2[i - 2], dp2[i - 3] + nums[i]);
        }
        int max2 = Integer.MIN_VALUE;
        for (int num : dp2) {
            max2 = Math.max(num, max2);
        }
        return Math.max(max1, max2);
    }
}
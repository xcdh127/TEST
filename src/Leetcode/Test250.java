package Leetcode;
/*给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
子数组是数组中的一个连续数字序列。
已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），
numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
*/

/*输入：nums = [10,20,30,5,10,50]
输出：65
解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。*/
public class Test250 {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+nums[i];
            }
            else {
                dp[i]=nums[i];
            }
        }
        int max=0;
        for (int num :dp) {
            max=Math.max(num,max);
        }
        return max;
    }
}

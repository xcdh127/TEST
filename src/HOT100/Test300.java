package HOT100;
/*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
进阶：
你能将算法的时间复杂度降低到 O(n log(n)) 吗?
*/
public class Test300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            //记录前i位置的数组的最大长度
            int max=0;
            //在前i个位置中找到最长的连续子数组的长度
            for (int j = 0; j < i; j++) {
                //当j位置的数字小于i位置的数字时，返回数组中前j位置中最大的长度
                if (nums[j]<nums[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            //i位置的最大连续子数组的长度在之前最长的子数组的长度的基础上+1
            dp[i]=max+1;
        }
        //记录整个数组中最长子数组的最大长度
        int maxLen=0;
        //遍历dp数组，寻找出最大最大子数组的长度
        for (int num :dp) {
            maxLen=Math.max(num,maxLen);
        }
        //返回最大连续子数组的长度
        return maxLen;
    }
}
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int maxLen=0;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int num : dp){
            maxLen=Math.max(num,maxLen);
        }
        return maxLen;
    }
}*/

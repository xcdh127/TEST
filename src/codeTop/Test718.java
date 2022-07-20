package codeTop;
/*给两个整数数组nums1和nums2，返回 两个数组中 公共的 、长度最长的子数组的长度。
示例 1：
输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。
示例 2：
输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
输出：5
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
*/
public class Test718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        int maxLen=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当两个数组对应的数字相等时，此时两个数组的公共长度就+1
                if (nums1[i]==nums2[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                //遍历过程中，记录最长的子数组长度
                maxLen=Math.max(maxLen,dp[i+1][j+1]);
            }
        }
        //返回最长长度
        return maxLen;
    }
}

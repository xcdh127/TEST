package CodeDream;

/*给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
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
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当数组1i位置的数字与数组2j位置的数字相等时
                if (nums1[i] == nums2[j]) {
                    //在dp[i][j]的基础上长度+1
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                //在遍历过程中寻找最大重复数组的值
                maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
            }
        }
        return maxLen;
    }
}

class Solution21 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
            }
        }
        return maxLen;
    }
}
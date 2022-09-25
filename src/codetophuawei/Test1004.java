package codetophuawei;

/*给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
示例 1：
输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：
输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
提示：
1 <= nums.length <= 105
nums[i] 不是 0 就是 1
0 <= k <= nums.length
*/
public class Test1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        //左窗口的位置
        int lsum = 0;
        //右窗口的位置
        int rsum = 0;
        //窗口右边界
        for (int right = 0; right < n; right++) {
            //将数组中的值反转累加求和
            rsum += 1 - nums[right];
            //当左窗口的和小于右窗口的和-k时
            while (lsum < rsum - k) {
                //计算左边窗口的和
                lsum += 1 - nums[left];
                //继续将左窗口缩小
                left++;
            }
            //获取窗口的最大值
            res = Math.max(res, right - left + 1);
        }
        //返回结果
        return res;
    }
}


class Solution84 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

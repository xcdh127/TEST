package CodeDream;

/*给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 
[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：
输入：target = 4, nums = [1,4,4]
输出：1
示例 3：
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
提示：
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
*/
public class Test209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        //窗口左边界
        int i = 0;
        //求子数组的和
        int sum = 0;
        //记录最短的子数组长度
        int minLen = Integer.MAX_VALUE;
        //窗口右边界
        for (int j = 0; j < n; j++) {
            //累加窗口内的值
            sum += nums[j];
            //当子数组的和大于等于目标值时
            while (sum >= target) {
                //记录最小窗口长度
                minLen = Math.min(minLen, j - i + 1);
                //缩小窗口大小
                sum -= nums[i];
                i++;
            }
        }
        //返回窗口的最小值
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

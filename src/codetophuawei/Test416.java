package codetophuawei;

/*给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
public class Test416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        //记录数组的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //当和为奇数时，不能构成等和子集吗，返回false
        if (sum % 2 == 1) {
            return false;
        }
        //target和等于sum/2
        int target = sum / 2;
        //赛满容量为target的背包吗，获得的最大价值
        int[] dp = new int[target + 1];
        //容量为0的背包可以被塞满
        for (int i = 0; i < n; i++) {
            //0 1背包，内层遍历背包，倒序编列，放置次放入
            for (int j = target; j >= nums[i]; j--) {
                //将当前的数字添加到背包当中，与不将当前数字添加到背包当中的最大值
                //背包容量-当前物品的重量+价值就是当前物品的重量
                dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
            }
        }
        //当赛满target的背包获得的价值为target时，此时可以分割成等和的子集
        return dp[target] == target;
    }
}

package CodeDream;

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
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int goal = sum / 2;
        //n个物品能否塞满容量为goal的背包
        boolean[][] dp = new boolean[n + 1][goal + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }
        //遍历物品
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            //遍历容量
            for (int j = 1; j <= goal; j++) {
                //不将i位置的物品放进背包
                dp[i][j] = dp[i - 1][j];
                //将i位置的物品放进背包
                if (!dp[i][j] && j - num >= 0) {
                    dp[i][j] = dp[i - 1][j - num];
                }
            }
        }
        //返回n个物品能否塞满容量为goal的背包
        return dp[n][goal];
    }
}

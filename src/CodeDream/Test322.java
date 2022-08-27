package CodeDream;

import java.util.Arrays;

/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：
输入：coins = [2], amount = 3
输出：-1
示例 3：
输入：coins = [1], amount = 0
输出：0
提示：
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/
public class Test322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //凑足
        int[] dp = new int[amount + 1];
        //初始化为最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //外层遍历物品
        for (int i = 0; i < n; i++) {
            //内层遍历背包
            for (int j = coins[i]; j <= amount; j++) {
                //取塞满容量为j的背包的硬币个数两者取较小者
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        //如果结果大于amount，说明不存在硬币组合，返回-1，否则输出
        //塞满容量为amount的背包的数量
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

class Solution12 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
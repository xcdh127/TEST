package codetophuawei;

/*给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
假设每一种面额的硬币有无限个。 
题目数据保证结果符合 32 位带符号整数。
示例 1：
输入：amount = 5, coins = [1, 2, 5]
输出：4
解释：有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2：
输入：amount = 3, coins = [2]
输出：0
解释：只用面额 2 的硬币不能凑成总金额 3 。
示例 3：
输入：amount = 10, coins = [10]
输出：1
提示：
1 <= coins.length <= 300
1 <= coins[i] <= 5000
coins 中的所有值 互不相同
0 <= amount <= 5000
*/
public class Test518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        //塞满容量为0的背包共有1种方式
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                //当背包的容量大于当前物品时
                if (j >= coins[i]) {
                    //背包容量为j的背包被塞满的方法数为  被塞满背包容量为j方法数量+被塞满的背包容量为j-coin[i]的方法数
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        //返回塞满容量为amount的背包的方法数量
        return dp[amount];
    }
}


class Solution98 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //凑足容量为amount的背包的方法数
        int[] dp = new int[amount + 1];
        //塞满容量为0的背包的方法数是1
        dp[0] = 1;
        //无穷背包问题
        //外层循环遍历物品
        for (int i = 0; i < n; i++) {
            //内层循环遍历背包
            for (int j = coins[i]; j <= amount; j++) {
                //将i位置的物品放进背包能够塞满容量为j的背包时
                //将塞满容量为j的背包的方法数量累加
                dp[j] += dp[j - coins[i]];
            }
        }
        //返回塞满容量为amount的背包的数量
        return dp[amount];
    }
}
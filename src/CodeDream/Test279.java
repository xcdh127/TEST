package CodeDream;

/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
示例 1：
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：
输入：n = 13
输出：2
解释：13 = 4 + 9
提示：
1 <= n <= 104
*/
public class Test279 {
    public int numSquares(int n) {
        //和为n的最少完全平方数的个数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //初始化最少完全平方数的个数为最大整数值
            dp[i] = Integer.MAX_VALUE;
            //当容量为i的背包能够容纳 j*j这个平方数时，最少平方数的个数+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        //返回和为n的最少平方数的个数
        return dp[n];
    }
}

class Solution15 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //和为1的最小平方数是1
        dp[1] = 1;
        //和为n的最小平方数
        for (int i = 2; i <= n; i++) {
            //初始化为最大值
            dp[i] = Integer.MAX_VALUE;
            //当i的值大于等于j*j时，此时dp[i]的值取为dp[i-j*j]+1和dp[i]的较小者
            for (int j = 1; i - j * j >= 0; j++) {
                //在i-j*j的基础上，加上j*j和为i，此时取较小者
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        //返回拼成和为n的数字的最小个数
        return dp[n];
    }
}
package CodeDream;

/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。
示例 1:
输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:
输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
提示:
2 <= n <= 58
*/
public class Test343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //记录最大乘积
            int chengji = 0;
            for (int j = 1; j < i; j++) {
                //当前乘积  与 对这个数字多次拆分的乘积取最大值 与 对这个数字一次拆分的乘积
                chengji = Math.max(chengji, Math.max(dp[i - j] * j, (i - j) * j));
            }
            //将最大乘积赋值给对数字i进行拆分的最大乘积
            dp[i] = chengji;
        }
        //返回对数字n进行拆分的最大乘积
        return dp[n];
    }
}

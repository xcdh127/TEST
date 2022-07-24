package codeTop;
/*给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
返回 你能获得的 最大 利润。
示例 1：
输入：prices = [7,1,5,3,6,4]
输出：7
解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     总利润为 4 + 3 = 7 。
示例 2：
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    总利润为 4 。
示例3：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
提示：
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
*/
public class Test122 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        //第i天持有股票
        dp[0][1]=-prices[0];
        for (int i = 1; i < n; i++) {
            //不持有股票
            //第i天之前就不持有股票，第i天卖出股票，i-1持有股票+第i天卖出股票的价值
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持有股票
            //第i天之前就持有股票，第i天买了股票，i-1不持有股票-第i天买股票的价值
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        //记录最大价值
        int max=0;
        for (int i = 0; i < n; i++) {
            //在卖出股票的数组中，寻找最大值
            max=Math.max(max,dp[i][0]);
        }
        //返回最大值
        return max;
    }
}
/*class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        //表示持有股票最大利润
        dp[0][0]=-prices[0];
        //表示不持有股票最大利润
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(dp[i][1],max);
        }
        return max;
    }
}*/
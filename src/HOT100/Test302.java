package HOT100;
/*给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: prices = [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
示例 2:
输入: prices = [1]
输出: 0
提示：
1 <= prices.length <= 5000
0 <= prices[i] <= 1000
*/
public class Test302 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][3];
        //第一天持有股票的利润
        dp[0][0]=-prices[0];

        for (int i = 1; i <n ; i++) {
            //1.持有股票,前一天持有股票，今天持有股票，取其大
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //2.不持有股票，且不在冻潮期，前一天就不持有股票且不在冻超期，前一天不持有股票但在冻超期，取其大
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            //3.持有股票且在冻潮期,当天卖股票
            dp[i][2]=dp[i-1][0]+prices[i];
        }
        int maxValue=0;
        for (int num :dp[n-1]) {
            maxValue=Math.max(num,maxValue);
        }
        return maxValue;
    }
}
/*class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][3];
        //初始化
        dp[0][0]=-prices[0];
        for(int i=1;i<n;i++){
            //持有股票
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //不持有股票且不处于冻潮期
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            //不持有股票且处于冻潮期
            dp[i][2]=dp[i-1][0]+prices[i];
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=2;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}*/

package codeTop;
/*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12
*/
public class Test64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当i==0并且j==0时，此时dp值为（0，0）位置的值
                if (i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                //当i==0并且j!=0时，处理第一行的值，此时路径和只能拿到左边的值
                else if (i == 0 && j != 0) {
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }
                //处理第一列的值，此时路径和只能拿到上边的值
                else if (i != 0 && j == 0) {
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                //处理其他位置的值，此时既能拿到左边位置的值，也能拿到上边位置的值
                else if (i != 0 && j != 0) {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        //返回结果
        return dp[m-1][n-1];
    }
}

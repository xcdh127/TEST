package codeTop;
/*在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
示例 2：
输入：matrix = [["0","1"],["1","0"]]
输出：1
示例 3：
输入：matrix = [["0"]]
输出：0
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] 为 '0' 或 '1'
*/
public class Test221 {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        //遍历数组的第一列，当遇到字符1时，此时正方形的边长为1
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]=='1'){
                dp[i][0]=1;
            }
        }
        //遍历数组的第一行，当遇到字符1时，此时正方形的边长为1
        for (int j = 0; j < n; j++) {
            if (matrix[0][j]=='1'){
                dp[0][j]=1;
            }
        }
        //遍历数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //当前位置的字符是'1'时，获取（i，j）位置正方形的长度，是这个位置的左上，左下，右上方的字符最长边长+1
                if (matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        //最长长度
        int maxLen=0;
        //遍历dp数组，获取最长的边长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        //返回最大面积
        return maxLen*maxLen;
    }
}

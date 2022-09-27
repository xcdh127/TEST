package codetophuawei;

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
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //遍历第一列，有1就标记1
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1')
                dp[i][0] = 1;
        }
        //遍历第一行，有1就标记1
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }
        //遍历其他位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //当有1出现时，将按照周围最小数字来决定这个位置+1
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        //遍历寻找最大长度
        int maxlen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxlen = Math.max(maxlen, dp[i][j]);
            }
        }
        //返回面积
        return maxlen * maxlen;
    }
}

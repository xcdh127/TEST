package HOT100;
/*给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符
示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
提示：
0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成
*/
public class Test29 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for (int j = 0; j <=n ; j++) {
            dp[0][j]=j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当两个字符串末尾字符相同时，（1.在字符串a后面补字符,2.在字符串b后面补字符，3.不需要替换字符）
                if (word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j]-1)+1;
                }
                //当两个字符串末尾字符不相同时，（1.在字符串a后面补字符,2.在字符串b后面补字符，3.需要替换字符）
                else {
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                }
            }
        }
        return dp[m][n];
    }
}

/*class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        //空字符串w1与非空字符串w2
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        //空字符串w2与非空字符串w1
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j]-1)+1;
                }
                else{
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                }
            }
        }
        return dp[m][n];
    }
}*/















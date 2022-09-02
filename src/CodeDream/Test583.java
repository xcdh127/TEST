package CodeDream;

/*给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
每步 可以删除任意一个字符串中的一个字符。
示例 1：
输入: word1 = "sea", word2 = "eat"
输出: 2
解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
示例  2:
输入：word1 = "leetcode", word2 = "etco"
输出：4
提示：
1 <= word1.length, word2.length <= 500
word1 和 word2 只包含小写英文字母
*/
public class Test583 {
    public int minDistance(String word1, String word2) {
        //本质：求两个序列的最长公共子序列
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当单词1的i位置的字符与单词2的j位置的字符相等时，两个单词的
                //最长公共子序列的长度+1
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                //当两个字符串对应的字符不相等时，删字符串1或者删字符串2取较大者
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        //用两个字符串的长度-最长递增子序列的长度，就是计算两个字符串除去最长公共子序列长度之外的长度之和
        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}

class Solution23 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}
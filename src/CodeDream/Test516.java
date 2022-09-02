package CodeDream;

/*给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
示例 1：
输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
示例 2：
输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为 "bb" 。
提示：
1 <= s.length <= 1000
s 仅由小写英文字母组成
*/
public class Test516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //只有一个字符的回文子序列长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //记录最长回文子序列的长度
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //当i指针和j指针指向的字符相等时，长度在dp[i+1][j-1]的基础上+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                //求dp[i][j-1]和dp[i+1][j]较大值
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                //记录最长的回文序列的长度
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        //返回最大长度
        return maxLen;
    }
}

class Solution27 {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {

            dp[i][i] = 1;

        }
        int maxLen = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //如果s[i]==s[j]时，最长回文字串长度在原回文子串长度基础上+2
                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);

                }
                maxLen = Math.max(dp[i][j], maxLen);

            }

        }
        return maxLen;
    }
}
package CodeDream;

/*给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
题目数据保证答案符合 32 位带符号整数范围。
示例 1：
输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
rabbbit
rabbbit
rabbbit
示例 2：
输入：s = "babgbag", t = "bag"
输出：5
解释：
如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
babgbag
babgbag
babgbag
babgbag
babgbag
提示：
0 <= s.length, t.length <= 1000
s 和 t 由英文字母组成
*/
public class Test115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        //字符串s中包含空字符串的个数是1个
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当s字符串i位置的字符等于t字符串j位置的字符时，此时有两种选择
                //用s字符串i位置的字符去匹配
                //不用s字符串i位置的字符去匹配
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
                }
                //当s字符串i位置的字符不等于t字符串j位置的字符时，只有一种选择
                //不使用i位置的字符去匹配
                else if (s.charAt(i) != t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[m][n];
    }
}

class Solution22 {
    public int numDistinct(String s, String t) {

        if (s.length() < t.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else if (s.charAt(i) != t.charAt(j)) {

                    dp[i + 1][j + 1] = dp[i][j + 1];
                }

            }
        }

        return dp[m][n];
    }
}
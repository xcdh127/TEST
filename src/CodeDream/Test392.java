package CodeDream;

/*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
进阶：
如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
致谢：
特别感谢 @pbrother 添加此问题并且创建所有测试用例。
示例 1：
输入：s = "abc", t = "ahbgdc"
输出：true
示例 2：
输入：s = "axc", t = "ahbgdc"
输出：false
提示：
0 <= s.length <= 100
0 <= t.length <= 10^4
两个字符串都只由小写字符组成。
*/
public class Test392 {
    public boolean isSubsequence(String s, String t) {
        //本质：求两个序列的最长公共子序列
        int m = s.length();
        int n = t.length();
        //记录两个序列的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果字符串s的i位置的字符与字符串t的j位置上的字符相等，公共长度在原长度的基础上+1
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                //否则取两个各加一个长度的最大值
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        //返回最大子序列的长度是否等于字符串s的长度
        return dp[m][n] == s.length();
    }
}

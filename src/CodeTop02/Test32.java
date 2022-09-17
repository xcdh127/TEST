package CodeTop02;

public class Test32 {
    public int longestValidParentheses(String s) {
        return 0;

    }
}

class Solution79 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            //当前位置上的字符是'）'时
            if (s.charAt(i) == ')') {
                //形如xxxxxx()
                //前一个位置上的字符是'（'时
                if (s.charAt(i - 1) == '(') {
                    //如果i大于等于2
                    if (i >= 2) {
                        //在原有的长度基础上（这个新括号前面），长度+2
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        //如果i小于2，此时有效长度就是2
                        dp[i] = 2;
                    }
                }
                //形如((xxx))
                //
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //前一个有效括号长度+之前有效括号长度+当前这个新括号
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                //统计最大有效括号长度
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        return maxLen;
    }
}
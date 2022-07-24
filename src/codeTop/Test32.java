package codeTop;
/*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
示例 3：
输入：s = ""
输出：0
提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
*/
public class Test32 {
    public int longestValidParentheses(String s) {
        int n=s.length();
        if (n==0 || s==null){
            return 0;
        }
        int[] dp=new int[n];
        dp[0]=0;
        int maxLen=0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    if (i>=2){
                        dp[i]=dp[i-2]+2;
                    }
                }
                else {
                    dp[i]=2;
                }
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i]=dp[i-1]+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
            }
            maxLen=Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
/*      dp[0]=0;
        int maxLen=0;
        for (int i = 1; i < n; i++) {
            //当前位置上的字符是'）'时
            if (s.charAt(i)==')'){
                //形如xxxxxx()
                //前一个位置上的字符是'（'时
                if (s.charAt(i-1)=='('){
                    //如果i大于等于2
                    if (i>=2){
                        //在原有的长度基础上（这个新括号前面），长度+2
                        dp[i]=dp[i-2]+2;
                    }
                    else {
                        //如果i小于2，此时有效长度就是2
                        dp[i]=2;
                    }
                }
                //形如((xxx))
                //
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //前一个有效括号长度+之前有效括号长度+当前这个新括号
                    dp[i]=dp[i-1]+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
                }
                //统计最大有效括号长度
                maxLen=Math.max(dp[i],maxLen);
            }
        }
        return maxLen;
        */
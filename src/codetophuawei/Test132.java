package codetophuawei;

/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
返回符合要求的 最少分割次数 。
示例 1：
输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
示例 2：
输入：s = "a"
输出：0
示例 3：
输入：s = "ab"
输出：1
提示：
1 <= s.length <= 2000
s 仅由小写英文字母组成
*/
public class Test132 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        //一个字符本身就是回文字符串，不需要分割
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            //如果从字符串开始到i结束，都是回文字符串，那么此时不需要分割
            if (isHuiWen(s, 0, i)) {
                dp[i] = 0;
            }
            //当0到i位置的字符串不是回文字符串时
            else {
                //从0开始到i位置的字符串，最多分割i次
                dp[i] = i;
                //当j小于等于i时
                for (int j = 1; j <= i; j++) {
                    if (isHuiWen(s, j, i)) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        //返回将字符串截成全回文字串的最少次数
        return dp[n - 1];
    }

    //判断字符串是否是回文字符串
    public boolean isHuiWen(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

class Solution108 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (isHuiWen(s, 0, i)) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isHuiWen(s, j, i)) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }

            }
        }
        return dp[n - 1];
    }

    public boolean isHuiWen(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
package codetophuawei;

/*给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成
*/
public class Test5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            int len1 = getLen(s, i, i);
            int len2 = getLen(s, i, i + 1);
            //取出形成回文字符串的最大长度
            int len = Math.max(len1, len2);
            //起始位置
            maxStart = i - (len - 1) / 2;
            //结束位置
            maxEnd = i + len / 2;
            //更新最大长度，并截取字符串
            if (maxLen < maxEnd - maxStart + 1) {
                maxLen = maxEnd - maxStart + 1;
                res = s.substring(maxStart, maxEnd + 1);
            }
        }
        return res;
    }

    public int getLen(String s, int start, int end) {
        int n = s.length();
        //从中间向两端拓展
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        //返回回文字符串的长度
        return end - start - 1;
    }
}

class Solution81 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            int len1 = build(s, i, i);
            int len2 = build(s, i, i + 1);
            int len = Math.max(len1, len2);
            start = i - (len - 1) / 2;
            end = i + len / 2;
            if (end - start + 1 > maxLen) {
                res = s.substring(start, end + 1);
                maxLen = end - start + 1;
            }
        }
        return res;
    }

    public int build(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}

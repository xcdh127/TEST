package CodeTop02;

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
        int start = 0;
        int end = 0;
        int maxLen = 0;
        //结果
        String res = "";
        for (int i = 0; i < n; i++) {
            //长度1
            int len1 = build(s, i, i);
            //长度2
            int len2 = build(s, i, i + 1);
            //最大长度
            int len = Math.max(len1, len2);
            //回文开始位置
            start = i - (len - 1) / 2;
            //回文结束位置
            end = i + len / 2;
            if (end - start + 1 > maxLen) {
                //截取子字符串
                res = s.substring(start, end + 1);
                //求字符串的最大长度
                maxLen = end - start + 1;
            }
        }
        //返回结果字符串
        return res;
    }

    public int build(String s, int start, int end) {
        //字符串长度
        int n = s.length();
        //start大于等于0,并且end小于n，并且开始和结束位置字符相同
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            //开始位置--
            start--;
            //结束位置++
            end++;
        }
        //end-start-1
        return end - start - 1;
    }
}

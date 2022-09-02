package CodeDream;

/*给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
回文字符串 是正着读和倒过来读一样的字符串。
子字符串 是字符串中的由连续字符组成的一个序列。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例 1：
输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：
输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
提示：
1 <= s.length <= 1000
s 由小写英文字母组成
*/
public class Test647 {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        //累加每一个位置开始，形成回文的个数
        for (int i = 0; i < n; i++) {
            count += getCount(s, i, i);
            count += getCount(s, i, i + 1);
        }
        return count;
    }

    public int getCount(String s, int start, int end) {
        int count = 0;
        int n = s.length();
        //从中心扩散，当指针指向的两个字符相等时，累加回文字符的个数
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        //返回回文字符串的个数
        return count;
    }
}

class Solution26 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countHuiWen(s, i, i);
            count += countHuiWen(s, i, i + 1);
        }
        return count;
    }

    public int countHuiWen(String s, int start, int end) {
        int count = 0;
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }
}
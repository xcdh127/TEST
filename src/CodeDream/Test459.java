package CodeDream;

/*给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
示例 1:
输入: s = "abab"
输出: true
解释: 可由子串 "ab" 重复两次构成。
示例 2:
输入: s = "aba"
输出: false
示例 3:
输入: s = "abcabcabcabc"
输出: true
解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
提示：
1 <= s.length <= 104
s 由小写英文字母组成
*/
public class Test459 {
    public boolean repeatedSubstringPattern(String s) {
        //将两个s字符串拼起来
        StringBuilder sb = new StringBuilder(s + s);
        //删除头(掐头)
        sb.deleteCharAt(0);
        //删除尾(去尾)
        sb.deleteCharAt(sb.length() - 1);
        //如果新字符串包含s，返回true
        if (sb.toString().contains(s)) {
            return true;
        }
        //不包含重复字符串，返回false
        return false;
    }
}

package codeTop;

/*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2:
输入: "race a car"
输出: false
解释："raceacar" 不是回文串
提示：
1 <= s.length <= 2 * 105
字符串 s 由 ASCII 字符组成
*/
public class Test125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        //将字符串改成小写
        s = s.toLowerCase();
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        //遍历字符串
        for (int i = 0; i < n; i++) {
            //当前字符是字符或者是数字时，将当前字符添加到sb中
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        //将两个指针指向字符串的首尾
        int i = 0;
        int j = sb.length() - 1;
        //当i与j没有相遇时
        while (i < j) {
            //当i与j两个指针指向的字符不相同时，返回false
            if (i < j && sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            //指向向里收缩一位
            i++;
            j--;
        }
        //所有首尾字符都是一致的，返回true
        return true;
    }
}

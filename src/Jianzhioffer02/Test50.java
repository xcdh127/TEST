package Jianzhioffer02;

import java.util.HashMap;
import java.util.Map;

/*在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例 1:
输入：s = "abaccdeff"
输出：'b'
示例 2:
输入：s = ""
输出：' '
限制：
0 <= s 的长度 <= 50000
*/
public class Test50 {
    public char firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        //获取每一个字符出现的次数
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        //返回第一个出现次数为1次的字符
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

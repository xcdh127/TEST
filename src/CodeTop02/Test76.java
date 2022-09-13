package CodeTop02;

import java.util.HashMap;
import java.util.Map;

/*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
示例 2：
输入：s = "a", t = "a"
输出："a"
示例 3:
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。
提示：
1 <= s.length, t.length <= 105
s 和 t 由英文字母组成
进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
*/
public class Test76 {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenT > lenS) {
            return "";
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < lenT; i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        //双指针
        int i = 0;
        //记录字母数量
        int count = 0;
        //记录结果
        String res = "";
        for (int j = 0; j < lenS; j++) {
            mapS.put(s.charAt(j), mapS.getOrDefault(s.charAt(j), 0) + 1);
            //如果字符串S中的字符是字符串T中的字符并且字符串S中的字符小于等于字符串T中的字符
            if (mapT.containsKey(s.charAt(j)) && mapS.get(s.charAt(j)) <= mapT.get(s.charAt(j))) {
                count++;
            }
            //开始缩小窗口，左窗口小于右窗口
            while (i < j && (!mapT.containsKey(s.charAt(i)) || mapS.get(s.charAt(i)) > mapT.get(s.charAt(i)))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
                i++;
            }
            //统计长度,当字符串S包含了字符串T中的所有字符之后，并且此时窗口的大小小于最小值时
            if (count == lenT && j - i + 1 < min) {
                min = j - i + 1;
                res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}

class Solution70 {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int min = Integer.MAX_VALUE;
        if (lenS < lenT) {
            return "";
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        //记录字符串t，字符以及出现的次数
        for (int i = 0; i < lenT; i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        int count = 0;
        String res = "";
        for (int j = 0; j < lenS; j++) {
            mapS.put(s.charAt(j), mapS.getOrDefault(s.charAt(j), 0) + 1);
            if (mapT.containsKey(s.charAt(j)) && mapS.get(s.charAt(j)) <= mapT.get(s.charAt(j))) {
                count++;
            }
            //缩小窗口,当i位置的字符在t字符串不存在，或者字符串s中的当前字符大于等于字符串t中的当前字符时，缩小窗口
            //将字符串s的i位置的字符数量-1
            while (i < j && (!mapT.containsKey(s.charAt(i)) || mapS.get(s.charAt(i)) > mapT.get(s.charAt(i)))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
                //继续缩小窗口
                i++;
            }
            if (count == lenT && j - i + 1 < min) {
                min = j - i + 1;
                res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}
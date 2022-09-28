package codetophuawei;

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
        Map<Character, Integer> mapT = new HashMap<>();
        //记录字符串t中，出现的字符以及个数
        for (int i = 0; i < lenT; i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        //字符串S，覆盖字符串t的字符个数
        int count = 0;
        String res = "";
        //滑动窗口左边界
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> mapS = new HashMap<>();
        //滑动窗口右
        for (int j = 0; j < lenS; j++) {
            mapS.put(s.charAt(j), mapS.getOrDefault(s.charAt(j), 0) + 1);
            //当字符串t包含这个字符，并且s中当前字符的个数小于t中当前字符的个数时
            if (mapT.containsKey(s.charAt(j)) && mapS.get(s.charAt(j)) <= mapT.get(s.charAt(j))) {
                count++;
            }
            //开始缩小窗口
            //当字符串t中，不包含字符串s中的字符时，或者s中的字符大于t中的字符数量时，缩小窗口
            while (i < j && (!mapT.containsKey(s.charAt(i)) || mapS.get(s.charAt(i)) > mapT.get(s.charAt(i)))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
                i++;
            }
            //包含了字符串T的所有字符，记录最小长度字符串
            if (count == lenT && minLen > j - i + 1) {
                minLen = j - i + 1;
                res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}


class Solution145 {
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

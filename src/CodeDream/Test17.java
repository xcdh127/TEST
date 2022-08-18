package CodeDream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：
输入：digits = ""
输出：[]
示例 3：
输入：digits = "2"
输出：["a","b","c"]
提示：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
*/
public class Test17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] ch = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        recur(res, ch, 0, map, sb);
        return res;
    }

    public void recur(List<String> res, char[] ch, int index, Map<Character, String> map, StringBuilder sb) {
        //当指针指到字符串末尾时，将形成的英文字符串添加到集合res中
        if (index == ch.length) {
            res.add(sb.toString());
            return;
        }
        //取出当前字符
        char c = ch[index];
        //获取数字对应的英文字符串
        String temp = map.get(c);
        //遍历字符串，回溯每一个位置放与不放的翻译结果
        for (int i = 0; i < temp.length(); i++) {
            //向结果字符串中添加当前字符
            sb.append(temp.charAt(i));
            //递归字符串下一个位置
            recur(res, ch, index + 1, map, sb);
            //删除最后拼接到字符串中的字符
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution8 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        char[] ch = digits.toCharArray();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recur(res, ch, 0, map, new StringBuilder());
        return res;
    }

    public void recur(List<String> res, char[] ch, int index, Map<Character, String> map, StringBuilder sb) {
        if (index == ch.length) {
            res.add(sb.toString());
            return;
        }
        char c = ch[index];
        String temp = map.get(c);
        for (int j = 0; j < temp.length(); j++) {
            sb.append(temp.charAt(j));
            recur(res, ch, index + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

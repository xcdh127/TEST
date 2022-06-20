package HOT100;

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
public class Test9 {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits==null || digits.length()==0){
            return res;
        }
        Map<Character,String> map=new HashMap<>();
        char[] ch=digits.toCharArray();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        recur(res,ch,0,map,new StringBuilder());
        return res;
    }

    public void recur(List<String> res,char[] ch,int index,Map<Character,String> map,StringBuilder sb){
        //遍历到数字字符的末尾，此时形成一个翻译结果
        if (index == ch.length) {
            res.add(sb.toString());
            return;
        }
        //当前位置上的数字
        char c = ch[index];
        //数字可以翻译成的字母
        String temp = map.get(c);
        //遍历字符串，将其添加到当前结果后，进入下一个递归，并删除上次的结果
        for (int j = 0; j < temp.length(); j++) {
            sb.append(temp.charAt(j));
            recur(res, ch, index + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

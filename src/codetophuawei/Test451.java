package codetophuawei;

import java.util.*;

/*给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
示例 1:
输入: s = "tree"
输出: "eert"
解释: 'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:
输入: s = "cccaaa"
输出: "cccaaa"
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:
输入: s = "Aabb"
输出: "bbAa"
解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
提示:
1 <= s.length <= 5 * 105
s 由大小写英文字母和数字组成
*/
public class Test451 {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        //统计字符出现的次数
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        //将map键值对放进list中，自定义排序规则，按照值的大小进行排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        //按照value的值降序排列
        list.sort((a, b) -> (b.getValue() - a.getValue()));
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        //遍历链表
        for (int i = 0; i < list.size(); i++) {
            //键
            Character key = list.get(i).getKey();
            //值
            int value = list.get(i).getValue();
            //向字符串中拼接key值
            for (int j = 0; j < value; j++) {
                sb.append(key);
            }
        }
        //返回字符串
        return sb.toString();
    }
}

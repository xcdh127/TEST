package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*全字母句 指包含英语字母表中每个字母至少一次的句子。
给你一个仅由小写英文字母组成的字符串 sentence ，
请你判断 sentence 是否为 全字母句 。
如果是，返回 true ；否则，返回 false 。
*/
public class Test139 {
    public boolean checkIfPangram(String sentence) {
        //统计字符串中出现的所有的字符
        Set<Character> set=new HashSet<>();
        int n=sentence.length();
        //将当前的字符添加到set集合中
        for (int i = 0; i < n; i++) {
            set.add(sentence.charAt(i));
        }
        //如果字符的个数为26,那么此时说明这个字符串包含所有的单词表的26个字符
        return set.size()==26;
    }
}

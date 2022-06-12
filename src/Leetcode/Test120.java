package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。
请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，
那么字符串 words[i] 就是 words[j] 的一个子字符串。
*/
public class Test120 {
    public List<String> stringMatching(String[] words) {
        //去重复
        Set<String> set=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                //如果字符串i与字符串j不相等，并且字符串i包含字符串j
                if (!words[i].equals(words[j]) && words[j].contains(words[i])){
                    //将此单词放进集合
                    set.add(words[i]);
                }
            }
        }
        //将set集合放进数组中
        List<String> res=new ArrayList<>(set);
        //返回结果
        return res;
    }
}

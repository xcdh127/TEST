package Leetcode;
/*给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
请你返回 words 中是字符串 s 前缀 的 字符串数目 。
一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
*/
public class Test154 {
    public int countPrefixes(String[] words, String s) {
        int count=0;
        //遍历所有的字符串
        for (String word :words) {
            //当字符串s是以words中的单词开头的话就计数+1
            if (s.startsWith(word)){
                count++;
            }
        }
        //返回结果
        return count;
    }
}

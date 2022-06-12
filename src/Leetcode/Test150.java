package Leetcode;
/*给你一个字符串数组 patterns 和一个字符串 word ，
统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。
子字符串 是字符串中的一个连续字符序列。
*/
public class Test150 {
    public int numOfStrings(String[] patterns, String word) {
        //统计符合题意的字符串的个数
        int count=0;
        //遍历所有的字符串，统计包含在word中的单词数量
        for (String s :patterns) {
            if (word.contains(s)){
                count++;
            }
        }
        //返回结果
        return count;
    }
}

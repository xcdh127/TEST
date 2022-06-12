package Leetcode;
/*给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，
其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord
是否为句子 sentence 中任意单词的前缀。
如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标
（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标
（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
字符串 s 的 前缀 是 s 的任何前导连续子字符串。
*/
public class Test124 {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] str=sentence.split(" ");
            int n=str.length;
            //遍历所有的字符串
            for (int i = 0; i < n; i++) {
                //判断当前字符串是否是以寻找的单词为开头的单词，是返回下标+1
                if (str[i].startsWith(searchWord)){
                    return i+1;
                }
            }
            //没有就返回-1
            return -1;
        }
}

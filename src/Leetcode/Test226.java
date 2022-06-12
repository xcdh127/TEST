package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*给你一个单词序列，判断其是否形成了一个有效的单词方块。
有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数))
所显示的字符串完全相同。
注意：
给定的单词数大于等于 1 且不超过 500。
单词长度大于等于 1 且不超过 500。
每个单词只包含小写英文字母 a-z。
*/
/*输入：
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
输出：
true
解释：
第 1 行和第 1 列都是 "abcd"。
第 2 行和第 2 列都是 "bnrt"。
第 3 行和第 3 列都是 "crmy"。
第 4 行和第 4 列都是 "dtye"。
*/
/*输入：
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

输出：
true

解释：
第 1 行和第 1 列都是 "abcd"。
第 2 行和第 2 列都是 "bnrt"。
第 3 行和第 3 列都是 "crm"。
第 4 行和第 4 列都是 "dt"。

因此，这是一个有效的单词方块。
*/
/*["ball","asee","let","lep"]*/
public class Test226 {
    public static void main(String[] args) {
        List<String> res=new ArrayList<>();
        res.add("ball");
        res.add("asee");
        res.add("let");
        res.add("lep");
        validWordSquare(res);
    }
    public static boolean validWordSquare(List<String> words) {
        int size=words.size();
        for (int i = 0; i < size; i++) {
            int len=words.get(i).length();
            for (int j = 0; j < len; j++) {
                //列超过单词的个数
                if (j>=size){
                    return false;
                }
                //行超过当前单词的长度
                if (i>=words.get(j).length()){
                    return false;
                }
                //如果两个对应位置上的字符不相等，返回false
                if (words.get(i).charAt(j)!=words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
/*bool validWordSquare(char ** words, int wordsSize)
{
    for (int i = 0; i < wordsSize; i++) {
        int collen = strlen(words[i]);
        // 行和列的元素比较，需要考虑边界
        for (int j = 0; j < collen; j++) {
            // 列的长度比行长
            if (j >= wordsSize) {
                return false;
            }
            // 行的长度比列长
            if (i > strlen(words[j])) {
                return false;
            }
            if(words[i][j] != words[j][i]) {
                return false;
            }
        }
    }
    return true;
}
*/


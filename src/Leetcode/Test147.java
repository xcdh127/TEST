package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
*/
/*输入：text = "hello world", brokenLetters = "ad"
输出：1
解释：无法输入 "world" ，因为字母键 'd' 已损坏。
*/
public class Test147 {
    public int canBeTypedWords(String text, String brokenLetters) {
        //将换键存放到set集合中
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        //统计能够拼出的单词
        int count=0;
        String[] res=text.split(" ");
        //遍历所有的单词
        for (String s :res) {
            //打标记
            boolean flag=true;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))){
                    flag=false;
                    break;
                }
            }
            //可以打出，计数+1
            if (flag){
                count++;
            }
        }
        //返回结果
        return count;
    }
}

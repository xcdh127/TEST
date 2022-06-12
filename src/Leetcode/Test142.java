package Leetcode;
/*如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
子字符串 是一个字符串中连续的字符序列。
*/
public class Test142 {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        //如果字符串的铲长度小于3，直接返回0
        if (s.length()<3){
            return 0;
        }
        int count=0;
        for (int i = 2; i < n; i++) {
            //此时长度为3的字符串，每一个字符都不相同，此时计数+1
            if (!isHao(s.substring(i-2,i+1))){
                count++;
            }
        }
        //返回结果
        return count;
    }

    public boolean isHao(String s){
        //如果长度为3字符串有两个字符相同就返回false
        return s.charAt(0)==s.charAt(1) || s.charAt(1)==s.charAt(2) || s.charAt(0)==s.charAt(2);
    }
}

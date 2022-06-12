package Leetcode;
/*给你两个字符串数组 word1 和 word2 。
如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
*/
public class Test98 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //拼接字符串
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for (String s :word1) {
            sb1.append(s);
        }

        for (String s :word2) {
            sb2.append(s);
        }
        //转成字符串比较是否相等
        return sb1.toString().equals(sb2.toString());
    }
}

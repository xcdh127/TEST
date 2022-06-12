package Leetcode;
/*给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
字符串 s 要成为 words 的 前缀字符串 ，需要满足：
s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
*/
public class Test102 {
    public boolean isPrefixString(String s, String[] words) {
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            //向字符串sb中添加字符串
            sb.append(words[i]);
            //如果拼接的字符串等于s，返回true
            if (sb.toString().equals(s)){
                return true;
            }
        }
        //不能拼接成s
        return false;
    }
}

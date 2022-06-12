package Leetcode;
/*给你一个由大小写英文字母组成的字符串 s 。
一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
*/
public class Test79 {
    public String makeGood(String s) {
        //用于拼接字符串
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        //前一个元素的位置
        int retIndex=-1;
        for (int i = 0; i < n; i++) {
            //取到i位置的字符
            char ch=s.charAt(i);
            //字符串的长度大于0 前一个位置的字符和·当前位置的字符忽略大小写后相等 并且这两个字符原本不是相等的
            if (sb.length()>0 && Character.toLowerCase(sb.charAt(retIndex))==Character.toLowerCase(ch) && sb.charAt(retIndex)!=ch){
                //删掉前面的字符
                sb.deleteCharAt(retIndex);
                //指向前面的字符向前移动一位
                retIndex--;
            }
            else {
                //将当前位置的字符添加到sb中
                sb.append(ch);
                //开始指针向后移动一位
                retIndex++;
            }
        }
        //返回结果
        return sb.toString();
    }


}

class Solution112 {
    public String makeGood(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }
}


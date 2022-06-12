package Leetcode;
/*一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
*/

/*输入：s = "aaabaaaa"
输出："aabaa"*/
public class Test100 {
    public String makeFancyString(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        //如果字符串长度小于3，返回原字符串
        if (n<3)return s;
        int index=0;
        while (index<n){
            //取到index位置的字符
            char ch=s.charAt(index);
            //统计相同字符的数量
            int count=0;
            while (index<n && s.charAt(index)==ch) {
                index++;
                count++;
            }
            //当字符出现次数大于3时，将两个字符添加到sb
            if (count>=3){
                sb.append(ch);
                sb.append(ch);
            }
            //否则添加count个字符到sb中
            else {
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }
            }
        }
        //返回结果
        return sb.toString();
    }
}

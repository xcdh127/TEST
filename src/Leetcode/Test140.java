package Leetcode;
/*给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
*/
/*
输入：s = "a1c1e1t"
输出："abcdef"
解释：数字被替换结果如下：
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'
*/
public class Test140 {
    public String replaceDigits(String s) {
        int n=s.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        char ch=' ';
        if (n%2==1){
            //如果原字符串的长度是奇数
            //取出最后一个字符
            ch=s.charAt(n-1);
            //将字符串截取成偶数
            s=s.substring(0,n-1);
        }
        //用一个新数字表示新的字符串长度
        int m=s.length();
        //一次遍历原字符串的两个字符
        for (int i = 0; i < m; i+=2) {
            //取出英文字符添加到sb中
            char c=s.charAt(i);
            sb.append(c);
            //根据后面的数字替换字符添加到sb中
            c=(char)(c+s.charAt(i+1)-'0');
            sb.append(c);
        }
        //如果n是偶数
        //字符串已经遍历完成，直接输出答案
        if (n%2==0){
            return sb.toString();
        }
        //n是奇数，字符串未遍历完成，将最后一个字符拼接进来
        else {
            sb.append(ch);
            return sb.toString();
        }
    }
}
